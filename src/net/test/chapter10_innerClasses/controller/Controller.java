package net.test.chapter10_innerClasses.controller;

import java.util.List;
import java.util.ArrayList;

public class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c)
    {
        eventList.add(c);
    }

    public void run()
    {
        while (eventList.size() > 0)
        {
            for (Event e : new ArrayList<>(eventList))
            {
                if (e.ready())
                {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
