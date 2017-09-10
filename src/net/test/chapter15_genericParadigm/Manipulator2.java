package net.test.chapter15_genericParadigm;

public class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x) {obj = x;}
    public void manipulate() {obj.f();}

    public static void main(String[] args)
    {
        Manipulator2<HasF> m = new Manipulator2<>(new HasF());
        m.manipulate();
    }
}
