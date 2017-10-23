package net.test.chapter19_enum;

import net.test.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static net.test.util.Print.print;
import static net.test.util.Print.printnb;

enum Explore{HERE, THERE};

public class Reflection {

    public static Set<String> analyze(Class<?> enumClass)
    {
        print("------analyzing " + enumClass + "------");
        print("interfaces:");
        for (Type t : enumClass.getGenericInterfaces())
        {
            print(t);
        }

        print("Base: " + enumClass.getSuperclass());

        print("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods())
        {
            methods.add(m.getName());
        }

        print(methods);
        return methods;
    }

    public static void main(String[] args)
    {
        Set<String> exporeMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(enum)? " + exporeMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(enum):");
        exporeMethods.removeAll(enumMethods);
        print(exporeMethods);

        OSExecute.command("javap -classpath F:\\my_git_hub\\ThinkingInJava\\out\\production\\ThinkingInJava\\net\\test\\chapter19_enum Explore");
    }
}
