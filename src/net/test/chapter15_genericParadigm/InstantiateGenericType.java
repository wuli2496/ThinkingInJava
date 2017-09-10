package net.test.chapter15_genericParadigm;

import static net.test.util.Print.*;

class ClassAsFactory<T>
{
    T x;

    public ClassAsFactory(Class<T> kind)
    {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {}

public class InstantiateGenericType {
    public static void main(String[] args)
    {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        print("ClassAsFactory<Employee> succeed");

        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            print("ClassAsFactory<Integer> failed");
        }
    }
}
