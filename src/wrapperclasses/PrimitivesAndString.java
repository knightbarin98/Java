package wrapperclasses;

public class PrimitivesAndString {

	public static void main(String[] args) {
		//primitive to string
		byte x = 100;
		String s = Byte.toString(x);
		
		//string to primitive
		byte z = Byte.parseByte(s);
	}

}
