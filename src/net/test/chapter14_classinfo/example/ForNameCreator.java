package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
import java.util.*;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
            "net.test.chapter14_classinfo.example.Mutt",
            "net.test.chapter14_classinfo.example.Pug",
            "net.test.chapter14_classinfo.example.EgyptianMau",
            "net.test.chapter14_classinfo.example.Manx",
            "net.test.chapter14_classinfo.example.Cymric",
            "net.test.chapter14_classinfo.example.Rat",
            "net.test.chapter14_classinfo.example.Mouse",
            "net.test.chapter14_classinfo.example.Hamster"
    };

    private static void loader()
    {
        try {
            for(String name : typeNames)
            {
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static {
        loader();
    }
    public List<Class<? extends Pet>> types()
    {
        return types;
    }
}
