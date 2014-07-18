package chap3.synchronize_task_at_common_point;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {

	private MatrixMock matrix;

	private int startRow;

	private int endRow;

	private Result result;

	private int number;

	private final CyclicBarrier barrier;

	public Searcher(MatrixMock matrix, int startRow, int endRow, Result result, int number,
			CyclicBarrier barrier) {
		this.matrix = matrix;
		this.startRow = startRow;
		this.endRow = endRow;
		this.result = result;
		this.number = number;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		int counter;
		System.out.printf("%s start process lines from %d to %d\n", Thread
				.currentThread().getName(), startRow, endRow);
		for (int i = startRow; i < endRow; i++) {
			int[] row = matrix.getRow(i);
			counter = 0;
			for (int j = 0; j < row.length; j++) {
				if (row[j] == number) {
					counter++;
				}
			}
			result.setData(i, counter);
		}
		System.out.printf("%s finish process lines from %d to %d\n", Thread
				.currentThread().getName(), startRow, endRow);

		// barrier await
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
