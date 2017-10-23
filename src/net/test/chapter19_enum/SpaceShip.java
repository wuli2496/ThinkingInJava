package net.test.chapter19_enum;

public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    public String toString()
    {
        String s = name();
        String lower = s.substring(1).toLowerCase();
        return s.charAt(0) + lower;
    }

    public static void main(String[] args)
    {
        for (SpaceShip s : values())
        {
            System.out.println(s);
        }
    }
}
