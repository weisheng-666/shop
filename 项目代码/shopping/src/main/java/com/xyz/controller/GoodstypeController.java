package com.xyz.controller;

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

import com.xyz.domain.Goods;
import com.xyz.domain.Goodstype;
import com.xyz.model.ResultModel;
import com.xyz.service.IGoodsService;
import com.xyz.service.IGoodstypeService;
import com.xyz.util.UpdateTool;

@Controller
@RequestMapping(value="goodstype")
public class GoodstypeController {
	@Autowired
	private IGoodstypeService goodstypeService;

	@GetMapping(value="{id}")
	public ResponseEntity<ResultModel> findOne(@PathVariable Long id) 
	{
		return new ResponseEntity<>(ResultModel.ok(goodstypeService.findById(id)), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ResultModel> findAll(Goodstype goodstype, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) 
	{
		Pageable pageable =  PageRequest.of(page-1, limit, Direction.ASC, "goodstypeId");
		return new ResponseEntity<>(ResultModel.ok(goodstypeService.findAll(goodstype, pageable)), HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(value="getAll")
	public ResponseEntity<ResultModel> findAll() 
	{
		return new ResponseEntity<>(ResultModel.ok(goodstypeService.findAll()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResultModel> save(Goodstype goodstype) 
	{
		goodstypeService.save(goodstype);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	@Autowired
	private IGoodsService goodsService;
	
	@PutMapping
	public ResponseEntity<ResultModel> update(Goodstype goodstype) 
	{
		Goodstype source = goodstypeService.findById(goodstype.getGoodstypeId());
		UpdateTool.copyNullProperties(source, goodstype);
		List<Goods> goodsList = goodsService.findByType(source.getName());
		for (Goods goods : goodsList) {
			goods.setType(goodstype.getName());
			goodsService.save(goods);
		}
		//goodsService.updateGoods(goodstype.getName(), source.getName());
		goodstypeService.save(goodstype);
		return new ResponseEntity<>(ResultModel.ok(goodstype), HttpStatus.OK);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<ResultModel> delete(@PathVariable Long id) 
	{
		goodstypeService.deleteById(id);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
}
