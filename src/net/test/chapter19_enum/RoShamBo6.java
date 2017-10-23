package net.test.chapter19_enum;

import static net.test.chapter19_enum.Outcome.*;

public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;

    private static Outcome[][] table = {
            {DRAW, LOSE, WIN},
            {WIN, DRAW, LOSE},
            {LOSE, WIN, DRAW}
    };
    public Outcome compete(RoShamBo6 it)
    {
        return table[this.ordinal()][it.ordinal()];
    }

    public static void main(String[] args)
    {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
