package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
import static net.test.util.Print.*;
import java.util.*;

class CountedInteger
{
    private static long counter;
    private final long id = counter++;
    public String toString()
    {
        return Long.toString(id);
    }
}
public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type) { this.type = type;}

    public List<T> create(int nElements)
    {
        List<T> result = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void main(String[] args)
    {
        FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
        print(fl.create(15));
    }
}
