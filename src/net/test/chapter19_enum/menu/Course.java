package net.test.chapter19_enum.menu;

import net.test.util.Enums;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFER(Food.Coffee.class);

    private Food[] values;

    Course(Class<? extends Food> kind)
    {
        values = kind.getEnumConstants();
    }

    public Food randomSelect()
    {
        return Enums.random(values);
    }
}
