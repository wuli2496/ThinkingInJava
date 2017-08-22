package net.test.chapter15_genericParadigm;

import net.test.chapter14_classinfo.example.*;
import java.util.*;
import net.test.util.New;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {}
    public static void main(String[] args)
    {
        f(New.<Person, List<Pet>>map());
    }
}
