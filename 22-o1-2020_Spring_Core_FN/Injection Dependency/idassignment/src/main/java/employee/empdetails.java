package employee;

import java.util.HashMap;
import java.util.Map;

public class empdetails {
     HashMap<Integer,employee> h = new HashMap<Integer,employee>();
     empdetails(HashMap<Integer, employee> h){
    	 this.h= h;
     }
     void getdetails() {
    	 for(Map.Entry<Integer, employee> m:h.entrySet()) {
    		 System.out.println("EMP ID : "+m.getKey()+"  "+"EMP NAME : "+m.getValue().name+" EMP AGE : "+m.getValue().age);
    	 }
     }
}
