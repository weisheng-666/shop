package com.xyz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.domain.Orderform;
import com.xyz.model.ResultModel;
import com.xyz.service.IOrderformService;
import com.xyz.util.UpdateTool;

@Controller
@RequestMapping(value="orderform")
public class OrderformController {
	@Autowired
	private IOrderformService orderformService;

	@GetMapping(value="{id}")
	public ResponseEntity<ResultModel> findOne(@PathVariable Long id) 
	{
		return new ResponseEntity<>(ResultModel.ok(orderformService.findById(id)), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ResultModel> findAll(Orderform orderform, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) 
	{
		Pageable pageable =  PageRequest.of(page-1, limit, Direction.ASC, "orderformId");
		return new ResponseEntity<>(ResultModel.ok(orderformService.findAll(orderform, pageable)), HttpStatus.OK);
	}
	
	@GetMapping(value="/findAll/{userId}")
	public ResponseEntity<ResultModel> findAll(@PathVariable int userId) 
	{
		List<Orderform> list = orderformService.findAll();
		List<Orderform> list2 = new ArrayList<Orderform>();
		for (Orderform item : list) {
			if(item.getUser().getId() == userId) list2.add(item);
		}
		return new ResponseEntity<>(ResultModel.ok(list2), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResultModel> save(Orderform orderform) 
	{
		orderformService.save(orderform);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<ResultModel> update(Orderform orderform) 
	{
		Orderform source = orderformService.findById(orderform.getOrderformId());
		source.setStatus(orderform.getStatus());
		orderformService.save(source);
		return new ResponseEntity<>(ResultModel.ok(source), HttpStatus.OK);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<ResultModel> delete(@PathVariable Long id) 
	{
		orderformService.deleteById(id);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
}
