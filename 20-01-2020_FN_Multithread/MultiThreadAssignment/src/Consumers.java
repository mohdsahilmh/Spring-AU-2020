import java.util.Random;


public class Consumers extends Thread{
    Runnable Con = () ->{
		
		while(true) {
			synchronized(MarketInventory.fruits) {
			
				int EmptyCap=0;
					 int random = new Random().nextInt(MarketInventory.Avialablefruits.length);
					 String fruit = MarketInventory.Avialablefruits[random];
					 System.out.println("Consumer want to buy :"+fruit);
					 if(MarketInventory.fruits.containsKey(fruit) && MarketInventory.fruits.get(fruit)>0) {
						 EmptyCap=1;
						 MarketInventory.fruits.put(fruit, MarketInventory.fruits.get(fruit)-1);
						 System.out.println(Thread.currentThread().getName()+" Consumes  "+fruit);
						 System.out.println("Market has "+fruit+" with capacity "+MarketInventory.fruits.get(fruit));
                        // MarketInventory.fruits.notifyAll();
					 }
				 if(EmptyCap==0) {
					 try {
						 System.out.println("===================================");
						System.out.println("Market does not have "+fruit+" in stock,consumer has to wait");
						System.out.println("===================================");
						MarketInventory.fruits.wait();
						
					} catch (InterruptedException e) {
                      // TODO Auto-generated catch block
						e.printStackTrace();
					} 
					 System.out.println("===================================");
					 System.out.println("consumer have been notifed");
					 System.out.println("===================================");
				 }
			}
		}
		
    };
}
