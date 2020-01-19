import java.util.function.BiConsumer;

public class exceptionhandling {
	 public static void main(String args[]) {
		 int [] num = {1,2,3,4};
		 int key =0;
		 perform(num,key,wrapperlambda((v,k)->System.out.println(v/k)));
	 }
	 static void perform(int num[],int key,BiConsumer<Integer,Integer> consumer) {
		 for(Integer n:num) {
			 consumer.accept(n, key);
		 }
	 }
	 
	 static BiConsumer<Integer,Integer> wrapperlambda(BiConsumer<Integer,Integer> consumer) {
		 return (v,k) -> {
			 try {
				 consumer.accept(v,k);
			 }catch(ArithmeticException e) {
				 System.out.println("ArithmeticException found");
			 }
		 };
	 }
}   
