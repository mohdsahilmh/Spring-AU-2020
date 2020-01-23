package com.accolite.idanno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.accolite.idanno.Point;

@Service
public class Externalservice {
  @Autowired
  Point p1;
  
  public void getdetails() {
	 p1.disp();
  }
}
