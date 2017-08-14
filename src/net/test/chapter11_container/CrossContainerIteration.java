package net.test.chapter11_container;

import net.test.chapter14_classinfo.example.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.List;

public class CrossContainerIteration {
    public static void display(Iterator<Pet> iter)
    {
        while (iter.hasNext())
        {
            Pet p = iter.next();
            System.out.print(p.id() + ": " + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        List<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }
}
