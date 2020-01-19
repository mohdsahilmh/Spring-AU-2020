import java.lang.reflect.Method;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface testcamera{
	public int check();
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface smartphone{
	String os() default "Symbian";
	int version() default 1;
}

@smartphone(os="android",version=4)
class nokiaAseries{
	 String model;
	 int version;
     nokiaAseries(String model,int v){
    	 this.model = model;
    	 this.version = v;
     }	
     
     @testcamera(check=1)
     public void camera() {
    	 System.out.println("it has dual camera");
     }
}


public class annotations {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		nokiaAseries n = new nokiaAseries("Fire",5);
		Class c = n.getClass();
		smartphone a = (smartphone) c.getAnnotation(smartphone.class);
		System.out.println("os :"+a.os()+"  version :"+a.version());
		Method c1 = c.getMethod("camera");
		testcamera b = c1.getAnnotation(testcamera.class);
		if(b.check()==1) {
		 n.camera();
		}
	}

}
