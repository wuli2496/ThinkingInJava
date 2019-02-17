package rule.pattern.observer.register;

public class MockTimeSource implements TimeSource
{
    private TimeSourceImplementation tsImp = new TimeSourceImplementation();

    public void registerObserver(ClockObserver observer)
    {
        tsImp.registerObserver(observer);
    }

    public void setTime(int hours, int minutes, int seconds)
    {
        tsImp.notify(hours, minutes, seconds);
    }
}
