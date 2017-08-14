package net.test.chapter11_container;

import java.util.List;
import java.util.Iterator;

import net.test.chapter14_classinfo.example.*;

public class SimpleIterator {
    public static void main(String[] args)
    {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> iter = pets.iterator();
        while (iter.hasNext())
        {
            Pet p = iter.next();
            System.out.print(p.id() + ": " + p + " ");
        }

        System.out.println();

        for (Pet pet : pets)
        {
            System.out.print(pet.id() + ": " + pet + " ");
        }
        System.out.println();

        iter = pets.iterator();
        for (int i = 0; i < 6; i++)
        {
            iter.next();
            iter.remove();
        }

        System.out.println(pets);
    }
}
