package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.exceptions.InvalidDataExcept;
import com.example.demo.exceptions.NotFoundExcept;

@ControllerAdvice(basePackages = {"com.example.demo.controller"})
public class ErrorController {
	
	@ResponseBody
	@ExceptionHandler(NotFoundExcept.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDTO error(NotFoundExcept e)
	{
		return new ErrorDTO(404, e.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(InvalidDataExcept.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDTO error(InvalidDataExcept e)
	{
		return new ErrorDTO(404, e.getMessage());
	}
	
	
	
}
