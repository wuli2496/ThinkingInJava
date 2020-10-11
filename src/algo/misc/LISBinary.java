package algo.misc;

import java.util.Arrays;

public class LISBinary implements LISAlgo
{
	public LISBinary(int[] nums)
	{
		this.nums = nums;
	}
	
	public  int getLen()
	{
		int n = nums.length;
		int[] d = new int[n + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[0] = Integer.MIN_VALUE;
		
		int ans = 0;
		for (int num : nums)
		{
			int index = Arrays.binarySearch(d, num);
			if (index < 0)
			{
				index = -index - 1;
			}
			d[index] = num;
			
			ans = Math.max(ans, index);
		}
		
		return ans;
	}
	
	private int[] nums;
}
