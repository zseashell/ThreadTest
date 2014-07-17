package chap1.getting_and_setting_thread_info;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Main {

	public static void main(String[] args) throws IOException {

		Thread[] threads = new Thread[10];
		State states[] = new State[10];

		// create 10 threads
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			threads[i].setName("Thread " + i);
			if ((i % 2) == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
		}

		// // java 7 new feature: try-with-resources
		try (FileWriter file = new FileWriter("log.txt");
				PrintWriter pw = new PrintWriter(file);) {
			// initial state of thread
			for (int i = 0; i < 10; i++) {
				pw.println("Main: Status of Thread " + i + " : "
						+ threads[i].getState());
				states[i] = threads[i].getState();
			}

			// start all the threads
			for (int i = 0; i < 10; i++) {
				threads[i].start();
			}

			boolean isFinished = false;
			while (!isFinished) {
				for (int i = 0; i < 10; i++) {
					// check if the state of thread changed
					if (threads[i].getState() != states[i]) {
						writeThreadInfo(pw, threads[i], states[i]);
						states[i] = threads[i].getState();
					}
				}
				isFinished = true;
				for (int i=0; i<10; i++) {
					isFinished = isFinished && (threads[i].getState() == State.TERMINATED);
				}
			}

		}
	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread,
			State state) {
		pw.printf("Main: Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main: Priority: %d\n", thread.getPriority());
		pw.printf("Main: Old State: %s\n", state);
		pw.printf("main: New State: %s\n", thread.getState());
		pw.printf("Main: ***************************\n");
	}

}
