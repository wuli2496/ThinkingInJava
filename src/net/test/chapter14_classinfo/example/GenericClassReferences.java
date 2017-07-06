package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
public class GenericClassReferences {
    public static void main(String[] args)
    {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;
        //genericIntClass = double.class;

    }
}
