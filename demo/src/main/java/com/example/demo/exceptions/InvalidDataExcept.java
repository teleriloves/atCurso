package com.example.demo.exceptions;

public class InvalidDataExcept extends Exception{
	

	private static final long serialVersionUID = 1L;
	
	private static final String errorMsg = "Entidad no encontrada";
	
	public InvalidDataExcept(String msg)
	{
		super(msg);
	}
	
	public InvalidDataExcept()
	{
		super(errorMsg);
	}
}
