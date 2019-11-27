package com.bitacademy.myportal.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.myportal.service.FileuploadService;

@Controller
@RequestMapping("fileupload")
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@Autowired
	FileuploadService fileUploadService;
	
	@RequestMapping("/form")
	public String form() {
		return "fileupload/form";
	}
	
//	@ResponseBody
	@RequestMapping(value="/upload", method= RequestMethod.POST)
	public String upload(@RequestParam("file1") MultipartFile file1, Model model) {
		logger.debug("MultipartFile:" + file1);
		
		String uploadFilename = fileUploadService.store(file1);
		model.addAttribute("imageFilename",uploadFilename);
		
		return "fileupload/result";
	}
	
	
	
}


















