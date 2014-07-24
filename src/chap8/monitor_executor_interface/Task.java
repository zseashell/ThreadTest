package chap8.monitor_executor_interface;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private long milliseconds;

	public Task(long milliseconds) {
		this.milliseconds = milliseconds;
	}

	@Override
	public void run() {
		System.out.printf("%s begin...\n", Thread.currentThread().getName());
		try {
			System.out.printf("%s using time %d milliseconds\n", Thread.currentThread().getName(), milliseconds);
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s end...\n", Thread.currentThread().getName());
	}

}
