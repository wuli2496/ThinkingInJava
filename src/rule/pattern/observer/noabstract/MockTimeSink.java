package rule.pattern.observer.noabstract;

public class MockTimeSink implements TimeSink
{
	private int itsHours;
	private int itsMinutes;
	private int itsSeconds;
	
	public int getSeconds()
	{
		return itsSeconds;
	}
	
	public int getMinutes()
	{
		return itsMinutes;
	}
	
	public int getHours()
	{
		return itsHours;
	}
	
	public void setTime(int hours, int minutes, int seconds)
	{
		itsHours = hours;
		itsMinutes = minutes;
		itsSeconds = seconds;
	}
}
