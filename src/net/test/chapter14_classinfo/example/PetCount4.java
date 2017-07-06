package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
import static net.test.util.Print.*;

public class PetCount4 {
    public static void main(String[] args)
    {
        TypeCounter counter = new TypeCounter(Pet.class);
        for(Pet pet : Pets.createArray(20))
        {
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }

        print();
        print(counter);
    }
}
