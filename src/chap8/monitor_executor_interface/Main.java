package chap8.monitor_executor_interface;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();
		
		Random random = new Random();
		for (int i=0; i<10; i++) {
			Task task = new Task(random.nextInt(10000));
			executor.submit(task);
		}
		
		for (int i=0; i<5; i++) {
			showLog(executor);
			TimeUnit.SECONDS.sleep(1);
		}
		
		System.out.println("Shut down the executor!!!");
		executor.shutdown();
		
		for (int i=0; i<5; i++) {
			showLog(executor);
			TimeUnit.SECONDS.sleep(1);
		}
		
		executor.awaitTermination(1, TimeUnit.MINUTES);
		
		System.out.println("Main: end of the program.");
		
		
	}

	private static void showLog(ThreadPoolExecutor executor) {
		System.out.printf("***********************\n");
		System.out.printf("Main: executor log.\n");
		System.out.printf("Main: executor core pool size %d\n",
				executor.getCorePoolSize());
		System.out.printf("Main: executor pool size %d\n",
				executor.getPoolSize());
		System.out.printf("Main: executor active count %d\n",
				executor.getActiveCount());
		System.out.printf("Main: executor task count %d\n",
				executor.getTaskCount());
		System.out.printf("Main: executor completed task count %d\n",
				executor.getCompletedTaskCount());
		System.out.printf("Main: executor shutdown? %s\n",
				executor.isShutdown());
		System.out.printf("Main: executor terminating? %s\n",
				executor.isTerminating());
		System.out.printf("Main: executor terminated? %s\n",
				executor.isTerminated());
		System.out.printf("***********************\n");
	}
}
