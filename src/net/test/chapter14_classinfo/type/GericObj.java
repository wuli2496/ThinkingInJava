package net.test.chapter14_classinfo.type;

import java.util.List;

public class GericObj<T> {
	private List<T> items;

    private List<String> names;

    private GericObj gericObj;

    private GericObj<T> gericObj2;

    private List list;

    private T t;

    private <E> T getItem(T t, E e) {
        return t;
    }

    public GericObj<T> test(List<T> items, GericObj<Integer> g, T t) {
        return null;
    }
}
