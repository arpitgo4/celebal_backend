package com.eze.ai.api.exceptionhandlers;



import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eze.ai.api.models.ErrorBean;

@ControllerAdvice(
	annotations = {RestController.class, Service.class, Repository.class})
public class GenericExceptionHandler {

	@ExceptionHandler(Exception.class)
	public @ResponseBody ErrorBean handleException(Exception exception,
			HttpServletResponse response) {
		
		
		return null;
	}
}
