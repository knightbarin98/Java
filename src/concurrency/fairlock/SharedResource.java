package concurrency.fairlock;

public class SharedResource {
	private Worker owner;
	
	public SharedResource(Worker owner) {
		this.owner = owner;
	}
	
	public Worker getOwner() {
		return owner;
	}
	
	public synchronized void setOwner(Worker worker) {
		this.owner = worker;
	}
	
}
