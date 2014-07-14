package chap1.create_daemon_thread;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {

	private Deque<Event> deque;

	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		// set as daemon thread
		setDaemon(true);
	}

	@Override
	public void run() {
		while (true) {
			Date date = new Date();
			// clean data generated 10s ago
			clean(date);
		}
	}

	private void clean(Date date) {
		if (deque.size() == 0) {
			return;
		}
		long difference;
		boolean deleted = false;
		do {
			Event event = deque.getLast();
			difference = date.getTime() - event.getDate().getTime();
			if (difference > 1000) {
				System.out.printf("Cleaner: %s\n", event.getEvent());
				deque.removeLast();
				deleted = true;
			}
		} while (difference > 1000);
		if (deleted) {
			System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
		}
	}
}
