package collections.adventuregame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppRun {
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
		locations.put(1, new Location(1, "You are standing at the end of a road before a small bridge"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a building, a wel house for a small springers"));
		locations.put(4, new Location(4, "You are in a valley beside a stream"));
		locations.put(5, new Location(5, "You are in the forest"));
		
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);
		//locations.get(1).addExit("Q", 0);
		
		locations.get(2).addExit("N", 5);
		//locations.get(2).addExit("Q", 0);
		
		locations.get(3).addExit("W", 1);
		//locations.get(3).addExit("Q", 0);
		
		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);
		//locations.get(4).addExit("Q", 0);
		
		locations.get(5).addExit("S", 1);
		locations.get(5).addExit("W", 2);
		//locations.get(5).addExit("Q", 0);
		
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
			List<String> directions = new ArrayList<String>();
			
			System.out.println("Available exits are ");
			for(String exit: exits.keySet()) {
				System.out.print(exit + ", ");
			}
			System.out.println();
			
			String direction = scanner.nextLine().toUpperCase();
			direction = direction.replaceAll("[-+.^:,]", "");
			if(direction.length() > 1) {
				direction = direction.toUpperCase();
				String[] words = direction.split(" ");
				for(String s: words) {
					if(commands.containsKey(s)) {
						directions.add(commands.get(s));
					}
				}
			}
			loc = exits.get(directions.get(0));
			if(directions.size() == 1) {
				continue;
			}
			for(int i = 1; i< directions.size()-1;i++ ) {
				System.out.println(locations.get(loc).getDescription());
				loc= exits.get(directions.get(i));
			}
			
			
			/*if(!locations.containsKey(loc)) {
				System.out.println("We cannot go in that direction");
			}*/
		}
		
	}
}
