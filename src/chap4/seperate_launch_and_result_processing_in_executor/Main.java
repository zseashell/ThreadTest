package chap4.seperate_launch_and_result_processing_in_executor;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		CompletionService<String> service = new ExecutorCompletionService<>(
				executor);
		
		ReportRequest request1 = new ReportRequest("request1", service);
		ReportRequest request2 = new ReportRequest("request2", service);
		Thread thread1 = new Thread(request1);
		Thread thread2 = new Thread(request2);
		
		ReportProcessor processor = new ReportProcessor(service);
		Thread processorThread = new Thread(processor);
		
		System.out.println("Main: starting...");
		thread1.start();
		thread2.start();
		processorThread.start();
		
		try {
			System.out.println("Main: waiting for the report generator!");
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main: shutting down executor!");
		executor.shutdown();
		
		try {
			executor.awaitTermination(3, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		processor.setEnd(true);
		System.out.println("Main: ends...");

	}

}
