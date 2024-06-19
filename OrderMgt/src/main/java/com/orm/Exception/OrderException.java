package com.orm.Exception;

import org.springframework.stereotype.Component;

@Component
public class OrderException extends Exception{
	
	public OrderException()
	{
		super( "please check the database");
	}
	
	public OrderException(String message)
	{
		super( "please check the database");

		
	}
	

}
