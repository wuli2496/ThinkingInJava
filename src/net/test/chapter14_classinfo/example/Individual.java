package net.test.chapter14_classinfo.example;

import com.sun.org.apache.bcel.internal.generic.InvokeInstruction;

/**
 * Created by John on 2017/6/25.
 */
public class Individual  implements Comparable<Individual> {
    private static long counter;
    private long id = counter++;
    private String name;

    public Individual(String name) {this.name = name;}

    public Individual() {}

    public String toString()
    {
        return getClass().getSimpleName() + (name == null ? "" : name);
    }

    public long id() { return id;}

    public boolean equals(Object o)
    {
        return o instanceof Individual && id == ((Individual)o).id;
    }

    public int hashCode()
    {
        int result = 17;
        if (name != null) result = result * 37 + name.hashCode();

        result = result * 37 + (int)id;
        return result;
    }
    public int compareTo(Individual arg)
    {
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) return firstCompare;

        if (name != null && arg.name != null)
        {
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0) return secondCompare;
        }

        return arg.id < id ? -1 : (arg.id == id ? 0 : 1);
    }
}
