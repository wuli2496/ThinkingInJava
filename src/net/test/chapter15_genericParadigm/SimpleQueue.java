package net.test.chapter15_genericParadigm;

import java.util.*;

public class SimpleQueue<T> implements Iterable<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void add(T t)
    {
        storage.offer(t);
    }

    public T get()
    {
        return storage.poll();
    }

    public Iterator<T> iterator()
    {
        return storage.iterator();
    }
}
