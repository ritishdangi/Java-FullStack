package com.dollop.app.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dollop.app.exception.EmployeeNotFound;
import com.dollop.app.exception.LeaveApplicationNotFound;
import com.dollop.app.model.MyErrorResponse;

@RestControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<MyErrorResponse> showCustom(EmployeeNotFound empl){
		return new ResponseEntity<MyErrorResponse>(new MyErrorResponse(new Date().toString(),"Exception in process",500,empl.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(LeaveApplicationNotFound.class)
	public ResponseEntity<MyErrorResponse> show(LeaveApplicationNotFound leave){
		return new ResponseEntity<MyErrorResponse>(new MyErrorResponse(new Date().toString(),"Exception in process",500,leave.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
