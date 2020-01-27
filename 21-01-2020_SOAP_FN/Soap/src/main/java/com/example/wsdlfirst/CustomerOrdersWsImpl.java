package com.example.wsdlfirst;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.cxf.feature.Features;

import com.akash.ws.trainings.CreateOrdersRequest;
import com.akash.ws.trainings.CreateOrdersResponse;
import com.akash.ws.trainings.CustomerOrdersPortType;
import com.akash.ws.trainings.DeleteOrdersRequest;
import com.akash.ws.trainings.DeleteOrdersResponse;
import com.akash.ws.trainings.GetOrdersRequest;
import com.akash.ws.trainings.GetOrdersResponse;
import com.akash.ws.trainings.Order;
import com.akash.ws.trainings.Product;
import com.akash.ws.trainings.UpdateOrdersRequest;
import com.akash.ws.trainings.UpdateOrdersResponse;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType{

	Map<BigInteger,List<Order>> customerOrders=new HashMap<>();
	int currenntId;
	
	public CustomerOrdersWsImpl() {
		init();
	}
	
	public void init() {
		List<Order> orders=new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		
		Product product=new Product();
		product.setId("1");
		product.setDescription("Amul");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		orders.add(order);
		
		customerOrders.put(BigInteger.valueOf(++currenntId), orders);
	}
	
	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
		GetOrdersResponse response=new GetOrdersResponse();
		response.getOrder().addAll(orders);
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		Order order=request.getOrder();
		List<Order> orders=customerOrders.get(customerId);
		orders.add(order);
		CreateOrdersResponse response=new CreateOrdersResponse();
		response.setResult(true);
 		return response;
	}

	@Override
	public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
		Scanner sc = new Scanner(System.in);

		BigInteger customerid = request.getCustomerId();
		BigInteger orderid = request.getOrderId();
		List<Order> orders = customerOrders.get(customerid);
		 for(Order o:orders) {
		        System.out.println("order id:"+o.getId());
		        }
		  BigInteger id = sc.nextBigInteger();
		 for(Order o:orders) {
	        	if(o.getId()==id) {
	               orders.remove(orders.indexOf(o));
	               System.out.println("order deleted with id:"+" "+o.getProduct());
	        	}
	        }
		 DeleteOrdersResponse response = new DeleteOrdersResponse();
			response.setResult(true);
			return response;
	}

	@Override
	public UpdateOrdersResponse updateOrders(UpdateOrdersRequest request) {
		BigInteger customerid = request.getCustomerId();
		BigInteger orderid = request.getOrderId();
		Order order = request.getOrder();
		List<Order> orders = customerOrders.get(customerid);
		
		Scanner sc = new Scanner(System.in);
       
        for(Order o:orders) {
        System.out.println("order id:"+o.getId());
        }
        BigInteger id = sc.nextBigInteger();
        for(Order o:orders) {
        	if(o.getId()==id) {
        		for(Product p :o.getProduct()) {
        			p.setId(sc.next());
        			p.setDescription(sc.next());
        			p.setQuantity(sc.nextBigInteger());
        		}
        	}
        }
        UpdateOrdersResponse response = new UpdateOrdersResponse();
		response.setResult(true);
		return response;
	}



	

}
