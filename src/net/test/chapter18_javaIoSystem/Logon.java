package net.test.chapter18_javaIoSystem;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static net.test.util.Print.print;

public class Logon implements Serializable {
    private Date date = new Date();
    private String userName;
    private transient String password;
    public Logon(String name, String pwd)
    {
        userName = name;
        password = pwd;
    }

    public String toString()
    {
        return "logon info:\n   username: " + userName + "\n    data: " + date + "\n    password: " + password;
    }

    public static void main(String[] args) throws Exception
    {
        Logon a = new Logon("Hulk", "myLitterPonhy");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();

        //TimeUnit.SECONDS.sleep(1);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        print("Recovering obejct at:" + new Date());
        a = (Logon)in.readObject();
        print("logon a = " + a);

    }
}
