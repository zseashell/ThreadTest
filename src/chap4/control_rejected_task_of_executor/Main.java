package chap4.control_rejected_task_of_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) {
		RejectedTaskController controller = new RejectedTaskController();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();
		executor.setRejectedExecutionHandler(controller);
		
		System.out.println("Main starts...");
		for (int i=0; i<3; i++) {
			Task task = new Task("Task-" + i);
			executor.submit(task);
		}
		
		
		System.out.println("Main: shutting down the executor");
		executor.shutdown();
		
		System.out.println("main: sending another task after shut down the executor...");
		Task task = new Task("RejectedTask");
		executor.submit(task);
		
		System.out.println("Main end!");
	}

}
