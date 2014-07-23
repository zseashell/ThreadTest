package chap6.using_thread_safe_list_with_delayed_elements;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class Task implements Runnable {

	private int id;

	private DelayQueue<Event> queue;

	public Task(int id, DelayQueue<Event> queue) {
		this.id = id;
		this.queue = queue;
	}

	@Override
	public void run() {
		Date now = new Date();
		Date delay = new Date();
		delay.setTime(now.getTime() + (id * 1000));

		for (int i = 0; i < 100; i++) {
			Event event = new Event(delay);
			queue.add(event);
		}
	}

}
