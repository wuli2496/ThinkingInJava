package rule.pattern.observer.noabstract;

public class MockTimeSource implements TimeSource
{
	private ClockDriver itsDriver;
	
	public void setDriver(ClockDriver driver)
	{
		itsDriver = driver;
	}
	
	public void setTime(int hours, int minutes, int seconds)
	{
		itsDriver.update(hours, minutes, seconds);
	}
}
