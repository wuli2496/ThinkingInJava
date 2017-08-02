package net.test.chapter08_polymorphic;

public class Shapes {
    private static RandomShapGenerator gen = new RandomShapGenerator();

    public static void main(String[] args)
    {
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++)
        {
            s[i] = gen.next();
        }

        for (Shape shp : s)
        {
            shp.output();
        }
    }
}
