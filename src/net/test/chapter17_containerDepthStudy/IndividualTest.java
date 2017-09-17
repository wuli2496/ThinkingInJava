package net.test.chapter17_containerDepthStudy;

import net.test.chapter11_container.MapOfList;
import net.test.chapter14_classinfo.example.Individual;
import net.test.chapter14_classinfo.example.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static net.test.util.Print.print;

public class IndividualTest {
    public static void main(String[] args)
    {
        Set<Individual> pets = new TreeSet<>();
        for (List<? extends Pet> lp : MapOfList.petPeople.values())
        {
            for (Pet p : lp)
            {
                pets.add(p);
            }
        }

        print(pets);
    }
}
