package collections.map;

import java.util.*;

public class Theatre {
	private String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	public static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {

		@Override
		public int compare(Seat seat1, Seat seat2) {
			// TODO Auto-generated method stub
			
			if(seat1.getPrice() < seat2.getPrice()) {
				return 1;
			}
			
			if(seat1.getPrice() > seat2.getPrice() ) {
				return -1;
			}
			
			return 0;
		}
		
	};

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;

		int lastRow = 'A' + (numRows - 1);
		// System.out.println(lastRow);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				double price = 12.00;
				String seatString = row + String.format("%02d", seatNum);
				// System.out.println(seatString);
				if(row<'D' && (seatNum >= 4 && seatNum < 9)) {
					price = 14.00;
				}
				
				if(row>'F' || (seatNum < 4 || seatNum > 9 )) {
					price = 7.00;
				}
				
				Seat seat = new Seat(seatString, price);
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
		Seat requestSeat = new Seat(seatNumber,0);
		int foundSeat = Collections.binarySearch(seats, requestSeat, null);
		if(foundSeat >= 0) {
			return seats.get(foundSeat).isReserved();
		}else {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}
		/*int low = 0;
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
		return false;*/
	}	

	// for testing
	public Collection<Seat> getSeats() {
		return seats;
	}

	public class Seat implements Comparable<Seat> {
		private final String seatNumber;
		private boolean reserved = false;
		private double price;

		public Seat(String seatNumber, double price) {
			this.seatNumber = seatNumber;
			this.setPrice(price);
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

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

	}

}
