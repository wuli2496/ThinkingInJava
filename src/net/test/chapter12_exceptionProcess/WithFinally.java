package net.test.chapter12_exceptionProcess;

public class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args)
    {
        try {
            sw.on();
            OnOffSwitch.f();
        } catch (OnOffExcetpion1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
}
