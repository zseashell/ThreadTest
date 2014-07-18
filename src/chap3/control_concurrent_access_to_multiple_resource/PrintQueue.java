package chap3.control_concurrent_access_to_multiple_resource;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

	// available printers
	private boolean freePrinters[];

	private Lock lockPrinters = new ReentrantLock();

	private Semaphore semaphore = new Semaphore(3);

	public PrintQueue() {
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
	}

	public void printDocument(Object document) {
		try {
			semaphore.acquire();
			int assignedPrinter = getPrinter();
			long duration = (long) (Math.random() * 10);
			System.out
					.printf("%s print document using printer-%d during %d seconds\n",
							Thread.currentThread().getName(), assignedPrinter,
							duration);
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}

	}

	private int getPrinter() {
		int ret = -1;

		// try to get an available printer
		try {
			lockPrinters.lock();
			for (int i = 0; i < 3; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}

}
