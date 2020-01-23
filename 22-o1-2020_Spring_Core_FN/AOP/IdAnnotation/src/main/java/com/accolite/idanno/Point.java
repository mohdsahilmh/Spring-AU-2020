package com.accolite.idanno;

public class Point {
    int x;
    int y;
    Point(int x,int y){
    	this.x=x;
    	this.y=y;
    }
    public void disp() {
    	System.out.println("X value : "+x+" Y value : "+y);
    }
}
