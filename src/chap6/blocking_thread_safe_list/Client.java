package chap6.blocking_thread_safe_list;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {

	private LinkedBlockingDeque<String> list;

	public Client(LinkedBlockingDeque<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				StringBuilder builder = new StringBuilder();
				builder.append(i);
				builder.append(":");
				builder.append(j);
				try {
					list.put(builder.toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("Client: put %s at %s\n", builder.toString(),
						new Date());
			}
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Client : End\n");

	}

}
