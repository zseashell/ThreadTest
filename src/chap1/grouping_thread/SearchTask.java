package chap1.grouping_thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s: Start\n", name);
		try {
			doTask();
		} catch (InterruptedException e) {
			System.out.printf("Thread %s: Interrupted\n", name);
			return;
		}
		System.out.printf("Thread %s: End\n", name);
	}
	
	private void doTask() throws InterruptedException {
		// just sleep for some period of time
		Random random = new Random(new Date().getTime());
		int value = (int) (random.nextDouble() * 100);
		TimeUnit.SECONDS.sleep(value);
	}

}
