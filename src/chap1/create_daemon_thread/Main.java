package chap1.create_daemon_thread;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) {
		Deque<Event> deque = new ArrayDeque<Event>();
		// 3 writer thread
		WriterTask writer = new WriterTask(deque);
		for (int i =0; i<3; i++) {
			Thread thread = new Thread(writer);
			thread.start();
		}
		// 2 clean daemon thread
		CleanerTask cleaner = new CleanerTask(deque);
		cleaner.start();
	}
}
