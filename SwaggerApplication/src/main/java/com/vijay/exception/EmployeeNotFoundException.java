package com.vijay.exception;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6465344365559295156L;
	/**
	 * 
	 */
	
	public  EmployeeNotFoundException()
	{
		super();
	}
	public  EmployeeNotFoundException(String message)
	{
		super(message);
	}

}
