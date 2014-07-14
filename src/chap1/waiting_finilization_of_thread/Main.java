package chap1.waiting_finilization_of_thread;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		DataSourceLoader loader1 = new DataSourceLoader();
		Thread thread1 = new Thread(loader1);
		
		DataSourceLoader loader2 = new DataSourceLoader();
		Thread thread2 = new Thread(loader2);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: configuration has been loaded %s!\n", new Date());

	}

}
