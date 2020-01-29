package bulider;

public abstract class Singleroom implements Rooms {


	@Override
	public void buildername(String name) {
		System.out.println("Builder name: "+name);
	}
}
