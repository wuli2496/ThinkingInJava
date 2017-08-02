package net.test.chapter07_reusingClass;

import static net.test.util.Print.*;

class Villain
{
    private String name;
    protected void set(String nm) {name = nm;}
    public Villain(String name) {this.name = name;}
    public String toString()
    {
        return "I'am a Villain and my name is " + name;
    }
}
public class Orc extends Villain {
    private int orcNumber;

    public Orc(String name, int orcNumber)
    {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber)
    {
        set(name);
        this.orcNumber = orcNumber;
    }

    protected String get()
    {
        return "Orc";
    }

    public String toString()
    {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args)
    {
        Orc orc = new Orc("Limburger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }
}
