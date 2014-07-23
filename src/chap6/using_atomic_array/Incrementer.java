package chap6.using_atomic_array;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Incrementer implements Runnable {

	private AtomicIntegerArray vector;

	public Incrementer(AtomicIntegerArray vector) {
		this.vector = vector;
	}

	@Override
	public void run() {
		for (int i = 0; i < vector.length(); i++) {
			vector.getAndIncrement(i);
		}

	}

}
