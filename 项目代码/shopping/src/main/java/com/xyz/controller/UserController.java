package com.xyz.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.authorization.annotation.Authorization;
import com.xyz.authorization.annotation.CurrentUser;
import com.xyz.authorization.manager.TokenManager;
import com.xyz.config.ResultStatus;
import com.xyz.domain.Goods;
import com.xyz.domain.Item;
import com.xyz.domain.Orderform;
import com.xyz.domain.User;
import com.xyz.model.ResultModel;
import com.xyz.service.IGoodsService;
import com.xyz.service.IOrderformService;
import com.xyz.service.IUserService;
import com.xyz.util.Encryption;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
    private IUserService userService;
    
    @Autowired
    private TokenManager tokenManager;
    
    @GetMapping(value="{id}")
	public ResponseEntity<ResultModel> findOne(@PathVariable Long id) 
	{
		return new ResponseEntity<>(ResultModel.ok(userService.findById(id)), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ResultModel> findAll(User user, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) 
	{
		Pageable pageable =  PageRequest.of(page-1, limit, Direction.ASC, "id");
		return new ResponseEntity<>(ResultModel.ok(userService.findAll(user, pageable)), HttpStatus.OK);
	}
	
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ResponseEntity<ResultModel> login( String username , String password) {
    	User user = userService.findByUsername(username);
        if(user!=null) {
        //生成一个token，保存用户登录状态
        	if(Encryption.checkPassword(user, password)) {
		        //TokenModel model = tokenManager.createToken(user.getId());
		        return new ResponseEntity<>(ResultModel.ok(user), HttpStatus.OK);
        	}
        	else {
          	  return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.OK);
          }
        }
        else {
        	  return new ResponseEntity<>(ResultModel.error(ResultStatus.USER_NOT_FOUND), HttpStatus.OK);
        }
    }
    
    @Authorization
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ResponseEntity<ResultModel> logout(@CurrentUser User user) {
    	tokenManager.deleteToken(user.getId());
    	return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> register(User user) {
    	Encryption.encryptPasswd(user);
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setCreateTime(df.format(new Date()));
    	if(userService.save(user)!=null)
    		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    	else return new ResponseEntity<>(ResultModel.error(null), HttpStatus.OK);
    }
    
    @Autowired
    private IGoodsService goodsService;
    
    @RequestMapping(value="/addItem", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> addItem(Long userId, Long goodsId, int num) {
    	Goods goods = goodsService.findById(goodsId);
    	User user = userService.findById(userId);
    	Item item = new Item();
    	item.setGoods(goods);
    	item.setNum(num);
    	user.getItemList().add(item);
    	
    	userService.save(user);
    	return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }
    
    @Autowired
    private IOrderformService orderformService;
    
    @RequestMapping(value="/clearItem", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> clearItem(Long userId, String address) {
    	User user = userService.findById(userId);
    	
    	Orderform orderform = new Orderform();
    	orderform.setUser(user);
    	orderform.setItemList(user.getItemList());
    	orderform.setAddress(address);
    	orderform.setStatus(1);
    	float total = 0;
    	
    	for (Item item : user.getItemList()) {
			total += item.getGoods().getPrice() * item.getNum();
		}
    	orderform.setPrice(total);
    	
    	user.setItemList(new ArrayList<Item>());
    	userService.save(user);
    	
    	orderformService.save(orderform);
    	return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }
}
