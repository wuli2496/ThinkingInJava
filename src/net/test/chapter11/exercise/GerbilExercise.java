package net.test.chapter11.exercise;

import java.util.*;

/**
 * Created by John on 2017/6/11.
 */
class Gerbil
{
    private static int counter;
    private int gerbilNumber;
    public Gerbil()
    {
        gerbilNumber = counter++;
    }
    public void hop()
    {
        System.out.println("gerbilNumber:" + gerbilNumber + " hop");
    }

}

public class GerbilExercise {
    public static void main(String[] args)
    {
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; i++)
        {
            gerbils.add(new Gerbil());
        }

        for (int i = 0; i < gerbils.size(); i++)
        {
            gerbils.get(i).hop();
        }
    }
}
