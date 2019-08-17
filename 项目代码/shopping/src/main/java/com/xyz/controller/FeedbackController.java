package com.xyz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.xyz.domain.Feedback;
import com.xyz.model.ResultModel;
import com.xyz.service.IFeedbackService;
import com.xyz.util.UpdateTool;

@Controller
@RequestMapping(value="feedback")
public class FeedbackController {
	@Autowired
	private IFeedbackService feedbackService;

	@GetMapping(value="{id}")
	public ResponseEntity<ResultModel> findOne(@PathVariable Long id) 
	{
		Feedback feedback = feedbackService.findById(id);
		return new ResponseEntity<>(ResultModel.ok(feedback), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ResultModel> findAll(Feedback feedback, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) 
	{
		Pageable pageable =  PageRequest.of(page-1, limit, Direction.ASC, "feedbackId");
		return new ResponseEntity<>(ResultModel.ok(feedbackService.findAll(feedback, pageable)), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResultModel> save(Feedback feedback, @RequestParam(defaultValue = "") String subFeedbackIds) 
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		feedback.setCreateTime(df.format(new Date()));
		feedbackService.save(feedback);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<ResultModel> update(Feedback feedback, @RequestParam(defaultValue = "") String subFeedbackIds) 
	{
		Feedback source = feedbackService.findById(feedback.getFeedbackId());
		UpdateTool.copyNullProperties(source, feedback);
		feedbackService.save(feedback);
		return new ResponseEntity<>(ResultModel.ok(feedback), HttpStatus.OK);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<ResultModel> delete(@PathVariable Long id) 
	{
		feedbackService.deleteById(id);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
}
