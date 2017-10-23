package net.test.chapter19_enum;

import java.util.EnumMap;
import java.util.Map;

import static net.test.chapter19_enum.AlarmPoints.*;
import static net.test.util.Print.*;

interface Command
{
    void action();
}

public class EnumMaps {
    public static void main(String[] args)
    {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                print("Kitchen fire!");
            }
        });

        em.put(BATHROOM, new Command(){
           @Override
           public void action()
           {
               print("Bathroom alert!");
           }
        });

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet())
        {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }

        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }
}
