package chap3.waiting_for_multiple_concurrent_events;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

	private VideoConference videoConference;

	private String name;

	public Participant(VideoConference videoConference, String name) {
		this.videoConference = videoConference;
		this.name = name;
	}

	@Override
	public void run() {
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		videoConference.arrive(name);
	}

}
