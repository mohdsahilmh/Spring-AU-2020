package com.session.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "SHRIT_DETAILS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Shrits {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
	
	private String Brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}
	
	
}
