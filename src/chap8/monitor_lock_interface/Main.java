package chap8.monitor_lock_interface;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyLock lock = new MyLock();

		Thread[] threads = new Thread[5];
		for (int i = 0; i < 5; i++) {
			Task task = new Task(lock);
			threads[i] = new Thread(task);
			threads[i].start();
		}

		for (int i = 0; i < 15; i++) {
			System.out.printf("Main: logging the lock\n");
			System.out.printf("***********************\n");
			System.out.printf("Lock Owner; %s\n", lock.getOwnerName());

			boolean hasQueuedThreads = lock.hasQueuedThreads();
			System.out.println("lock has queued threads? " + hasQueuedThreads);
			if (hasQueuedThreads) {
				System.out.printf("lock: queued length: %d\n",
						lock.getQueueLength());
				System.out.printf("lock: queued threads:\n");
				Collection<Thread> lockedThreads = lock.getThreads();
				for (Thread lockedThread : lockedThreads) {
					System.out.println(lockedThread.getName());
				}
			}
			System.out.printf("lock: fairness? %s\n", lock.isFair());
			System.out.printf("lock: locked? %s\n", lock.isLocked());
			System.out.printf("***********************\n");

			TimeUnit.SECONDS.sleep(1);

		}
	}

}
