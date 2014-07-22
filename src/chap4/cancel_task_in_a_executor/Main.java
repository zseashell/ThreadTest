package chap4.cancel_task_in_a_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();
		Task task = new Task();
		System.out.println("Main: executing the task");
		Future<String> result = executor.submit(task);

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Trying to cancel the task");
		result.cancel(true);

		System.out.printf("Task canceld? %s\n", result.isCancelled());
		System.out.printf("Task done? %s\n", result.isDone());

		executor.shutdown();
		System.out.println("Main: the executor has finished\n");
	}

}
