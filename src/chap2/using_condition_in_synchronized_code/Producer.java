package chap2.using_condition_in_synchronized_code;

public class Producer implements Runnable {

	private EventStorage eventStorage;

	public Producer(EventStorage eventStorage) {
		this.eventStorage = eventStorage;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			eventStorage.produce();
		}
	}

}
