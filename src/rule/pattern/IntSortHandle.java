package rule.pattern;

import rule.pattern.itf.SortHandle;

public class IntSortHandle implements SortHandle 
{
	private int[] array = null;
	
	@Override
	public void swap(int index) 
	{
		// TODO Auto-generated method stub
		int temp = array[index];
		array[index] = array[index + 1];
		array[index + 1] = temp;
	}

	@Override
	public boolean outOfOrder(int index) 
	{
		// TODO Auto-generated method stub
		return array[index] > array[index + 1];
	}

	@Override
	public int length() 
	{
		// TODO Auto-generated method stub
		return array.length;
	}

	@Override
	public void setArray(Object array) 
	{
		// TODO Auto-generated method stub
		this.array = (int[])array;
	}

}
