package staticandnonstatic;

public class NonStaticMembers {
	
	int num;
	
	NonStaticMembers(){
		System.out.println("Inside the constructor");
	}
	
	{
		System.out.println("Inside non static block");
	}
	
	public static void main(String[] args) {
		System.out.println("Inside the main method");
		new NonStaticMembers();
		new NonStaticMembers();
		new NonStaticMembers();
	}
	
	static {
		System.out.println("Inside the static block");
	}
}
