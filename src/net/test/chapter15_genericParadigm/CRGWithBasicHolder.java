package net.test.chapter15_genericParadigm;

class Subtype extends BashHolder<Subtype> {}

public class CRGWithBasicHolder {
    public static void main(String[] args)
    {
        Subtype s1 = new Subtype(), s2 = new Subtype();
        s1.set(s2);
        Subtype s3 = s1.get();
        s1.f();
    }
}
