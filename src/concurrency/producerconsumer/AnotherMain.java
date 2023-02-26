package concurrency.producerconsumer;

import java.util.*;
import static concurrency.producerconsumer.ThreadColor.*;

public class AnotherMain {
	public static final String EOF = "EOF";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> buffer = new ArrayList<>();
		MyProducer producer = new MyProducer(buffer, ANSI_CYAN);
		MyConsumer consumer1 = new MyConsumer(buffer, ANSI_PURPLE);
		MyConsumer consumer2 = new MyConsumer(buffer, ANSI_GREEN);
		new Thread(producer).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
	}

}

class MyProducer implements Runnable{
	private List<String> buffer;
	private String color;

	public MyProducer(List<String> buffer, String color) {
		this.buffer = buffer;
		this.color = color;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		String [] nums = {"1","2","3","4","5"};
		
		for(String num: nums) {
			try {
				System.out.println(color + "Adding..."+num);
				synchronized (buffer) {
					buffer.add(num);
				}
				Thread.sleep(random.nextInt(2000));
			}catch(InterruptedException e) {
				System.out.println("Producer was interrupted");
			}
		}
		
		//System.out.println(color+"Adding EOF and exiting ...");
		synchronized (buffer) {
			buffer.add("EOF");
		}
	}
	
}

class MyConsumer implements Runnable{
	
	private List<String> buffer;
	private String color;

	public MyConsumer(List<String> buffer, String color) {
		this.buffer = buffer;
		this.color = color;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized(buffer) {
				if(buffer.isEmpty()) {
					continue;
				}
				if(buffer.get(0).equals(AnotherMain.EOF)) {
					System.out.println(color+"Exiting");
					break;
				}else {
					System.out.println(color+"Removed " + buffer.remove(0));
				}
			}
			
		}
	}
	
}
