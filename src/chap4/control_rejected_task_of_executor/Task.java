package chap4.control_rejected_task_of_executor;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s start...\n", name);

		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s doing work for %d seconds\n", name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.printf("%s finish...\n", name);
	}

	@Override
	public String toString() {
		return name;
	}

}
