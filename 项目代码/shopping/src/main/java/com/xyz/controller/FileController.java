package com.xyz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyz.config.ResultStatus;
import com.xyz.model.ResultModel;
import com.xyz.util.FileUploadUtil;

@Controller
public class FileController {

	@PostMapping
	@RequestMapping(value = "/secure/uploadfile/{module}/{name}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<ResultModel> uploadFiles(HttpServletRequest request, @PathVariable("module") String module,  @PathVariable("name") String name) {
		// 创建list集合用于获取文件上传返回路径名
		List<String> list = new ArrayList<String>();
		try {

			// 获取上传完文件返回的路径,判断module模块名称是否为空，如果为空则给default作为文件夹名
			list = FileUploadUtil.uploadFile(request,  (name == null || name.length() == 0) ? "default" : name, (module == null || module.length() == 0) ? "default" : module);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ResultModel.error(ResultStatus.FILE_UPLOAD_ERROR), HttpStatus.OK);

		}
		return new ResponseEntity<>(ResultModel.ok(list), HttpStatus.OK);
	}
	
	
}
