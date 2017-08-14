package net.test.chapter11_container;

import net.test.chapter14_classinfo.example.*;
import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args)
    {
        List<Pet> pets = Pets.arrayList(10);
        ListIterator<Pet> iter = pets.listIterator();
        while (iter.hasNext())
        {
            System.out.print(iter.next() + ", " + iter.nextIndex() + ", " + iter.previousIndex() + ";");
        }
        System.out.println();

        while (iter.hasPrevious())
        {
            System.out.print(iter.previous().id() + " ");
        }
        System.out.println();

        System.out.println(pets);
        while (iter.hasNext())
        {
            iter.next();
            iter.set(Pets.randomPet());
        }

        System.out.println(pets);
    }
}
