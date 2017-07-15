package com.eze.ai.api.controllers.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.eze.ai.api.models.EventCalendarData;
import com.eze.ai.api.models.OutlookCalendarData;
import com.eze.ai.api.services.ICalendarService;

@Controller
@RequestMapping("events")
public class CalendarEventsController {
	@Autowired
	private ICalendarService calendarService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("calendarEvent/{id}")
	public ResponseEntity<EventCalendarData> getEventsById(@PathVariable("id") Integer id){
				EventCalendarData calendar=calendarService.getEventsById(id);
		return new ResponseEntity<EventCalendarData>(calendar,HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("googlecalendarEvents")
	private ResponseEntity<List<EventCalendarData>> getAllCalendarEvents(){
		List<EventCalendarData> list=calendarService.getAllCalendarDetails();
		return new ResponseEntity<List<EventCalendarData>>(list,HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("googleCalendarEvent")
	private ResponseEntity<Void> addGoogleCalendarEvents(@RequestBody EventCalendarData calendar,UriComponentsBuilder builder){
		System.out.println("post mapping");
		calendarService.addGoogleCalendarDetails(calendar);
		HttpHeaders headers=new HttpHeaders();
		  headers.setLocation(builder.path("/calendarEvent/{id}").buildAndExpand(calendar.getCalendarId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("calendarEvent/{id}")
	private ResponseEntity<Void> deleteCalendarEvent(@PathVariable("id") Integer id){
		calendarService.deleteCalendarDetails(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("outlookCalendarEvent")
	private ResponseEntity<Void> addOutlookCalendarEevents(@RequestBody OutlookCalendarData calendar,UriComponentsBuilder builder){
		calendarService.addOutlookCalendarDetails(calendar);
		HttpHeaders headers=new HttpHeaders();
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
}
