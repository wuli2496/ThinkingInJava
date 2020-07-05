package java7Concurrent.threadsynchelper;

import java.util.Random;

public class MatrixMock {
	private int[][] data;
	
	public MatrixMock(int size, int length, int number) {
		// TODO Auto-generated constructor stub
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < length; ++j) {
				data[i][j] = random.nextInt(10);
				if (data[i][j]== number) {
					++counter;
				}
			}
		}
		
		System.out.printf("Mock: There are %d ocurrences of number in generated data.\n", counter, number);
	}
	
	public int[] getRow(int index) {
		if (index < 0 || index >= data.length) {
			return null;
		}
		
		return data[index];
	}
}
