package net.test.chapter11_container;

import net.test.chapter14_classinfo.example.*;
import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection {
    private Pet[] pets = Pets.createArray(8);

    public Iterator<Pet> iterator()
    {

        return new Iterator<Pet>()
        {
            private int index = 0;
            public boolean hasNext()
            {
                return index < pets.length;
            }

            public Pet next()
            {
                return pets[index++];
            }

            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size()
    {
        return pets.length;
    }

    public static void main(String[] args)
    {
        CollectionSequence cs = new CollectionSequence();
        InterfaceVsIterator.display(cs);
        InterfaceVsIterator.display(cs.iterator());
    }
}
