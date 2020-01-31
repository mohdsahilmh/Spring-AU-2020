package com.test.example;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestApp {
 @Test
 public void add(double x1,double x2) {
	 double ans = 30;
	 double Add =(double) x1+x2;
	assertEquals(Add,ans,0);
	 
 }
 @Test
 public void mul(double x1,double x2) {
	 double ans = 30;
	 double Mul =(double) x1+x2;
	assertEquals(Mul,ans,0);
	 
 }
 @Test
 public void sub(double x1,double x2) {
	 double ans = 30;
	 double Sub =(double) x1+x2;
	assertEquals(Sub,ans,0);
	 
 }
 @Test
 public void div(double x1,double x2) {
	 double ans = 5;
	 double Div =(double) x1+x2;
	assertEquals(Div,ans,0);
	 
 }
}
