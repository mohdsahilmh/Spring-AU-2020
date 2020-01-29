package bulider;

public class SSBuilders implements Builders {
    house house;
    Rooms room; 
    SSBuilders(Rooms room){
    	this.house = new house();
    	this.room = room;
    }
	@Override
	public void buildBasement() {
		house.Basement("Ice Bars");
	}

	@Override
	public void buildStructure() {
		house.Structure("Ice Blocks");
	}

	@Override
	public void bulidRoof() {
		house.Roof("Ice Carvings");
	}

	@Override
	public void buildInterior() {
		house.Interior("Ice Dome");
	}
	public void roomtype() {
		room.buildername("SS BUILDERS");
       room.cost();		
	}

	@Override
	public house getHouse() {
		return this.house;
	}
	

}
