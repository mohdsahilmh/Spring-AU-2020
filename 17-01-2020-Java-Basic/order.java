import java.util.ArrayList;

public class order {
	  int id;
	  String name;
	  ArrayList<products> p;
      order(int d,String name, ArrayList<products> p){
    	  this.id = d;
    	  this.name = name;
    	  this.p = p;
      }
}
