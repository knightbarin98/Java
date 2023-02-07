package collections.listmethods;

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
		List<Theatre.Seat> seatCopy = new ArrayList<Theatre.Seat>(theatre.seats);
		printList(seatCopy);
		
		seatCopy.get(1).isReserved();
		
		if(theatre.reserveSeatBinarySearch("A02")) {
			System.out.println("Please pay the ticket");
		}else {
			System.out.println("Seat already reserved");
		}
		
		//share same elements but they are different list 
		Collections.shuffle(seatCopy);
		System.out.println("Printing seat copy");
		printList(seatCopy);
		System.out.println("Printing theatre.seat");
		printList(theatre.seats);
		
		//list features like max and min
		Theatre.Seat minSeat = Collections.min(seatCopy);
		Theatre.Seat maxSeat = Collections.max(seatCopy);
		System.out.println("Min seat number " + minSeat.getSeatNumber());
		System.out.println("Max seat number " + maxSeat.getSeatNumber());
		
		//bubble sort
		sortList(seatCopy);
		System.out.println("Printing sorted seatCopy");
		printList(seatCopy);
		
		//It is rare but it does not work because in order to make Collections.copy work
		//the same amount of items that are from theatre.seats should be in the new list
		List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
		Collections.copy(newList, theatre.seats);
	}
	
	public static void printList(List<Theatre.Seat> list) {
		for(Theatre.Seat seat : list) {
			System.out.print(" "+seat.getSeatNumber());
		}
		
		System.out.println();
		System.out.println("===========================================");
	}
	
	public static void sortList(List<? extends Theatre.Seat> list) {
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size();j++) {
				if(list.get(i).compareTo(list.get(j))>0) {
					Collections.swap(list, i, j);
				}
			}
		}
	}

}
