package net.test.chapter11_container;

import net.test.chapter14_classinfo.example.*;
import java.util.Map;
import java.util.HashMap;
import static net.test.util.Print.*;

public class PetMap {
    public static void main(String[] args)
    {
        Map<String, Pet> m = new HashMap<>();
        m.put("My Cat", new Cat("Molly"));
        m.put("My Dog", new Dog("Ginger"));
        m.put("My Hamster", new Hamster("Bosco"));

        print(m);
        Pet dog = m.get("My Dog");
        print(dog);
        print(m.containsKey("My Dog"));
        print(m.containsValue(dog));
    }
}
