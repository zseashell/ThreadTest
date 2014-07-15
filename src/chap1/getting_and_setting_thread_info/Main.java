package chap1.getting_and_setting_thread_info;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {

		Thread[] threads = new Thread[10];
		Thread.State states[] = new Thread.State[10];

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

		}
	}

}
