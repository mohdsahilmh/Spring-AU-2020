package com.accolite.aspects.service;

import org.springframework.stereotype.Component;

import com.accolite.aspects.model.Employee;

import java.util.*;
@Component
public class EmployeeService {
   HashMap<Integer,Employee> map = new HashMap<Integer,Employee>();
   Random r = new Random();
   EmployeeService(){
	   int i=1;
	   System.out.println("1.enter the name and age 2.exit");
	   Scanner sc = new Scanner(System.in); 
	   while(i==1) {
		   String name = sc.next();
		   int age = sc.nextInt();
		   map.put(r.nextInt(100),new Employee(name,age));
		   System.out.println("1.enter the name and age 2.exit");
		   i = sc.nextInt();
	   }
   }
   public void getempdetails() {
	   for(Map.Entry<Integer, Employee> e:map.entrySet())  {
		   System.out.println("EMP ID : "+e.getKey()+" EMP NAME : "+e.getValue().name +" EMP AGE : "+e.getValue().age);
	   }
   }
}
