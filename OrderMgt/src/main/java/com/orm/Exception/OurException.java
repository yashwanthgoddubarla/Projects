package com.orm.Exception;

import java.sql.SQLSyntaxErrorException;
import java.util.NoSuchElementException;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OurException {
	private final static Logger log = LoggerFactory.getLogger(OurException.class);
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> ourexception(EmptyResultDataAccessException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(SQLGrammarException.class)
	public ResponseEntity<String> ourexception(SQLGrammarException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(SQLSyntaxErrorException.class)
	public ResponseEntity<String> ourexception(SQLSyntaxErrorException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> ourexception(NoSuchElementException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception ex)
	{
		//log.info("Iam at"+log.getName()+ex.getMessage());
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<String> orderexception(OrderException e)
	{
		//log.info(log.getName()+e.getMessage());
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
