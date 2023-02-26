package concurrency.interruptedandjoin;
import static concurrency.threads.ThreadColor.*;
public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(ANSI_RED + "Hello from my runnable's implmentation run()");
		
	}

}
