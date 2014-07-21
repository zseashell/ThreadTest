package chap4.creating_fixed_size_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import chap4.creating_fixed_size_executor.Task;

public class Server {

	private ThreadPoolExecutor executor;

	public Server() {
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}

	public void executeTask(Task task) {
		System.out.println("Server: A new task arrives!");
		executor.execute(task);
		// status of ThreadPool
		System.out.printf("Server: Pool Size %d\n", executor.getPoolSize());
		System.out.printf("Server: Active Count %d\n",
				executor.getActiveCount());
		System.out.printf("Server: Task Count %d\n", executor.getTaskCount());
		System.out.printf("Server: Completed Tasks %d\n",
				executor.getCompletedTaskCount());
	}

	public void endServer() {
		executor.shutdown();
	}

}
