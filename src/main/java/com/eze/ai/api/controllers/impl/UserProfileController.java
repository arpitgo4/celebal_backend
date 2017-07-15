package com.eze.ai.api.controllers.impl;


import java.util.List;

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

import com.eze.ai.api.models.UserProfile;
import com.eze.ai.api.services.IUserProfileService;

@Controller
@RequestMapping("user")
public class UserProfileController {
	
	@Autowired
	private IUserProfileService profileService;
	@GetMapping("profile/{id}")
	public ResponseEntity<UserProfile> getProfileById(@PathVariable("id") Integer id){
		UserProfile profile=profileService.getProfileById(id);
		return new ResponseEntity<UserProfile>(profile,HttpStatus.OK);
	}
	
	@GetMapping("profile")
	public ResponseEntity<List<UserProfile>> getAllUserProfiles(){
		List<UserProfile> list=profileService.getAllUserProfiles(); 
		return new ResponseEntity<List<UserProfile>>(list,HttpStatus.CREATED);
	}
	
	
	@PostMapping("addProfile")
	public ResponseEntity<Void> addUserProfile(@RequestBody UserProfile profile,UriComponentsBuilder builder){
		boolean flag=profileService.addUserProfileDetails(profile);
		if(flag==false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(builder.path("/profile/{id}").buildAndExpand(profile.getUserId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}

}
