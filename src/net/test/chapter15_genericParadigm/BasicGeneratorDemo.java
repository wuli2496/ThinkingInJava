package net.test.chapter15_genericParadigm;

import net.test.util.BasicGenerator;
import net.test.util.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] args)
    {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++)
        {
            System.out.println(gen.next());
        }
    }
}
