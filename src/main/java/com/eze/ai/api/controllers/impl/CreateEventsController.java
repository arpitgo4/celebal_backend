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

import com.eze.ai.api.models.CreateEvents;
import com.eze.ai.api.models.Result;
import com.eze.ai.api.services.ICreateEventService;

@Controller
@RequestMapping("event")
public class CreateEventsController {
	
	
	@Autowired
	private ICreateEventService eventService;
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("createEvents/{id}")
	public ResponseEntity<CreateEvents> getEventById(@PathVariable("id") Integer id){
		CreateEvents events=eventService.getEventById(id);
		return new ResponseEntity<CreateEvents>(events,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("createEvents")
	public ResponseEntity<List<CreateEvents>> getAllEvents(){
		List<CreateEvents> list=eventService.getAllEvents();
		return new ResponseEntity<List<CreateEvents>>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("createEvent")
	public ResponseEntity<List<Result>> addAllEvents(@RequestBody CreateEvents event,UriComponentsBuilder builder){
		boolean flag=eventService.addAllEvents(event);
		System.out.println("flag="+flag);
		if(flag==false){
			return new ResponseEntity<List<Result>>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(builder.path("/event/{id}").buildAndExpand(event.getEventId()).toUri());
		List<Result> list =new ArrayList<Result>();
		list.add(new Result());
		return new ResponseEntity<List<Result>>(list,headers,HttpStatus.CREATED);
	} 

}
