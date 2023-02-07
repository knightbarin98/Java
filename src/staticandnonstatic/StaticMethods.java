package staticandnonstatic;

public class StaticMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside main");
		StaticMethods.method();
		System.out.println("Back to main");
	}

	static void method() {
		System.out.println("Inside method");
	}
	
	static {
		System.out.println("Inside static block");
		StaticMethods.method();
		System.out.println("Back to static block");
	}
}
