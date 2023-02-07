package collections.listmethods;

import java.util.*;

public class Theatre {
	private String theatreName;
	public List<Seat> seats = new ArrayList<>();

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;

		int lastRow = 'A' + (numRows - 1);
		// System.out.println(lastRow);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				String seatString = row + String.format("%02d", seatNum);
				// System.out.println(seatString);
				Seat seat = new Seat(seatString);
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;
	}

	// inefficient brute force search
	public boolean reserveSeatBruteSearch(String seatNumber) {
		Seat requestSeat = null;
		for (Seat seat : seats) {
			System.out.print(".");
			if (seat.getSeatNumber().equals(seatNumber)) {
				requestSeat = seat;
				break;
			}
		}

		if (requestSeat == null) {
			System.out.println("There is no seat " + seatNumber);
			return false;

		}

		return requestSeat.isReserved();
	}

	// efficient binary Search
	public boolean reserveSeatBinarySearch(String seatNumber) {
		/*Seat requestSeat = new Seat(seatNumber);
		int foundSeat = Collections.binarySearch(seats, requestSeat, null);
		if(foundSeat >= 0) {
			return seats.get(foundSeat).isReserved();
		}else {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}*/
		int low = 0;
		int high = seats.size() -1;
		while(low <= high) {
			System.out.print(".");
			int mid = (low+high)/2;
			Seat midVal = seats.get(mid);
			int cmp = midVal.getSeatNumber().compareTo(seatNumber);
			
			if(cmp < 0) {
				low = mid + 1;
			}else if(cmp > 0){
				high = mid - 1;
			}else {
				return seats.get(mid).isReserved();
			}
		}
		
		System.out.println("There is not seat " + seatNumber);
		return false;
	}	

	// for testing
	public void getSeats() {
		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}

	public class Seat implements Comparable<Seat> {
		private final String seatNumber;
		private boolean reserved = false;

		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean isReserved() {
			if (!reserved) {
				reserved = true;
				System.out.println("Seat " + seatNumber + " reserved");
				return true;
			}
			return false;
		}

		public void setReserved(boolean reserved) {
			this.reserved = reserved;
		}

		public boolean cancel() {
			if (reserved) {
				reserved = false;
				System.out.println("Reservation of seat " + seatNumber + " is cancel");
				return true;
			}
			return false;
		}

		@Override
		public int compareTo(Seat o) {
			return this.seatNumber.compareToIgnoreCase(o.getSeatNumber());
		}

	}

}
