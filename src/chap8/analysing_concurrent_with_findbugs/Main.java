package chap8.analysing_concurrent_with_findbugs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		for (int i = 0; i < 10; i++) {
			Task task = new Task(lock);
			Thread thread = new Thread(task);
			thread.run();
		}
	}

}
