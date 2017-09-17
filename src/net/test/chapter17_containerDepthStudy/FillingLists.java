package net.test.chapter17_containerDepthStudy;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import static net.test.util.Print.*;

class StringAddress
{
    private String s;
    public StringAddress(String s)
    {
        this.s = s;
    }
    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {
    public static void main(String[] args)
    {
        List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("Hello")));
        print(list);

        Collections.fill(list, new StringAddress("World"));
        print(list);
    }
}
