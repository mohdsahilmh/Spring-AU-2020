package com.session.dto;

import javax.persistence.Entity;

@Entity
public class HalfSleeve extends Shrits {
	   private int size;

	   public int getSize() {
	   	return size;
	   }

	   public void setSize(int size) {
	   	this.size = size;
	   }
}
