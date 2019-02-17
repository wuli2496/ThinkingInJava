package rule.pattern.observer.hasabstract;

public class MockTimeSink implements ClockObserver
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

    public void update(int hours, int minutes, int seconds)
    {
        itsHours = hours;
        itsMinutes = minutes;
        itsSeconds = seconds;
    }
}
