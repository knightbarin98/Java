package concurrency.threads;

public class Main {

	public static void main(String[] args) {
		System.out.println(ThreadColor.ANSI_PURPLE+"Hello from the main thread");
		Thread anotherThread = new AnotherThread();
		anotherThread.start();
		
		new Thread() {
			public void run() {
				System.out.println(ThreadColor.ANSI_RED+"Hello from the anonymous thread");
			}
		}.start();
		
		System.out.println("Hello again from the main thread");
		
		//Exception we can start the thread once, but not restart the same instance
//		anotherThread.start();
		
	}

}
