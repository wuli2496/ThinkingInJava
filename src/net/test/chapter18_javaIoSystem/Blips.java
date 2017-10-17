package net.test.chapter18_javaIoSystem;


import java.io.*;

import static net.test.util.Print.print;

class Blip1 implements Externalizable
{
    public Blip1()
    {
        print("Blip1 constructor");
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        print("Blip1.writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable
{
    public Blip2()
    {
        print("Blip2 constructor");
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        print("Blip2.writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        print("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        print("Recovering b1:");
        b1 = (Blip1)in.readObject();
        print("Recovering b2:");
        b2 = (Blip2)in.readObject();
    }
}
