package concurrency.multiplethreads;

import static concurrency.multiplethreads.ThreadColor.*;

public class Main {
	public static void main(String[] args) {
		Countdown countdown = new Countdown();
		
		CountdownThread t1 = new CountdownThread(countdown);
		t1.setName("Thread 1");
		CountdownThread t2 = new CountdownThread(countdown);
		t1.setName("Thread 2");
		
		t1.start();
		t2.start();
	}

}

class Countdown {
//	With an instance variable 
	/*
	 * [32MThread-1 : i = 10
	   [35MThread 2 : i = 10
	   [32MThread-1 : i = 9	
	   [35MThread 2 : i = 8
	   [32MThread-1 : i = 7
	   [35MThread 2 : i = 6
	   [32MThread-1 : i = 5
	   [35MThread 2 : i = 4
	   [32MThread-1 : i = 3
	   [35MThread 2 : i = 2
	   [32MThread-1 : i = 1
	 */
	//private int i;
	public void doCountdown() {
		String color;
		switch (Thread.currentThread().getName()) {
		case "Thread 1":
			color = ANSI_CYAN;
			break;

		case "Thread 2":
			color = ANSI_PURPLE;
			break;
		default:
			color = ANSI_GREEN;
		}
		
		for(int i=10;i>0;i--) { //for(i=10;i>0;i--) {
			System.out.println(color+ Thread.currentThread().getName()+" : i = " + i);
		}
	}
	
}

class CountdownThread extends Thread{
	private Countdown threadCountdown;
	public CountdownThread(Countdown countdown) {
		this.threadCountdown = countdown;
	}
	
	public void run() {
		threadCountdown.doCountdown();
	}
}
