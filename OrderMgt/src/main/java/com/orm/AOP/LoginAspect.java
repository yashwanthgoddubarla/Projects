package com.orm.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LoginAspect {
	@Before("execution (* com.orm.*.*.*(..))")
	public void before(JoinPoint jp)
	{
		String classname = jp.getTarget().toString();
		String methodname = jp.getSignature().getName();
		log.info("Method call has been started--"+classname+"--"+methodname);
	}
	
	@After("execution (* com.orm.*.*.*(..))")
	public void after(JoinPoint jp)
	{ 
		String classname = jp.getTarget().toString();
	    String methodname = jp.getSignature().getName();
	
		log.info("Method call has been ended--"+classname+"--"+methodname);
	}
}
