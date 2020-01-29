package bulider;

public class house implements ConstructionPlan {
    
    String basement; 
    String structure; 
    String roof; 
    String interior;
	@Override
	public void Basement(String basement) {
		
		this.basement = basement;
	}
	@Override
	public void Structure(String structure) {
		this.structure = structure;
	}
	@Override
	public void Roof(String roof) {
		this.roof = roof;
	}
	@Override
	public void Interior(String interior) {
		this.interior=interior;
	}
    public void disp() {
    	System.out.println("Used Materials For Construction :");
    	System.out.println("Basement : "+basement+" structure : "+structure+" roof : "+roof+" interior : "+interior+" ");
    }
}
