package concurrency.interruptedandjoin;

import static concurrency.threads.ThreadColor.*;

public class Main {

	public static void main(String[] args) {
		System.out.println(ANSI_PURPLE+"Hello from the main thread");
		Thread anotherThread = new AnotherThread();
		anotherThread.setName("=== Another thread ===");
		anotherThread.start();
		
		new Thread() {
			public void run() {
				System.out.println(ANSI_RED+"Hello from the anonymous thread");
			}
		}.start();
		
		Thread myRunnableThread = new Thread(new MyRunnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(ANSI_RED + "Hello from anonymous class implementation of run");
				try {
//					Add time out to control how much time should be running
//					anotherThread.join(2000);
					anotherThread.join();
					System.out.println(ANSI_RED+"AnotherThread terminated, or timeout, so I'm running again");
				}catch(InterruptedException ex) {
					System.out.println(ANSI_RED + "I  couldn't wait after all. I was interrupted");
				}
			}
			
		}); //new Thread(new MyRunnable());
		myRunnableThread.start();
//		anotherThread.interrupt();
		
		System.out.println("Hello again from the main thread");
		
//		Exception we can start the thread once, but not restart the same instance
//		anotherThread.start();
		
	}

}
