package net.test.chapter19_enum;

import static net.test.util.Print.*;

public enum OverrideConstantSpecific {
    NUT, BOLT,
    WASHER {
      void f()
      {
          print("Overridden method");
      }
    };

    void f()
    {
        print("default behavior");
    }

    public static void main(String[] args)
    {
        for (OverrideConstantSpecific v : values())
        {
            v.f();
        }
    }

}
