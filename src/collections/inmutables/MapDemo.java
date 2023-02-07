package collections.inmutables;

import java.util.*;
/*
 * Java documentation recommend that keys should not be mutable objects, it is not prohibited
 * to use them but map will work more effective if we use inmutable, this because methods such as comparable could be affected
 */

public class MapDemo {
	
	public static void main(String[] args) {
		Map<String, String> languages = new HashMap<String, String>();
		languages.put("Java","High-level, object oriented, independent platform");
		languages.put("Python", "interpreter, object oriented, dynamic semantic");
		languages.put("Algol", "algorithmic langague");
		System.out.println(languages.put("Basic", "symbolic instruction code"));
		System.out.println(languages.put("Lisp", "lies madness"));
		
		if(languages.containsKey("Java")) {
			System.out.println("Java is already in the map");
		}else {
			languages.put("Java","this course is about java");
		}
		
		/*System.out.println(languages.get("Java"));
		languages.put("Java","this course is about java");
		System.out.println(languages.get("Java"));*/
		
		System.out.println("==============================================");
		
		languages.remove("Lisp");
		if(languages.remove("Algol", "algorithmic langague")) {
			System.out.println("Algol removed");
		}else {
			System.out.println("Algol note removed, key/value pair not found");
		}
		
		//System.out.println(languages.replace("Lips", "functional programming language"));
		if(languages.replace("Lips","This will not work","functional programming language")) {
			System.out.println("Lisp replaced");
		}else {
			//correct output because second parameter should have the value that is already contain
			System.out.println("Lisp not replaced");
		}
		
		System.out.println(languages.replace("Scala", "not added"));
		
		
		for(String key: languages.keySet()) {
			System.out.println(key + ":" +languages.get(key));
		}
	}
}
