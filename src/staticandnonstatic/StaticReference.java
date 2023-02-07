package staticandnonstatic;

public class StaticReference {
	static StaticReference obj;
	
	static {
		System.out.println(StaticReference.obj);
		StaticReference.obj = new StaticReference();
	}
	
	public static void main(String[] args) {
		System.out.println(StaticReference.obj);
	}

}
