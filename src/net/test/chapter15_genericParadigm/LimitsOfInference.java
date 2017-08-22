package net.test.chapter15_genericParadigm;

import net.test.util.New;
import net.test.chapter14_classinfo.example.*;
import java.util.*;


public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {}

    public static void main(String[] args)
    {
        f(New.map());
    }
}
