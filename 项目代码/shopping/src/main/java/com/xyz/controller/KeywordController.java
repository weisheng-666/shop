package com.xyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.domain.Keyword;
import com.xyz.model.ResultModel;
import com.xyz.service.IKeywordService;
import com.xyz.util.UpdateTool;

@Controller
@RequestMapping(value="keyword")
public class KeywordController {
	@Autowired
	private IKeywordService keywordService;

	@GetMapping(value="{id}")
	public ResponseEntity<ResultModel> findOne(@PathVariable Long id) 
	{
		Keyword keyword = keywordService.findById(id);
		return new ResponseEntity<>(ResultModel.ok(keyword), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResultModel> update(Keyword keyword, @RequestParam(defaultValue = "") String subKeywordIds) 
	{
		Keyword source = keywordService.findById(keyword.getKeywordId());
		UpdateTool.copyNullProperties(source, keyword);
		keywordService.save(keyword);
		return new ResponseEntity<>(ResultModel.ok(keyword), HttpStatus.OK);
	}
}
