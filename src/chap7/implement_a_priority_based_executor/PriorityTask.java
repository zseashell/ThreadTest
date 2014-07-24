package chap7.implement_a_priority_based_executor;

import java.util.concurrent.TimeUnit;

public class PriorityTask implements Runnable, Comparable<PriorityTask> {

	private int priority;

	private String name;

	public PriorityTask(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public void run() {
		System.out.printf("Priority Task: name %s, priority %s\n", name,
				priority);

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(PriorityTask o) {
		if (this.getPriority() < o.getPriority()) {
			return 1;
		} else if (this.getPriority() > o.getPriority()) {
			return -1;
		} else {
			return 0;
		}
	}

}
