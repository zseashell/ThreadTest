package chap4.running_task_in_an_executor_periodically;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		System.out.printf("Main starting at %s\n", new Date());
		Task task = new Task("Task");
		/**
		 * scheduleAtFixedRate: period param determines the time between the
		 * beginning of tasks 
		 * scheduleWithFixedRate: period param determines the
		 * time between the end of previous task and beginning of next task
		 */
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2,
				TimeUnit.SECONDS);

		// check the time remained for next execution
		for (int i = 0; i < 10; i++) {
			System.out.printf("Main: Delay %d\n",
					result.getDelay(TimeUnit.MILLISECONDS));

			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Main finished at %s\n", new Date());
	}

}
