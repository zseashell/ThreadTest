package chap1.create_daemon_thread;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {

	private Deque<Event> deque;

	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			Date date = new Date();
			String info = String.format("Generated by thread %s", Thread
					.currentThread().getId());
			Event event = new Event(date, info);
			deque.addFirst(event);
			
			// sleep for some period of time
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}