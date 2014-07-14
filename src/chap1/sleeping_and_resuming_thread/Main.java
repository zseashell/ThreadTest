package chap1.sleeping_and_resuming_thread;

import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) {
		DateClock clock = new DateClock();
		Thread thread = new Thread(clock);
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
	}
}
