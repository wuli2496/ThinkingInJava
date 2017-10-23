package net.test.chapter19_enum;

enum Search {HITER, YON}


public class UpcastEnum {
    public static void main(String[] args)
    {
        Search[] vals = Search.values();
        Enum e = Search.HITER;
        for (Enum en : e.getClass().getEnumConstants())
        {
            System.out.println(en);
        }
    }
}
