package java7Concurrent.threadsynchelper;

public class Results {
	private int[] data;
	
	public Results(int size) {
		// TODO Auto-generated constructor stub
		data = new int[size];
	}
	
	public void setData(int position, int value) {
		data[position] = value;
	}
	
	public int[] getData() {
		return data;
	}
}
