package com.xyz.controller;

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

import com.xyz.domain.Goods;
import com.xyz.model.ResultModel;
import com.xyz.service.IGoodsService;
import com.xyz.util.UpdateTool;

@Controller
@RequestMapping(value="goods")
public class GoodsController {
	@Autowired
	private IGoodsService goodsService;

	@GetMapping(value="{id}")
	public ResponseEntity<ResultModel> findOne(@PathVariable Long id) 
	{
		return new ResponseEntity<>(ResultModel.ok(goodsService.findById(id)), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ResultModel> findAll(Goods goods, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) 
	{
		Pageable pageable =  PageRequest.of(page-1, limit, Direction.ASC, "goodsId");
		return new ResponseEntity<>(ResultModel.ok(goodsService.findAll(goods, pageable)), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResultModel> save(Goods goods) 
	{
		goodsService.save(goods);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<ResultModel> update(Goods goods) 
	{
		Goods source = goodsService.findById(goods.getGoodsId());
		UpdateTool.copyNullProperties(source, goods);
		goodsService.save(goods);
		return new ResponseEntity<>(ResultModel.ok(goods), HttpStatus.OK);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<ResultModel> delete(@PathVariable Long id) 
	{
		goodsService.deleteById(id);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
}
