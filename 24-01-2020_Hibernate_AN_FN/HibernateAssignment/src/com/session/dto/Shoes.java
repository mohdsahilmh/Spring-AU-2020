package com.session.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "SHOES_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Shoes {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int Shoeid;

private String Brand;

public int getShoeid() {
	return Shoeid;
}

public void setShoeid(int shoeid) {
	Shoeid = shoeid;
}

public String getBrand() {
	return Brand;
}

public void setBrand(String brand) {
	Brand = brand;
}

}
