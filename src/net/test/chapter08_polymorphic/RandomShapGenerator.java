package net.test.chapter08_polymorphic;

import java.util.Random;

public class RandomShapGenerator {
    private Random rand = new Random(47);
    public Shape next()
    {
        switch(rand.nextInt(3))
        {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}
