package chap3.synchronize_task_at_common_point;

import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) {
		final int ROWS = 10000;
		final int LENGTH = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int LINES_PARTICIPANT = 2000;

		MatrixMock matrix = new MatrixMock(ROWS, LENGTH, SEARCH);
		Result result = new Result(ROWS);
		Grouper grouper = new Grouper(result);

		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

		Searcher[] searchers = new Searcher[PARTICIPANTS];
		for (int i = 0; i < PARTICIPANTS; i++) {
			searchers[i] = new Searcher(matrix, i * LINES_PARTICIPANT, (i + 1)
					* LINES_PARTICIPANT, result, SEARCH, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
	}
}
