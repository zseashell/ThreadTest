package chap7.implement_a_priority_based_executor;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1,
				TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());

		for (int i = 0; i < 4; i++) {
			PriorityTask task = new PriorityTask("Task-" + i, i);
			executor.execute(task);
		}

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 4; i < 8; i++) {
			PriorityTask task = new PriorityTask("Task-" + i, i);
			executor.execute(task);
		}

		System.out.println("ShutDown Executor...");
		executor.shutdown();

		try {
			executor.awaitTermination(3, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main end!");
	}

}
