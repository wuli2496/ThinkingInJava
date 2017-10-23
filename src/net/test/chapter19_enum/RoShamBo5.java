package net.test.chapter19_enum;

import java.util.EnumMap;

import static net.test.chapter19_enum.Outcome.*;

public enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER, SCISSORS, ROCK;

    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>(RoShamBo5.class);
    static {
        for (RoShamBo5 v : values())
        {
            table.put(v, new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
        }

        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }

    static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK)
    {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }

    public Outcome compete(RoShamBo5 it)
    {
        return table.get(this).get(it);
    }

    public static void main(String[] args)
    {
        RoShamBo.play(RoShamBo5.class, 20);
    }
}
