package com.session.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	private int id;
	
	private String name;

	@Embedded
	@AttributeOverrides(
			{@AttributeOverride(name="street",column=@Column(name="DELIVERY_STREET")),
	        @AttributeOverride(name="pincode",column=@Column(name="DELIVERY_PIN"))
	})
	
	private DeliveryAddress delivery_address;
	
	@OneToOne
	@JoinColumn(name = "MEMBERSHIP_ID")
	private Membership membership;
	
	@OneToMany
	@JoinTable(
	        name="PRODUCTS",
	        joinColumns=@JoinColumn(name="USER_ID"),
	        inverseJoinColumns=@JoinColumn(name="PRODUCT_ID"))
	@ElementCollection
	private Collection<Products> products = new ArrayList<Products>();
	
	@ManyToMany
	@ElementCollection
	@JoinColumn(name = "PAYMENT_ID")
	private Collection<Paymentmode> paymentlist = new ArrayList<Paymentmode>();
	
	public DeliveryAddress getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(DeliveryAddress delivery_address) {
		this.delivery_address = delivery_address;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public Collection<Products> getProducts() {
		return products;
	}

	public void setProducts(Collection<Products> products) {
		this.products = products;
	}

	public Collection<Paymentmode> getPaymentlist() {
		return paymentlist;
	}

	public void setPaymentlist(Collection<Paymentmode> paymentlist) {
		this.paymentlist = paymentlist;
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
