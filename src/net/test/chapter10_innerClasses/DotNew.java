package net.test.chapter10_innerClasses;

public class DotNew {
    public class Inner {}

    public static void main(String[] args)
    {
        DotNew dn = new DotNew();
        DotNew.Inner di = dn.new Inner();
    }
}
