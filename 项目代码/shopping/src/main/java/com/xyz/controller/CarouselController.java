package com.xyz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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

import com.xyz.domain.Carousel;
import com.xyz.model.ResultModel;
import com.xyz.service.ICarouselService;
import com.xyz.util.UpdateTool;

@Controller
@RequestMapping(value="carousel")
public class CarouselController {
	@Autowired
	private ICarouselService carouselService;

	@GetMapping(value="{id}")
	public ResponseEntity<ResultModel> findOne(@PathVariable Long id) 
	{
		Carousel carousel = carouselService.findById(id);
		return new ResponseEntity<>(ResultModel.ok(carousel), HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(value="getMaxId")
	public ResponseEntity<ResultModel> getMaxId() 
	{
		List<Carousel> list = carouselService.findAll();
		Long maxId = 0L;
		if(list.size() > 0L) maxId = list.get(list.size()-1).getCarouselId();
		return new ResponseEntity<>(ResultModel.ok(maxId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ResultModel> findAll(Carousel carousel, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) 
	{
		List< Order> orders=new ArrayList< Order>();
		orders.add(new Order(Direction.ASC, "sortNum"));
		orders.add(new Order(Direction.ASC, "carouselId"));
		@SuppressWarnings("deprecation")
		Pageable pageable =  PageRequest.of(page-1, limit, new Sort(orders));
		return new ResponseEntity<>(ResultModel.ok(carouselService.findAll(carousel, pageable)), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResultModel> save(Carousel carousel, @RequestParam(defaultValue = "") String subCarouselIds) 
	{
		carouselService.save(carousel);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<ResultModel> update(Carousel carousel, @RequestParam(defaultValue = "") String subCarouselIds) 
	{
		Carousel source = carouselService.findById(carousel.getCarouselId());
		UpdateTool.copyNullProperties(source, carousel);
		carouselService.save(carousel);
		return new ResponseEntity<>(ResultModel.ok(carousel), HttpStatus.OK);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<ResultModel> delete(@PathVariable Long id) 
	{
		carouselService.deleteById(id);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
}
