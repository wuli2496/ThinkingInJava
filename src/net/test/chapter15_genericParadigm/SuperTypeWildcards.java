package net.test.chapter15_genericParadigm;

import java.util.*;

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples)
    {
        apples.add(new Apple());
        apples.add(new Jonathan());
    }
}
