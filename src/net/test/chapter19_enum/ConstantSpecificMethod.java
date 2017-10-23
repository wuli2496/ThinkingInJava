package net.test.chapter19_enum;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo()
        {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
        String getInfo()
        {
            return System.getenv("CLASSPATH");
        }
    },

    VERSION {
        String getInfo()
        {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args)
    {
        for (ConstantSpecificMethod v : values())
        {
            System.out.println(v.getInfo());
        }
    }
}
