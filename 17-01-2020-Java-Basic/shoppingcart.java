import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class shoppingcart {
    static ArrayList<products> cart = new ArrayList<products>();
    static ArrayList<products> pro = new ArrayList<>();
    static ArrayList<order> od = new ArrayList<>();
	static int sum = 0;
    static Random random = new Random();
	public static void main(String[] args) {
	pro.add(new products(102,"vivo v5",10,15000));
	pro.add(new products(103,"jack and jones T-shirts",15,700));
	pro.add(new products(104,"levis jeans",20,2500));
	int x=1;
	while(x==1) {
		System.out.println("1. Add a product to the cart\r\n" + 
				"2. Remove a product from the cart\r\n" + 
				"3. View the items in the cart\r\n" + 
				"4. Place the order\r\n" + 
				"5. Cancel the order \n"
				+ "6.Exit");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) {
			addtocart();
		}
		else if(n==2) {
			removefromcart();
		}
		else if(n==3) {
			viewcart();
		}
		else if(n==4) {
			System.out.println("Enter the username");
			String username = sc.next();
			placeorder(username);
		}
		else if(n==5) {
			cancelorder();
		}
		else {
			x=0;
		}
	}
	}
	static void addtocart(){
		    int i=0;
		    System.out.println("Available Products are:");  
          	for(products p : pro){
              System.out.println("Product id: "+p.pid+"  "+"Product Name: "+p.pname+"  "+"Product Quantity: "+p.pq+"  "+"Product Price:"+p.pp+"");
          	}
          	System.out.println();
          	System.out.println("Enter the Product Id and Quantity to add to cart");
          	Scanner sc = new Scanner(System.in);
          	int in = sc.nextInt();
          	int q = sc.nextInt();
          	for(products p:pro){
          		if(in==p.pid) {
          			if(p.pq>=q) {
          				cart.add(new products(p.pid,p.pname,q,q*p.pp));
          			}else {
          				System.out.println("Product Not Available");
          			}
          		}
          	}
	}
	static void viewcart() {
		System.out.println("items in the cart:");
		for(products p : cart){
            System.out.println("Product id: "+p.pid+"  "+"Product Name: "+p.pname+"  "+"Product Quantity: "+p.pq+"  "+"Product Price:"+p.pp+" ");          		
        	}
	}
	static void removefromcart() {
		viewcart();
		System.out.println("Enter the Product Id to Remove from cart");
      	Scanner sc = new Scanner(System.in);
      	int in = sc.nextInt();
      	for(int i=0;i<cart.size();i++){
      		if(in==cart.get(i).pid) {
      			if(cart.get(i).pq>1) {
      				cart.get(i).pp =cart.get(i).pp-(cart.get(i).pp/cart.get(i).pq);
      				cart.get(i).pq = cart.get(i).pq-1;
      			}
      			else {
               cart.remove(cart.indexOf(cart.get(i)));
               }
      		}
      	}
      	System.out.println("item removed and cart has:");
      	viewcart();
	}
	static void placeorder(String name) {
		viewcart();
		System.out.println("placing the order...");
	
		for(products p:cart){
      	  sum = sum+p.pp;
      	}
		int odid = random.nextInt(1000);
		od.add(new order(odid,name,pro));
		System.out.println("order placed with total amount : "+sum+" and order id :"+odid+" ");
		cart.clear();
	}
	static void cancelorder() {
		for(order o : od) {
			System.out.println("Order id: "+o.id+"  "+"User Name: "+o.name+" ");
			for(products p:pro) {
				System.out.println("Product Name: "+p.pname+" "+"Product Quantity:"+p.pq+"Product Price :"+p.pp);
			}
		}
		System.out.println("Enter the order id to cancel the order:");
      	Scanner sc = new Scanner(System.in);
      	int in = sc.nextInt();
      	for(int i=0;i<od.size();i++) {
      		if(in==od.get(i).id) {
      			od.remove(od.indexOf(od.get(i)));
      		}
		}
      	System.out.println("order cancelled and refund of "+sum+" is initiated");
	}

}
