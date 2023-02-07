package collections.overview;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	private String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		
		int lastRow = 'A'+ (numRows - 1);
		//System.out.println(lastRow);
		for(char row = 'A'; row <= lastRow; row++) {
			for(int seatNum = 1; seatNum<=seatsPerRow; seatNum++) {
				String seatString = row + String.format("%02d", seatNum);
				//System.out.println(seatString);
				Seat seat = new Seat(seatString);
				seats.add(seat);
			}
		}
	}
	
	public String getTheatreName() {
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber) {
		Seat requestSeat = null;
		for(Seat seat: seats) {
			if(seat.getSeatNumber().equals(seatNumber)) {
				requestSeat = seat;
				break;
			}
		}
		
		if(requestSeat == null) {
			System.out.println("There is no seat " + seatNumber);
			return false;
			
		}
		
		return requestSeat.isReserved();
	}
	
	//for testing
	public void getSeats() {
		for(Seat seat: seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	private class Seat{
		private final String seatNumber;
		private boolean reserved = false;
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean isReserved() {
			if(!reserved) {
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
			if(reserved) {
				reserved = false;
				System.out.println("Reservation of seat " + seatNumber + " is cancel");
				return true;
			}
			return false;
		}
		
	}
	
}
