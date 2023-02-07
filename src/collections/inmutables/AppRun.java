package collections.inmutables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppRun {
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", new HashMap<String, Integer>()));
		
		Map<String,Integer> tmpexit = new HashMap<String, Integer>();
		tmpexit.put("W", 2);
		tmpexit.put("E", 3);
		tmpexit.put("S", 4);
		tmpexit.put("N", 5);
		locations.put(1, new Location(1, "You are standing at the end of a road before a small bridge",tmpexit));
		
		tmpexit = new HashMap<String, Integer>();
		tmpexit.put("N", 5);
		locations.put(2, new Location(2, "You are at the top of a hill",tmpexit));
		
		tmpexit = new HashMap<String, Integer>();
		tmpexit.put("W", 1);
		locations.put(3, new Location(3, "You are inside a building, a wel house for a small springers",tmpexit));
		
		tmpexit = new HashMap<String, Integer>();
		tmpexit.put("N", 1);
		tmpexit.put("W", 2);
		locations.put(4, new Location(4, "You are in a valley beside a stream",tmpexit));
		
		tmpexit = new HashMap<String, Integer>();
		tmpexit.put("S", 1);
		tmpexit.put("W", 2);
		locations.put(5, new Location(5, "You are in the forest",tmpexit));
		
		Map<String, String> commands = new HashMap<String, String>();
		commands.put("QUIT", "Q");
		commands.put("NORTH", "N");
		commands.put("SOUTH", "S");
		commands.put("EAST", "E");
		commands.put("WEST", "W");
		
		int loc = 1;
		while(true) {
			System.out.println(locations.get(loc).getDescription());
			if(loc == 0) {
				break;
			}
			
			Map<String , Integer> exits = locations.get(loc).getExits();
			
			System.out.print("Available exits are ");
			for(String exit: exits.keySet()) {
				System.out.print(exit + ", ");
			}
			System.out.println();
			
			String direction = scanner.nextLine().toUpperCase();
			direction = direction.replaceAll("[-+.^:,]", "");
			if(direction.length() > 1) {
				direction = direction.toUpperCase();
				String[] words = direction.split(" ");
				for(String word: words) {
					if(commands.containsKey(word)) {
						direction = commands.get(word);
					}
				}
			}
			
			if(exits.containsKey(direction)) {
				loc = exits.get(direction);
			}else {
				System.out.println("We cannot go in that direction");
			}
			/*loc = exits.get(directions.get(0));
			if(directions.size() == 1) {
				continue;
			}
			for(int i = 1; i< directions.size()-1;i++ ) {
				System.out.println(locations.get(loc).getDescription());
				loc= exits.get(directions.get(i));
			}/*
			
			
			/*if(!locations.containsKey(loc)) {
				System.out.println("We cannot go in that direction");
			}*/
		}
		
	}
}
