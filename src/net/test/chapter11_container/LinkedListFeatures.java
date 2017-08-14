package net.test.chapter11_container;

import net.test.chapter14_classinfo.example.*;
import java.util.List;
import java.util.LinkedList;
import static net.test.util.Print.*;

public class LinkedListFeatures {
    public static void main(String[] args)
    {
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));
        print(pets);
        print("pets.getFirst(): " + pets.getFirst());
        print("pets.element(): " + pets.element());

        print("pets.peek(): " + pets.peek());

        print("pets.remove(): " + pets.remove());
        print("pets.removeFirst(): " + pets.removeFirst());

        print("pets.poll(): " + pets.poll());
        print(pets);
        pets.addFirst(new Rat());
        print("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        print("After offer(): " + pets);
        pets.add(Pets.randomPet());
        print("After add(): " + pets);
        pets.addLast(new Hamster());
        print("After addLast(): " + pets);
        print("pets.removeLast(): " + pets.removeLast());
    }
}
