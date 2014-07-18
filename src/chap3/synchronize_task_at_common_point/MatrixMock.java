package chap3.synchronize_task_at_common_point;

import java.util.Random;

public class MatrixMock {

	private int[][] data;

	public MatrixMock(int size, int length, int number) {
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < length; j++) {
				data[i][j] = random.nextInt(10);
				if (data[i][j] == number) {
					counter++;
				}
			}
		}
		System.out.printf(
				"There are %d ocurrences of number %d in generated data.\n",
				counter, number);
	}

	public int[] getRow(int rowNum) {
		if ((rowNum >= 0) && (rowNum < data.length)) {
			return data[rowNum];
		}
		return null;
	}

}
