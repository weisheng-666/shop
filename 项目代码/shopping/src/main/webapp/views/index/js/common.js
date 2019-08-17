
//获取cookies
function getCookie(name){
	var c = document.cookie.match("\\b" + name + "=([^;]*)\\b");
	return c ? c[1] : undefined;
}

//复制字符串
function copyToClipboard(txt) {
     if(window.clipboardData) {
             window.clipboardData.clearData();
             window.clipboardData.setData("Text", txt);
     } else if(navigator.userAgent.indexOf("Opera") != -1) {
          window.location = txt;
     } else if (window.netscape) {
          try {
               netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
          } catch (e) {
               alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将'signed.applets.codebase_principal_support'设置为'true'");
          }
          var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
          if (!clip)
               return;
          var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
          if (!trans)
               return;
          trans.addDataFlavor('text/unicode');
          var str = new Object();
          var len = new Object();
          var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
          var copytext = txt;
          str.data = copytext;
          trans.setTransferData("text/unicode",str,copytext.length*2);
          var clipid = Components.interfaces.nsIClipboard;
          if (!clip)
               return false;
          clip.setData(trans,null,clipid.kGlobalClipboard);
          alert("复制成功！");
     }
}

function bgInit() {
	var t1=window.setInterval(changeBgImg, 2000);
	var bgArr = ["../images/bg1.png","../images/bg2.png","../images/bg3.png","../images/bg4.png","../images/bg5.png","../images/bg6.png",];
	var index = 0;
	function changeBgImg() {
		index++;
		if(index == bgArr.length) index = 0;
		document.getElementById("head").style.backgroundImage = "url("+bgArr[index]+")";
	}
}

function dateToTime(date) {
	var Y = date.getFullYear();
	var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1);
	var D = date.getDate()<10 ? '0'+date.getDate() : date.getDate();
	return Y+'-'+M+'-'+D;
}

function timeToDate(s){
	var t = Date.parse(s);
	if (!isNaN(t)){
		return new Date(t);
	} else {
		return new Date();
	}
}

function timestampToTime(timestamp) {
	if(timestamp == 0) return "";
	var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
	var Y = date.getFullYear() + '-';
	var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	var D = date.getDate()<10 ? '0'+date.getDate() : date.getDate();
	var h = date.getHours() + ':';
	if(date.getHours()<10) h='0'+h;
	var m = date.getMinutes() + ':';
	if(date.getMinutes()<10) m='0'+m;
	var s = date.getSeconds();
	if(date.getSeconds()<10) s='0'+s;
	//return Y+M+D+h+m+s;
	return Y+M+D;
}

//时间戳转化
function analyzeTime(keys, data) {
	for(var i=0;i<data.length;i++){
		$.each(keys, function(index, item) {
			data[i][item] = timestampToTime(data[i][item]);
		});
	}
	return data;
}

function parseTime(stringTime) {
	return Date.parse(new Date(stringTime));
}

