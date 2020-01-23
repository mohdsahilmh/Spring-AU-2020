package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accolite.idanno.Point;
import com.accolite.idanno.service.Externalservice;

public class Mainpoint {
 public static void main(String args[]) {
	 ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	 //Point p = (Point)context.getBean("p");
	 //p.disp();
	 Externalservice es = context.getBean(Externalservice.class);
	 es.getdetails();
	 
 }
}
