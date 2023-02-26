package concurrency.fairlock;

public class LiveLockMain {

	public static void main(String[] args) {
		final Worker worker1 = new Worker("Worker 1", true);
		final Worker worker2 = new Worker("Worker 2", true);
		
		final SharedResource sharedResource = new SharedResource(worker1);
		
		new Thread((Runnable)()->{
			worker1.work(sharedResource, worker2);
		}).start();
		
		new Thread((Runnable)()-> {
			worker2.work(sharedResource, worker1);
		}).start();
	}

}
