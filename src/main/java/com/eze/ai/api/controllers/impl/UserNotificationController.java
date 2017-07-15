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

import com.eze.ai.api.models.UserNotifications;
import com.eze.ai.api.services.IUserNotificationService;
@Controller
@RequestMapping("user")
public class UserNotificationController {
	@Autowired
	private IUserNotificationService notificationService;
	@GetMapping("notification/{id}")
	public ResponseEntity<UserNotifications> getNotificationById(@PathVariable("id")Integer userId){
		UserNotifications notifications=notificationService.getNotificationById();
		return new ResponseEntity<UserNotifications>(notifications,HttpStatus.OK);	
	}
	
	@PostMapping("addNotification")
	public ResponseEntity<UserNotifications> addAllNotifications(@RequestBody UserNotifications notification,UriComponentsBuilder builder ){
		notificationService.addUserNotification(notification);
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(builder.path("notification/{id}").buildAndExpand(notification.getUserId()).toUri());
		return new ResponseEntity<UserNotifications>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("notification")
	public ResponseEntity<List<UserNotifications>> getAllNotifications(){
		List<UserNotifications> list=notificationService.getAllNotifications();
		return new ResponseEntity<List<UserNotifications>>(list,HttpStatus.OK);
		
	}
}
