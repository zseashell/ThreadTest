package chap6.blocking_thread_safe_list_by_priority;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	public static void main(String[] args) {

		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();

		Thread[] threads = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			Task task = new Task(i, queue);
			threads[i] = new Thread(task);
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Main before poll: queue size is %s\n", queue.size());

		for (int i = 0; i < queue.size(); i++) {
			Event event = queue.poll();
			System.out.printf("Event-%s, priority %s\n", event.getId(),
					event.getPriority());
		}
		
		System.out.printf("Main after poll: queue size is %s\n", queue.size());
		System.out.println("Main: ends!");


	}

}
