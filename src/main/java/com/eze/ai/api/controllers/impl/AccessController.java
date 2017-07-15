package com.eze.ai.api.controllers.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.eze.ai.api.models.Access;
import com.eze.ai.api.models.Result;
import com.eze.ai.api.services.IAccessService;

@Controller
@RequestMapping("user")
public class AccessController {
	@Autowired
	IAccessService iAccessService;
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("google_access")
	public ResponseEntity<List<Result>> addGoogleAccess(@RequestBody Access access, UriComponentsBuilder builder) throws IOException{
		System.out.println("token"+access.getAccessToken());
		iAccessService.GoogleCalendarDetail(access);
		System.out.println("token"+access.getAccessToken());
		HttpHeaders headers=new HttpHeaders();
		List<Result> list =new ArrayList<Result>();
		list.add(new Result());
		return new ResponseEntity<List<Result>>(list,headers, HttpStatus.CREATED);	
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("outlook_access")
	public ResponseEntity<List<Result>> addOutlookAccess(@RequestBody Access access, UriComponentsBuilder builder) throws IOException{
		System.out.println("token"+access.getAccessToken());
		iAccessService.OutlookCalendarDetail(access);
		HttpHeaders headers=new HttpHeaders();
		List<Result> list =new ArrayList<Result>();
		list.add(new Result());
		return new ResponseEntity<List<Result>>(list,headers, HttpStatus.CREATED);	
	}

}
