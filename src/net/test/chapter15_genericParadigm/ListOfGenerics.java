package net.test.chapter15_genericParadigm;

import java.util.List;
import java.util.ArrayList;

public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();
    public void add(T item)
    {
        array.add(item);
    }

    public T get(int index)
    {
        return array.get(index);
    }
}
