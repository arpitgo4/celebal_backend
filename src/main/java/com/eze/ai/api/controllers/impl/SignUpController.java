package com.eze.ai.api.controllers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.eze.ai.api.models.Result;
import com.eze.ai.api.models.Signup;
import com.eze.ai.api.services.ISignUpService;

@Controller
@RequestMapping("user")
public class SignUpController {
	@Autowired
	private ISignUpService iSignUpService; 
	
	//@CrossOrigin(origins = "http://localhost:3000")
	
	@PostMapping("signup")
	public ResponseEntity<List<Result>> addSignUpDetails(@RequestBody Signup signup,UriComponentsBuilder builder){
		System.out.println("email="+signup.getEmailId());
		 boolean flag = iSignUpService.addSignUpDetails(signup);
		 System.out.println("after boolean");
	        if (flag == false) {
	        	return new ResponseEntity<List<Result>>(HttpStatus.CONFLICT);
	        }
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(builder.path("/signup/{id}").buildAndExpand(signup.getSignupId()).toUri());
	        System.out.println("final");
	        List<Result> list =new ArrayList<Result>();
			list.add(new Result());
	        return new ResponseEntity<List<Result>>(list,headers, HttpStatus.CREATED);
	}
	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("signup/{id}")
	public ResponseEntity<Signup> getEmailId(@PathVariable("id") Integer id) {
		System.out.println("controller getEmail");
		Signup signup = iSignUpService.getEmailId(id.toString());
		return new ResponseEntity<Signup>(signup, HttpStatus.OK);
	}

	//@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("signin")
	public ResponseEntity<List<Result>> SignIn(@RequestBody Signup signup,UriComponentsBuilder builder){
		boolean flag = iSignUpService.SignIn(signup);
		List<Result> list =new ArrayList<Result>();
		list.add(new Result());
		if(flag==false){
			return new ResponseEntity<List<Result>>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Result>>(list,headers, HttpStatus.CREATED);
	}
	

}