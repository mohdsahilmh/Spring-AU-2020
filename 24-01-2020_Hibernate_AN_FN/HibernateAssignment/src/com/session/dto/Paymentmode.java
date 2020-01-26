package com.session.dto;

import java.util.*;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "PAYMENT_DETAILS")
public class Paymentmode {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  
  private String name;
  
  @ManyToMany(mappedBy = "paymentlist")
  private Collection<UserDetails> ud = new ArrayList<UserDetails>();

  public Collection<UserDetails> getUd() {
	return ud;
}

public void setUd(Collection<UserDetails> ud) {
	this.ud = ud;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
  
  
}
