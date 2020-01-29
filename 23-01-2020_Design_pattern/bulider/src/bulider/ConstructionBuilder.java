package bulider;

public class ConstructionBuilder {
  
	public Builders builders;
    public ConstructionBuilder(Builders builders) 
    { 
        this.builders = builders; 
    } 
  
    public house getHouse() 
    { 
        return this.builders.getHouse(); 
    } 
  
    public void constructHouse() 
    { 
        this.builders.buildBasement(); 
        this.builders.buildStructure(); 
        this.builders.bulidRoof(); 
        this.builders.buildInterior();
        this.builders.roomtype();
    } 
}
