package com.example.Vehicle.Renting.Application.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Vehicle.Renting.Application.util.ErrorStructure;
import com.example.Vehicle.Renting.Application.util.ResponseStructure;

@RestControllerAdvice
public class FieldErrorExceptionHandler {
	
	@ExceptionHandler
	   public ResponseEntity<ErrorStructure<List<Map<String, Object>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		   List<Map<String, Object>> ers = ex.getAllErrors().stream()// [stream<object errror>]
					 .map(er -> (FieldError) er)//[stram<fieldError]>
					 .map(er ->  {
						 Map<String,Object> error= new HashMap<String, Object>();
						 error.put("field", er.getField());
						 error.put("rejectedValue", er.getRejectedValue());
						 error.put("message",er.getDefaultMessage());
						 return error;
					 })//[stream<Map<String, Object>]
					 .toList();//[List<map<string,obj>]

		   return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(ErrorStructure.create(HttpStatus.BAD_REQUEST.value(),"Invalid input",ers));  
	   }

}
