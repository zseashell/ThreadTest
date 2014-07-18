package chap3.controlling_concurrent_access_to_resource;

import java.util.concurrent.Semaphore;

public class PrintQueue {

	private final Semaphore semaphore = new Semaphore(1);

	public void printDocument(Object document) {
		try {
			semaphore.acquire();

			long duration = (long) (Math.random() * 10);
			System.out.printf("%s : print a document using %d seconds\n", Thread
					.currentThread().getName(), duration);
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
