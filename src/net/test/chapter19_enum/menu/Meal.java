package net.test.chapter19_enum.menu;

public class Meal {
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            for (Course c : Course.values())
            {
                Food food = c.randomSelect();
                System.out.println(food);
            }
            System.out.println("======");
        }
    }
}
