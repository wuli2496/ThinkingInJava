package net.test.chapter19_enum;

import static net.test.util.Print.print;

public enum OzWitch {


    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer tof the Ruby " + "Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String description;
    private OzWitch(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public static void main(String[] args)
    {
        for (OzWitch ozWitch : OzWitch.values())
        {
            print(ozWitch + ":" + ozWitch.getDescription());
        }
    }

}
