package com.accolite.aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accolite.aspects.service.EmployeeService;



public class Main {
   public static void main(String args[]) {
	   ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	   EmployeeService es = context.getBean(EmployeeService.class);
       es.getempdetails();
   }
}
