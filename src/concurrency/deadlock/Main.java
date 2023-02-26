package concurrency.deadlock;

/**
 * Deadlock occurs when two or more threads are blocked on locks every thread is
 * holding a block
 *
 * @author mrbarin
 *
 */
public class Main {

	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();

	}

	// it is private because it will be only use by the main class that is the top
	// class
	// static so you can access the static objects
	private static class Thread1 extends Thread {

		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1: has lock1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 1: Waiting for lock 2");
				synchronized (lock2) {
					System.out.println("Thread 1: has lock 1 and lock 2");
				}
				System.out.println("Thread 1: Released lock 2");
			}
			System.out.println("Thread 1: release lock 1. Exiting ..");
		}

	}

	private static class Thread2 extends Thread {
		//To avoid deadlock we need to try to obtain the locks in the same order
		@Override
		public void run() {
			synchronized (lock2) { //like this succed a deadlock synchronized (lock1) {
				System.out.println("Thread 2: has lock 1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 2: Waiting for lock 2");
				synchronized (lock1) { //synchronized (lock2) {
					System.out.println("Thread 2: has lock 1 and lock 2");
				}
				System.out.println("Thread 2: Released lock 1");
			}
			System.out.println("Thread 2: release lock 1. Exiting ..");
		}

	}

}
