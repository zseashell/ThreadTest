package chap4.running_mutiple_process_all_result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		List<Task> taskList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Task task = new Task("Task-" + i);
			taskList.add(task);
		}

		List<Future<Result>> results = null;
		try {
			results = executor.invokeAll(taskList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();

		System.out.println("Main: printing results");
		for (int i = 0; i < results.size(); i++) {
			Future<Result> future = results.get(i);
			try {
				Result result = future.get();
				System.out
						.println(result.getName() + " : " + result.getValue());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}
}
