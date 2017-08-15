package net.test.chapter12_exceptionProcess;

public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f() throws OnOffExcetpion1, OnOffException2 {}

    public static void main(String[] args)
    {
        try {
            sw.on();
            f();
            sw.off();
        } catch (OnOffExcetpion1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}
