package net.test.chapter11_container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Arrays;

class ReversibleArrayList<T> extends ArrayList<T>
{
    public ReversibleArrayList(Collection<T> c)
    {
        super(c);
    }

    public Iterable<T> reversed()
    {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private int current = size() - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }
}

public class AdapterMethodIdiom {
    public static void main(String[] args)
    {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not be".split(" ")));
        for (String s : ral)
        {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : ral.reversed())
        {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
