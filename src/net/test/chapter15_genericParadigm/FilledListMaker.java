package net.test.chapter15_genericParadigm;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {
    List<T> create(T t, int n)
    {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            result.add(t);
        }

        return result;
    }

    public static void main(String[] args)
    {
        FilledListMaker<String> stringMaker = new FilledListMaker<>();
        List<String> list = stringMaker.create("hello", 4);
        System.out.println(list);
    }
}
