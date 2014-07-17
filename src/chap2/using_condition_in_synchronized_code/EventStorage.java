package chap2.using_condition_in_synchronized_code;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {

	private int maxSize;

	private LinkedList<Date> storage;

	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<>();
	}

	public synchronized void produce() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.offer(new Date());
		System.out.printf("Produce, size : %d\n", storage.size());
		notifyAll();
	}

	public synchronized void consume() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.poll();
		System.out.printf("Consume, size : %d\n ", storage.size());
		notifyAll();
	}

}
