package net.test.chapter15_genericParadigm;

import java.io.*;
import java.util.*;

public class ClassCasting {
    public void f(String[] args) throws Exception
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));

        List<Widget>  lw1 = List.class.cast(in.readObject());
    }
}
