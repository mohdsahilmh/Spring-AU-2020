package com.session.hibernate;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.session.dto.DeliveryAddress;
import com.session.dto.FullSleeve;
import com.session.dto.HalfSleeve;
import com.session.dto.Joggers;
import com.session.dto.Membership;
import com.session.dto.Paymentmode;
import com.session.dto.Products;
import com.session.dto.SlimFit;
import com.session.dto.Sneakers;
import com.session.dto.UserDetails;

public class HibernateApp {
  public static void main(String args[]) {
	  /*I HAVE WRITTEN INITIAL CONDITION ONLY FOR FULLSLEEVE CLASS AND SLIM FIT PANT
	   * UPDATING AND DELETION FOR SHIRTS
	   BECAUSE I HAVE IMPLEMENTED ALL THE INHERITENCE AND ALL TYPE OF MAPPINGS IN ONE WHOLE SHOPPING CART PROJECT*/
	    UserDetails user = new UserDetails();
	    Products pro =new Products();
	    FullSleeve fs = null;
	    SlimFit sf =null;
	    List<Products> prods = new ArrayList<Products>();
	    List<FullSleeve> pros = new ArrayList<FullSleeve>();
	    List<SlimFit> pros1 = new ArrayList<SlimFit>();
	    List<Sneakers> pros2 = new ArrayList<Sneakers>();
	    SessionFactory  sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//	    user.setId(3);
//	    user.setName("sahil");
//	    DeliveryAddress delivery_address = new DeliveryAddress();
//	    delivery_address.setStreet("kormangala");
//	    delivery_address.setPincode("560053");
//	    user.setDelivery_address(delivery_address);
	    UserDetails user2 = new UserDetails();
	    int i=1;
	    while(i==1) {
	    	System.out.println("1.Buy product 2.Update product 3.view products 4.delete product");
	    	Scanner sc = new Scanner(System.in);
	    	int n = sc.nextInt();
	    	if(n==1) {
	    		System.out.println("Enter user id and name");
	    		int id = sc.nextInt();
	    		String name = sc.next();
	    		System.out.println("Enter the delivery address and pincode");
	    		String add = sc.next();
	    		String pin = sc.next();
	    		user2.setId(id);
	    		user2.setName(name);
	    		DeliveryAddress delivery_address = new DeliveryAddress();
	    		delivery_address.setStreet(add);
	    		delivery_address.setPincode(pin);
	    		user2.setDelivery_address(delivery_address);
	    		System.out.println("Do you want membership,each user can have only one membership(yes/no)");
	    		String ans=sc.next();
	    		if(ans.equals("yes")) {
	    			Membership mg = new Membership();
	    		    mg.setPrize("3000");
	    		    mg.setDiscount("20%");
	    		    user2.setMembership(mg);
	    		    session.save(mg);
	    		}
	    		//do not enter the number
	    		System.out.println("Enter the payment mode 1.UPI 2.Wallet 3.Netbanking 4.COD");
	    		String res = sc.next();
	    	    Paymentmode pm = new Paymentmode();
	    	    pm.setName(res);
	    	    List<UserDetails> u = new ArrayList<UserDetails>();
	    	    u.add(user);
	    	    pm.setUd(u);
	    	    List<Paymentmode> p = new ArrayList<Paymentmode>();
	    	    p.add(pm);
	    	    user2.setPaymentlist(p); 
	    	    session.save(pm);
	    	    System.out.println("Available products are 1.shirt 2.pants 3.shoes");
	    	    int n1 = sc.nextInt();
	    	    pro.setId(1);
	    	    if(n1==1) {
	    	    	pro.setName("Shirt");
	    	    	System.out.println("1.Fullsleeve 2.halfsleeve");
	    	    	int c = sc.nextInt();
	    	    	if(c==1) {
	    	    		fs = new FullSleeve();
	    	    	    System.out.println("enter shirt id and brand name,and size");
	    	    	    int sid = sc.nextInt();
	    	    	    String bname = sc.next();
	    	    	    int size = sc.nextInt();
	    	    	    fs.setId(sid);
	    	    	    fs.setBrand(bname);
	    	    	    fs.setSize(size);
	    	    	    pros.add(fs);
	    	    	    pro.setProductlist(pros);
	    	    	    prods.add(pro);
	    	    	    user2.setProducts(prods);
	    	    		session.save(pro);
	    	         	session.save(fs);
	    	    	}else {
	    	    		HalfSleeve hs = new HalfSleeve();
	    	    	}
	    	    }
	    	    else if(n1==2) {
	    	    	pro.setName("Pant");
	    	    	System.out.println("1.SlimFit 2.Joggers");
	    	    	int c = sc.nextInt();
	    	    	if(c==1) {
    	    		System.out.println("enter Pant id and brand name,and size");
    	    		int pid = sc.nextInt();
    	    	    String bname = sc.next();
    	    	    int size = sc.nextInt();
	    	    	sf = new SlimFit();
	    	    	sf.setId(pid);
	    	 	    sf.setBrandname(bname);
	    	 	    sf.setSize(size);
	    	 	    pros1.add(sf);
	    	 	    pro.setSf(pros1);
	    	 	    prods.add(pro);
	    	 	    user2.setProducts(prods);
	    	 	    session.save(pro);
	    	    	session.save(sf);
	    	    	}
	    	    	else {
	    	    		Joggers jg = new Joggers();
	    	    	}
	    	    }
	    	    else {
	    	    	//Sneakers sn = new Sneakers();
	    	    }
	    	    session.save(user2);
	    	    session.getTransaction().commit();
	    	    }
	    	else if(n==3) {
	    		Query query = session.createQuery("from UserDetails");
	    		List<UserDetails> users = (List<UserDetails>)query.list();
	    		for(UserDetails list : users) {
	    			System.out.println(list.getName()+" "+list.getDelivery_address().getStreet()+" "+list.getDelivery_address().getPincode()+" ");
	    			for(Paymentmode p : list.getPaymentlist()) {
	    				System.out.println(p.getName()+" ");
	    			}
	    			for(Products p:list.getProducts()) {
	    				System.out.println(p.getName()+" "+p.getId()+" ");
	    				for(int j=0;j<p.getProductlist().size();j++) {
	    					System.out.println(p.getProductlist().get(j).getBrand()+"  "+p.getProductlist().get(j).getSize());
	    				}
	    			}
	    			
	    		}
	    	}
	    	else if(n==2) {
	    		Query query = session.createQuery("from Products");
	    		List<Products> prod = (List<Products>)query.list();
	    		for(Products p :prod) {
	    			System.out.println(p.getId()+" "+p.getName()+" ");
	    			for(int j=0;j<p.getProductlist().size();j++) {
    					System.out.println(p.getProductlist().get(j).getBrand()+"  "+p.getProductlist().get(j).getSize());
    				}
	    		}
	    		//FullSleeve f = new FullSleeve();
	    		System.out.println("1.update brand 2.update size");
	    		if(sc.nextInt()==1) {
	    			String brand = sc.next();
	    			fs.setBrand(brand);
	    		}else {
	    			int size = sc.nextInt();
	    			fs.setSize(size);
	    		}
	    		 session.save(fs);
	    		 session.save(user2);
		    	 //session.getTransaction().commit();
	    	}else if(n==4) {
	    		Query query = session.createQuery("from Products");
	    		List<Products> prod = (List<Products>)query.list();
	    		for(Products p :prod) {
	    			System.out.println(p.getId()+" "+p.getName()+" "+p.getProductlist());
	    		}
	    		int pid = sc.nextInt();
	    		Query q= session.createQuery("delete Products where id =:ID");
	    		query.setParameter("ID", pid);
	    		int result = query.executeUpdate();
	    		// session.save(user2);
		    	    session.getTransaction().commit();
		    		session.close();
	    		if (result > 0) {
	    		    System.out.println(" products was removed");
	    		}
	    	}else {
	    		i=0;
	    		session.close();
	    	}
	    }
	   
	    // pro.setId(2);
	   
	    
//	    Sneakers sn = new Sneakers();
//	    pro.setId(100);
//	    sn.setShoeid(3);
//	    sn.setBrand("addidas");
//	    sn.setSize(34);
//	    pros2.add(sn);
//	    pro.setSnlist(pros2);
//	    prods.add(pro);
//	    user2.setProducts(prods);
	    
	    
		
//	  
		//session.save(user);
		session.save(pro);
    	
    	session.getTransaction().commit();
    	session.close();
//		session.save(sn);
  }
}
