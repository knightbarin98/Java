package staticandnonstatic;

public class ReferenceByStaticMethod {
	
	static ReferenceByStaticMethod obj = new ReferenceByStaticMethod();
	
	static {
		System.out.println(ReferenceByStaticMethod.obj);
		ReferenceByStaticMethod.obj = ReferenceByStaticMethod.init();
	}
	
	static ReferenceByStaticMethod init() {
		//ReferenceByStaticMethod.obj = new ReferenceByStaticMethod();
		return new ReferenceByStaticMethod();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReferenceByStaticMethod.obj);
	}

}
