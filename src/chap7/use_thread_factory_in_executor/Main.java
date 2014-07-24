package chap7.use_thread_factory_in_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
		ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
		MyTask task = new MyTask();
		executor.execute(task);
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.SECONDS);
	}

}
