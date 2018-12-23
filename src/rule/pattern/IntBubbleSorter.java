package rule.pattern;

public class IntBubbleSorter extends rule.pattern.abs.BubbleSorter 
{
	private int[] array = null;
	
	public int sort(int[] theArray)
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
		int temp = array[index];
		array[index] = array[index + 1];
		array[index + 1] = temp;
	}
}
