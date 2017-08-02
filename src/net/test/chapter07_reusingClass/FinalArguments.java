package net.test.chapter07_reusingClass;

class Gizmo
{
    public void spin() {}
}

public class FinalArguments {
    void with(final Gizmo g)
    {
        //g =  new Gizmo();
    }

    void without(Gizmo g)
    {
        g = new Gizmo();
    }

    void f(final int i) {/*i++;*/}

    int g(final int i) {return i + 1;}

    public static void main(String[] args)
    {
        FinalArguments f = new FinalArguments();
        f.with(null);
        f.without(null);
    }
}
