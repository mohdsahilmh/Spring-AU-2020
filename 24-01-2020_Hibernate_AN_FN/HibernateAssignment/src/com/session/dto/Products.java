package com.session.dto;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

@Entity
@Table(name = "PRODUCT_DETAILS")
public class Products {
   @Id	
   private int id;
   
   private String name;
   
   public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@JoinColumn(name="ITEM_ID")
   @ElementCollection
   private List<FullSleeve> fslist = new ArrayList<FullSleeve>(); 
   @ElementCollection
   private List<HalfSleeve> hslist = new ArrayList<HalfSleeve>();
   @ElementCollection
   private List<Casuals> calist = new ArrayList<Casuals>();
   @ElementCollection
   private List<Sneakers> snlist = new ArrayList<Sneakers>();
   @ElementCollection
   private List<SlimFit> sf = new ArrayList<SlimFit>();
  
  
	public List<FullSleeve> getProductlist() {
	return fslist;
     }

    public void setProductlist(List<FullSleeve> pros) {
	this.fslist = pros;
     }

	public Collection<HalfSleeve> getHslist() {
		return hslist;
	}

	public void setHslist(List<HalfSleeve> hslist) {
		this.hslist = hslist;
	}

	public Collection<Casuals> getCalist() {
		return calist;
	}

	public void setCalist(List<Casuals> calist) {
		this.calist = calist;
	}

	public Collection<Sneakers> getSnlist() {
		return snlist;
	}

	public void setSnlist(List<Sneakers> snlist) {
		this.snlist = snlist;
	}

	public Collection<SlimFit> getSf() {
		return sf;
	}

	public void setSf(List<SlimFit> sf) {
		this.sf = sf;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
   
}
