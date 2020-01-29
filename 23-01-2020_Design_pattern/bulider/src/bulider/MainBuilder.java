package bulider;

public class MainBuilder {
	public static void main(String args[]) {
	Builders ssbuilders = new SSBuilders(new SSsingle()); 
	ConstructionBuilder cb = new ConstructionBuilder(ssbuilders); 
	cb.constructHouse();
    house house = cb.getHouse(); 
    house.disp();
    System.out.println("<================================================================================================>");
    Builders srbuilders = new SRBuilders(new SRdouble()); 
	cb = new ConstructionBuilder(srbuilders); 
	cb.constructHouse();
    house = cb.getHouse(); 
    house.disp();
    
	}
}
