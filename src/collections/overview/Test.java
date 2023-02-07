package collections.overview;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Theatre theatre = new Theatre("Olympian", 8 , 12);
		theatre.getSeats();
		if(theatre.reserveSeat("H11")) {
			System.out.println("Please pay");
		}else {
			System.out.println("Sorry, seat is taken");
		}
	}

}
