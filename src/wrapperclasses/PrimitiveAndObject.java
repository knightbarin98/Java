package wrapperclasses;

public class PrimitiveAndObject {
	public static void main(String[] args) {
		//primitive to object
		int x = 100;
		Integer y = Integer.valueOf(x);
		
		//object to primitive
		int z = y.intValue();
	}
}
