package staticandnonstatic;

public class StaticBlocks {
	public static void main(String [] args) {
		System.out.println("Hello World");
	}
	
	static {
		System.out.println("static block 1");
	}
	
	static {
		System.out.println("static block 2");
	}
}
