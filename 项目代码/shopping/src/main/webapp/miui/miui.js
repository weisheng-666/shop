;(function($) {
	$.miui = {
		//表单
		form : {
			//submit点击事件
			on: function(id, callback) {
				let btn = $("#"+id);
				btn.click(function(){
					let form = btn.parents(".miui-form");
					let inputs = form.find(".miui-input");
					//表单校验
					
					let data = {};
					let flag = 1;
					$.each(inputs, function(index, item) {
						//空值校验
						if($(item).attr("mi-verify") == "required") {
							if($(item).val() == "") {
								$(item).focus();
								$.miui.tips("必选项不能为空",'miui-ico5',true);
								flag = 0;
								return false;
							}
						}
						data[item.name] = $(item).val();
					});
					//校验通过,执行回调函数
					if(flag) callback(data);
				})
			}
		},
		//获取浏览器高度
		getWindowHeight: function() {
			if (document.compatMode == "CSS1Compat") {
				windowHeight = document.documentElement.clientHeight;
			} else {
				windowHeight = document.body.clientHeight;
			}
			return windowHeight;
		},
		//获取浏览器宽度
		getWindowWidth: function() {
			if (document.compatMode == "CSS1Compat") {
				WindowWidth = document.documentElement.clientWidth;
			} else {
				WindowWidth = document.body.clientWidth;
			}
			return WindowWidth;
		},
		//提示框
		alert: function(title, msg) {
			alert(msg);
		},
		//确认框
		confirm: function(title, msg, callback) {
			//confirm("确认吗？",callback);
		},
		//信息框
		msg: function(msg, time=3000) {
			let miui_msg = $('<div class="miui-msg">'
								+'<div class="miui-content">'+msg+'</div>'
							+'</div>');
							
			$("body").append(miui_msg);
			
			let windowHeight = this.getWindowHeight();
			let windowWidth = this.getWindowWidth();
			
			let boxHeight = miui_msg.height();
			let boxWidth = miui_msg.width();

			miui_msg.css({
				display:"none", 
				top:(windowHeight-boxHeight)/2+'px', 
				left:(windowWidth-boxWidth)/2+'px'
			});
			
			miui_msg.fadeIn(300);
			setTimeout(function(){
				miui_msg.fadeOut(300, function(){
					miui_msg.remove();
				});
			},time);
		},
		
		tips: function(msg, icon='miui-ico1', isRock=false, time=3000) {
			let miui_tips = $('<div class="miui-tips">'
								+'<div class="miui-content">'
									+'<i class="miui-ico '+icon+'"></i>'
									+msg
								+'</div>'
							+'</div>');
			$("body").append(miui_tips);
			
			let windowHeight = this.getWindowHeight();
			let windowWidth = this.getWindowWidth();
			
			let boxHeight = miui_tips.height();
			let boxWidth = miui_tips.width();
			
			miui_tips.css({
				display:"none", 
				top:(windowHeight-boxHeight)/2+'px', 
				left:(windowWidth-boxWidth)/2+'px'
			});
			
			miui_tips.fadeIn(300);
			setTimeout(function(){
				miui_tips.fadeOut(300, function(){
					miui_tips.remove();
				});
			},time);
			
			//晃动效果
			if(isRock) {
				let times = 10;
				let left = (windowWidth-boxWidth)/2;
				
				for(i=0; i<times; i++) {
					 let offset=Math.ceil((Math.random()+1)*3);
					 if(i%2==1) offset=-offset;
					 setTimeout(function(){miui_tips.css("left",left+offset+'px')}, i*30);
				}
				//复原
				setTimeout(function(){miui_tips.css("left",left)}, times*30);
			}
		},
		
		ajax: function(method,url,data={},isWait=true) {
			if(isWait) loadIndex = layer.load();
			return new Promise(function(resolve,reject){
				$.ajax({
					type: method,
					headers: {
						'Authorization':window.localStorage.token
					},
					url: url,
					data: data,
					success: function(res) {
						if(isWait) layer.close(loadIndex);
						if(res.code == 200) {
							resolve(res);
						}
						else {
							layer.msg(res.message, {icon: 2});
						}
					},
					error: function(res) {
						if(isWait) layer.close(loadIndex);
						layer.msg("您还没有登陆！",{icon: 2}, function(){
							window.location.href="login.html";
						});
					}
				});
			})
		}
	}
})(jQuery);