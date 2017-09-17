package net.test.chapter17_containerDepthStudy;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static net.test.util.Print.print;

public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception
    {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++)
        {
            map.put(ghog.newInstance(i), new Prediction());
        }
        print("map = " + map);

        Groundhog hg = ghog.newInstance(3);
        print("Looking up prediction for " + hg);
        if (map.containsKey(hg)) print(map.get(hg));
        else print("Key not found: " + hg);
    }

    public static void main(String[] args) throws Exception
    {
        detectSpring(Groundhog.class);
    }
}
