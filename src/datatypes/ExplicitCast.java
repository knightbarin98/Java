package datatypes;

public class ExplicitCast {
	public static void main(String[] args) {
		int i = 100;
		// error byte b = i;
		//corrrect cast
		byte b = (byte)i;
		
		int in = 97;
		// error char ch = in;
		//correct casting
		char ch = (char)in;
		
		int y = 130;
		byte z = (byte)y;
		//-126
		System.out.println(z);
		
		int m = 612;
		byte n = (byte)m;
		char o = (char)n;
		System.out.println(o);
	}
}
