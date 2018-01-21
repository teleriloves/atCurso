package com.example.demo.exceptions;

public class NotFoundExcept extends Exception{

	private static final long serialVersionUID = 1L;
	
	private static final String errorMsg = "Entidad no encontrada";
	
	public NotFoundExcept(String msg)
	{
		super(msg);
	}
	
	public NotFoundExcept()
	{
		super(errorMsg);
	}
	
	
	
	

}
