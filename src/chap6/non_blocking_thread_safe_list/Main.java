package chap6.non_blocking_thread_safe_list;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
		Thread[] threads = new Thread[100];

		for (int i = 0; i < threads.length; i++) {
			AddTask task = new AddTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d addTask threads have been launched\n",
				threads.length);

		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: size of the list is %d\n", list.size());
		
		threads = new Thread[100];
		for (int i=0; i<threads.length; i++) {
			PollTask task = new PollTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: size of the list is %d\n", list.size());
		
	}

}
