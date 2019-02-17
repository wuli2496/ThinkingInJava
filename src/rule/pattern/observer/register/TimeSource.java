package rule.pattern.observer.register;

import rule.pattern.observer.register.ClockObserver;

public interface TimeSource
{
    void registerObserver(ClockObserver observer);
}
