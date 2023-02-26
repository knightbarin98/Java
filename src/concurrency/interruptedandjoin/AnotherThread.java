package concurrency.interruptedandjoin;

import static concurrency.threads.ThreadColor.*;

public class AnotherThread extends Thread{

	@Override
	public void run() {
		System.out.println(ANSI_BLUE+"Hello from "+ currentThread().getName());
		try {
			Thread.sleep(3000);
		}catch(InterruptedException ex) {
			System.out.println(ANSI_BLUE + "Another thread woke me up");
			return;
		}
		System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
	}

}
