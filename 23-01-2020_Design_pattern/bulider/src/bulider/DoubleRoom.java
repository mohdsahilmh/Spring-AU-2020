package bulider;

public abstract class DoubleRoom implements Rooms {

	@Override
	public void buildername(String name) {
		System.out.println("Builder name: "+name);
	}
}
