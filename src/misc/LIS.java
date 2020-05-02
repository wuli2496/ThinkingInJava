package misc;

public class LIS implements LISAlgo
{
	public LIS(int[] nums)
	{
		this.nums = nums;
	}
	
	public int getLen()
	{
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = 1;
		
		int ans = 0;
		for (int i = 1; i < n; ++i)
		{
			int v = 0;
			for (int j = 0; j < i; ++j)
			{
				if (nums[i] > nums[j])
				{
					v = Math.max(v, dp[j]);
				}
			}
			
			dp[i] = v + 1;
			ans = Math.max(ans, dp[i]);
		}
		
		return ans;
	}
	
	private int[] nums;
}
