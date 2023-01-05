package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		
		log.info("==================");
	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		
		log.info("Target: " + pjp.getTarget());
		log.info("Param: " + Arrays.toString(pjp.getArgs()));
		
		//invoke method
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		long end = System.currentTimeMillis();
		
		log.info("TIME: " + (end - start));
		
		return result;
	}
	
	@After("execution(* org.zerock.service.SampleService*.*(..))")
	public void logAfter() {
		log.info("==================");
	}
}