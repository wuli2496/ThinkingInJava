package net.test.chapter11_container;

import net.test.chapter14_classinfo.example.*;
import static net.test.util.Print.*;

import java.util.*;

public class MapOfList {
    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<>();
    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"), new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"), Arrays.asList(new Pug("Loie aka Louis Snorkelstein Dupree"), new Cat("Stanford aka Stinky el Negro"), new Cat("Pinkola")));
        petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args)
    {
        print("People: " + petPeople.keySet());
        print("Pets: " + petPeople.values());
        for (Person p : petPeople.keySet())
        {
            print(p + " has:");
            for (Pet pet: petPeople.get(p))
            {
                print(" " + pet);
            }
        }
    }
}
