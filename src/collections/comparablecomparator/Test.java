package collections.comparablecomparator;

import java.util.*;

/*
 * -The method we use to create a copy of the list is called shallow copy
 * -So what it does it creates an array list containing all the elements from the list 
 *  that were passed to the constructor
 * -If we modified one of the elements from the list, since it is a shallow copy, it will be in each list created
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Theatre theatre = new Theatre("Olympian", 8 , 12);
		
		
		if(theatre.reserveSeatBinarySearch("D12")) {
			System.out.println("Please pay the ticket");
		}else {
			System.out.println("Seat already reserved");
		}
		
		if(theatre.reserveSeatBinarySearch("B13")) {
			System.out.println("Please pay the ticket");
		}else {
			System.out.println("Seat already reserved");
		}
		List<Theatre.Seat> reverseSeats = new ArrayList<Theatre.Seat>(theatre.getSeats());
		Collections.reverse(reverseSeats);
		printList(reverseSeats);
		
		List<Theatre.Seat> pricesSeats = new ArrayList<Theatre.Seat>(theatre.getSeats());
		pricesSeats.add(theatre.new Seat("A00",13.00));
		pricesSeats.add(theatre.new Seat("B00",13.00));
		Collections.sort(pricesSeats, theatre.PRICE_ORDER);
		printList(pricesSeats);
	}
	
	public static void printList(List<Theatre.Seat> list) {
		for(Theatre.Seat seat : list) {
			System.out.print(" "+seat.getSeatNumber() + ", price: " + seat.getPrice());
		}
		
		System.out.println();
		System.out.println("===========================================");
	}

}
