package chap2.using_mutiple_conditions;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

	private LinkedList<String> buffer;

	private int maxSize;

	private ReentrantLock lock = new ReentrantLock();

	private Condition lines = lock.newCondition();

	private Condition space = lock.newCondition();

	private boolean pendingLines;

	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<String>();
		pendingLines = true;
	}

	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s inserted line: %d\n", Thread.currentThread()
					.getName(), buffer.size());
			lines.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String get() {
		lock.lock();
		String line = null;
		try {
			while ((buffer.size() == 0) && (hasPendingLines())) {
				lines.await();
			}
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: line readed: %d\n", Thread
						.currentThread().getName(), buffer.size());
				space.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return line;
	}

	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}

	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}

}
