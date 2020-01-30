import java.util.Random;

public class Farmers extends Thread{
    Runnable Far = () ->{
		synchronized(MarketInventory.fruits) {
			for(int i=0;i<20;i++) {
				int FullCap=0;
					int random = new Random().nextInt(MarketInventory.Avialablefruits.length);
					String fruit = MarketInventory.Avialablefruits[random]; 
					System.out.println(Thread.currentThread().getName() + " produced: " + fruit);
					if(MarketInventory.fruits.containsKey(fruit) && MarketInventory.fruits.get(fruit)<=MarketInventory.maxcap_for_each_fruit) {
						 FullCap =1;
						 MarketInventory.fruits.put(fruit, MarketInventory.fruits.get(fruit)+1);
						 MarketInventory.fruits.notifyAll();
						 }
					 else if(!MarketInventory.fruits.containsKey(fruit)){
					     FullCap =1;
						 MarketInventory.fruits.put(fruit, 1);
						MarketInventory.fruits.notifyAll();
					      }
    					if(FullCap==0) {
						 try {
							 System.out.println("===================================");
							 System.out.println("Market capacity is full for "+fruit);
							 System.out.println("===================================");
							MarketInventory.fruits.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				     }
  				 }	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			}
		};
	
}

