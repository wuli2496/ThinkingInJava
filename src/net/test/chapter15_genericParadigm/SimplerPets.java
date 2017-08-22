package net.test.chapter15_genericParadigm;

import net.test.util.New;
import net.test.chapter14_classinfo.example.*;
import java.util.*;

public class SimplerPets {
    public static void main(String[] args)
    {
        Map<Person, List<? extends Pet>> petPeople = New.map();
    }
}
