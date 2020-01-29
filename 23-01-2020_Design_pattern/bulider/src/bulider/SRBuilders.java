package bulider;

public class SRBuilders implements Builders {
	house house;
	 Rooms room; 
    SRBuilders(Rooms room){
    	this.house = new house();
        this.room = room;	
    }
	@Override
	public void buildBasement() {
		house.Basement("Wooden Poles");
	}

	@Override
	public void buildStructure() {
		house.Structure("Wood and Ice");
	}

	@Override
	public void bulidRoof() {
		house.Roof("Fire Wood");
	}

	@Override
	public void buildInterior() {
		house.Interior("Wood, caribou and seal skins");
	}
	
	public void roomtype() {
		room.buildername("SR BUILDERS");
	    room.cost();	
	}
	@Override
	public house getHouse() {
		// TODO Auto-generated method stub
		return house;
	}



}
