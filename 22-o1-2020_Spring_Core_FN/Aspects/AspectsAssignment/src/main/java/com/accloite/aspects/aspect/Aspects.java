package com.accloite.aspects.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspects {
	long st,et;
	  @Before("execution(* com.accolite.aspects.service.EmployeeService.getempdetails(..))")
	     public void start(JoinPoint joinPoint) {
	    	 System.out.println("started");
	    	 this.st = System.nanoTime();
	     }
	  @After("execution(* com.accolite.aspects.service.EmployeeService.getempdetails(..))")
	  public void end() {
		  long t = System.nanoTime()-this.st;
		  System.out.println("Time to Excute "+ t);
		  System.out.println("Ended"); 
	  }
}
