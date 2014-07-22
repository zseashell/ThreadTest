package chap4.control_a_task_finishing_in_executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		ResultTask[] resultTasks = new ResultTask[5];
		for (int i = 0; i < 5; i++) {
			ExecutableTask task = new ExecutableTask("Task-" + (i + 1));
			resultTasks[i] = new ResultTask(task);
			executor.submit(resultTasks[i]);
		}

		// main thread sleep for 5 seconds
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// cancel all task
		for (int i = 0; i < resultTasks.length; i++) {
			resultTasks[i].cancel(true);
		}

		// get the result of those havn't been canceled
		for (int i = 0; i < resultTasks.length; i++) {

			try {
				if (!resultTasks[i].isCancelled()) {
					System.out.printf("%s\n", resultTasks[i].get());
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}

}
