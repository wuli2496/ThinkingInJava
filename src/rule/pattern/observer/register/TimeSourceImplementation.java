package rule.pattern.observer.register;

import java.util.Iterator;
import java.util.Vector;

public class TimeSourceImplementation
{
    private Vector<ClockObserver> itsObservers = new Vector<>();

    protected void notify(int hours, int minutes, int seconds)
    {
        Iterator i = itsObservers.iterator();
        while (i.hasNext())
        {
            ClockObserver observer = (ClockObserver)i.next();
            observer.update(hours, minutes, seconds);
        }
    }

    public void registerObserver(ClockObserver observer)
    {
        itsObservers.add(observer);
    }
}
