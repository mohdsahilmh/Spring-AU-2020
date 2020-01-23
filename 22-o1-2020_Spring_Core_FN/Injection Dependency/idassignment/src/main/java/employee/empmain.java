package employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class empmain {
  public static void main(String args[]) {
	  ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	  empdetails empd = (empdetails) context.getBean("ed");
	  empd.getdetails();
	  
  }
}
