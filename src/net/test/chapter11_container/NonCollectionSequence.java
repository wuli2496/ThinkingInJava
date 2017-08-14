package net.test.chapter11_container;

import net.test.chapter14_classinfo.example.*;
import java.util.Iterator;

class PetSequence
{
    protected Pet[] pets = Pets.createArray(8);
}
public class NonCollectionSequence extends PetSequence{
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

    public static void main(String[] args)
    {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}
