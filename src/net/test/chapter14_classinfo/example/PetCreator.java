package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
import java.util.*;

public abstract class PetCreator {
    private Random rand = new Random(47);
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet()
    {
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch(InstantiationException e) {
            throw new RuntimeException(e);
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size)
    {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++)
        {
            result[i] = randomPet();
        }

        return result;
    }

    public List<Pet> arrayList(int size)
    {
        List<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));

        return result;
    }
}
