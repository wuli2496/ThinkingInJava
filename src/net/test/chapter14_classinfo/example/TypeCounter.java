package net.test.chapter14_classinfo.example;

/**
 * Created by John on 2017/6/25.
 */
import java.util.*;

public class TypeCounter extends HashMap<Class<?>, Integer>{
    private Class<?> baseType;
    public TypeCounter(Class<?> type) {this.baseType = type;}

    public void count(Object obj)
    {
        Class<?> type = obj.getClass();
        if (!baseType.isAssignableFrom(type))
        {
            throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
        }

        countClass(type);
    }

    private void countClass(Class<?> type)
    {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass))
        {
            countClass(superClass);
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Class<?>, Integer> entry : entrySet())
        {
            sb.append(entry.getKey().getSimpleName());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append(",");
        }

        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
