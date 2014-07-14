package chap1.using_local_thread_variable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

	// shared by all Runnable Instance
	private Date startDate;

	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting thread %s : %s\n", Thread.currentThread()
				.getId(), startDate);

		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Finished thread %s : %s\n", Thread.currentThread()
				.getId(), startDate);
	}
}
