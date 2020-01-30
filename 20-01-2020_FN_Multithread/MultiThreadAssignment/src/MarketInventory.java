import java.util.ArrayList;
import java.util.HashMap;



public class MarketInventory {
	public static int maxcap_for_each_fruit = 2;
	 public static HashMap<String,Integer> fruits = new HashMap<String,Integer>();
	public static String[] Avialablefruits = {"apple","orange","grapes","watermelon"};
	public static void main(String args[]) {
		   for(int i=1;i<=2;i++) {
		    new Thread(new Farmers().Far,"farmer_"+i).start();   
		   }
		   for(int i=1;i<=3;i++) {
			    new Thread(new Consumers().Con,"consumer_"+i).start();   
			   }
		   
}
}
