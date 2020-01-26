package com.session.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "PANT_DETAILS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pants {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
	private int id;
    
    private String Brandname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandname() {
		return Brandname;
	}

	public void setBrandname(String brandname) {
		Brandname = brandname;
	}
    
}
