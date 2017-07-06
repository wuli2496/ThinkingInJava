package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
import java.util.*;

public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet()
    {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size)
    {
        return creator.createArray(size);
    }

    public static List<Pet> arrayList(int size)
    {
        return creator.arrayList(size);
    }
}

