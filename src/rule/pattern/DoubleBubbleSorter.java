package rule.pattern;

import rule.pattern.abs.BubbleSorter;

public class DoubleBubbleSorter extends BubbleSorter 
{
	private double[] array = null;
	
	public int sort(double[] theArray)
	{
		array = theArray;
		length = array.length;
		
		return doSort();
	}
	
	@Override
	protected boolean outOfOrder(int index) 
	{
		// TODO Auto-generated method stub
		return array[index] > array[index + 1];
	}

	@Override
	protected void swap(int index) 
	{
		// TODO Auto-generated method stub
		double temp = array[index];
		array[index] = array[index + 1];
		array[index + 1] = temp;
	}

}
