package com.orm.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {
	@Around("execution (* com.orm.*.*.*(..))")
	public Object measureExecutionTime(ProceedingJoinPoint jp)
	{
		long starttime = System.currentTimeMillis();
		String classname = jp.getTarget().toString();
		String methodname = jp.getSignature().getName();
		Object p = null;
		try {
			p = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endtime = System.currentTimeMillis();
		long executionTime = endtime-starttime;
		
		log.info("Aspect time taken to execute the given method"+classname+"--"+methodname+"--"+executionTime);
		return p;
	}

}
