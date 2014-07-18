package chap3.waiting_for_multiple_concurrent_events;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

	private final CountDownLatch controller;

	public VideoConference(int number) {
		controller = new CountDownLatch(number);
	}

	public void arrive(String name) {
		System.out.printf("%s has arrived.\n", name);
		controller.countDown();
		System.out.printf("Video Conference waiting for %d participants.\n",
				controller.getCount());
	}

	@Override
	public void run() {
		System.out.printf("VideoConference initialization %d participants.\n",
				controller.getCount());

		try {
			controller.await();
			System.out.println("All participants has arrived!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
