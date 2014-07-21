package chap4.creating_fixed_size_executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private Date initDate;

	private String name;

	public Task(String name) {
		this.initDate = new Date();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s: task-%s created at %s\n", Thread.currentThread()
				.getName(), name, initDate);

		System.out.printf("%s: task-%s started at %s\n", Thread.currentThread()
				.getName(), name, new Date());
		// sleep for some period of time
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: task-%s finished at %s\n", Thread
				.currentThread().getName(), name, new Date());

	}

}
