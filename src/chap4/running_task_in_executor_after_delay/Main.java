package chap4.running_task_in_executor_after_delay;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(1);

		System.out.printf("Main: starting at %s\n", new Date());
		for (int i = 0; i < 5; i++) {
			Task task = new Task("Task-" + (i + 1));
			executor.schedule(task, i + 1, TimeUnit.SECONDS);
		}
		executor.shutdown();

		// after shutdown, wait all task finish within timeout
		try {
			executor.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
