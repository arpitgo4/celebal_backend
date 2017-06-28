package com.eze.ai.api.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.eze.ai.api.models.Signup;
import com.eze.ai.api.services.ISignUpService;

@Controller
@RequestMapping("user")
public class SignUpController {
	@Autowired
	private ISignUpService signUpService; 
	@GetMapping("signup/{id}")
	public ResponseEntity<Signup> getEmailId(@PathVariable("id") Integer id) {
		System.out.println("controller getEmail");
		Signup signup = signUpService.getEmailId(id.toString());
		return new ResponseEntity<Signup>(signup, HttpStatus.OK);
	}
	@GetMapping("signup")

	
	@PostMapping("signup")
	public ResponseEntity<Void> addSignUpDetails(@RequestBody Signup signup,UriComponentsBuilder builder){
		System.out.println("controller");
		 boolean flag = signUpService.addSignUpDetails(signup);
	        if (flag == false) {
	        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(builder.path("/signup/{id}").buildAndExpand(signup.getSignupId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}