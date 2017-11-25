package net.test.chapter21_concurrent;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public synchronized String getThermostat()
    {
        return thermostat;
    }

    public synchronized void setThermostat(String thermostat)
    {
        this.thermostat = thermostat;
    }

    public void schedule(Runnable event, long delay)
    {
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, long initialDealy, long period)
    {
        scheduler.scheduleAtFixedRate(event, initialDealy, period, TimeUnit.MILLISECONDS);
    }

    class LightOn implements Runnable
    {
        public void run()
        {
            print("Turning on lights");
            light = true;
        }
    }

    class LightOff implements Runnable
    {
        public void run()
        {
            print("Turning off lights");
            light = false;
        }
    }

    class WaterOff implements Runnable
    {
        public void run()
        {
            print("Turing greenhouse water off");
            water = false;
        }
    }

    class WaterOn implements Runnable
    {
        public void run()
        {
            print("Turing greenhouse water on");
            water = true;
        }
    }

    class ThermostatNight implements Runnable
    {
        public void run()
        {
            print("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable
    {
        public void run()
        {
            print("Thermostat to day setting");
            setThermostat("Day");
        }
    }

    class Bell implements Runnable
    {
        public void run()
        {
            print("Bing!");
        }
    }

    class Ternimate implements Runnable
    {
        public void run()
        {
            print("Terminating");
            scheduler.shutdownNow();

            new Thread()
            {
                public void run()
                {
                    for (DataPoint d : data)
                    {
                        print(d);
                    }
                }
            }.start();
        }
    }

    static class DataPoint
    {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar d, float temp, float hum)
        {
            time = d;
            temperature = temp;
            humidity = hum;
        }

        public String toString()
        {
            return time.getTime() + String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private float lastHumidity = 50.0f;
    private int tempDirection = +1;
    private int humidityDirection = +1;
    private Random rand = new Random(47);

    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    class CollectData implements Runnable
    {
        public void run()
        {
            print("Collecting data");
            synchronized (GreenhouseScheduler.this)
            {
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                if (rand.nextInt(5) == 4)
                {
                    tempDirection = -tempDirection;
                }

                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4)
                {
                    humidityDirection = -humidityDirection;
                }

                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();

                data.add(new DataPoint((Calendar)lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }

    public static void main(String[] args)
    {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        gh.schedule(gh.new Ternimate(), 5000);
        gh.repeat(gh.new Bell(), 0, 1000);
        gh.repeat(gh.new ThermostatNight(), 0, 2000);
        gh.repeat(gh.new LightOn(), 0, 200);
        gh.repeat(gh.new LightOff(), 0, 400);
        gh.repeat(gh.new WaterOn(), 0, 600);
        gh.repeat(gh.new WaterOff(), 0, 800);
        gh.repeat(gh.new ThermostatDay(), 0, 1400);
        gh.repeat(gh.new CollectData(), 500, 500);
    }
}
