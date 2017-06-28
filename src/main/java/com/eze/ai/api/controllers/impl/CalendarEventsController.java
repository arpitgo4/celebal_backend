package com.eze.ai.api.controllers.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.eze.ai.api.models.Calendar;
import com.eze.ai.api.services.ICalendarService;

@Controller
@RequestMapping("events")
public class CalendarEventsController {
	@Autowired
	private ICalendarService calendarService;
	@GetMapping("calendarEvent/{id}")
	public ResponseEntity<Calendar> getEventsById(@PathVariable("id") Integer id){
				Calendar calendar=calendarService.getEventsById(id);
		return new ResponseEntity<Calendar>(calendar,HttpStatus.OK);
	}
	@GetMapping("calendarEvents")
	private ResponseEntity<List<Calendar>> getAllCalendarEvents(){
		List<Calendar> list=calendarService.getAllCalendarDetails();
		return new ResponseEntity<List<Calendar>>(list,HttpStatus.OK);
	}
	@PostMapping("calendarEvent")
	private ResponseEntity<Void> addCalendarEevents(@RequestBody Calendar calendar,UriComponentsBuilder builder){
		System.out.println("post mapping");
		HttpHeaders headers=new HttpHeaders();
		  headers.setLocation(builder.path("/calendarEvent/{id}").buildAndExpand(calendar.getCalendarId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	@DeleteMapping("calendarEvent/{id}")
	private ResponseEntity<Void> deleteCalendarEvent(@PathVariable("id") Integer id){
		calendarService.deleteCalendarDetails(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
