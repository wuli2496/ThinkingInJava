package net.test.chapter15_genericParadigm;

import java.util.*;

public class GenericAndCovariance {
    public static void main(String[] args)
    {
        List<? extends Fruit> flist = new ArrayList<>();
        //flist.add(new Orange());
        flist.add(null);
        Fruit f = flist.get(0);

        Number[] n = new Number[4];
        n[0] = new Integer(1);

        for (Number num : n)
        {
            System.out.println(num);
        }

        List<? extends Number> numbers = new ArrayList<Integer>();
    }
}
