package chap1.grouping_thread;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");

		SearchTask searchTask = new SearchTask();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group:\n");
		threadGroup.list();

		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i < threads.length; i++) {
			System.out.printf("Thread %s : %s\n", threads[i].getName(),
					threads[i].getState());
		}
		// wait for any one of thread in thread groups ends
		waitFinish(threadGroup);
		// interrupt the thread group
		threadGroup.interrupt();
	}

	// check if any thread in the thread group has ended per-second
	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 4) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
