package chap6.blocking_thread_safe_list;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);

		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				String result = list.take();
				System.out.printf("Main: take %s at %s\n", result, new Date());
			}
			TimeUnit.MILLISECONDS.sleep(300);
		}

		System.out.println("Main: end of the program");
	}

}
