package net.test.chapter19_enum;

import static net.test.chapter19_enum.Outcome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);

    private Outcome vPaper, vScissors, vRock;
    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock)
    {
        vPaper = paper;
        vScissors = scissors;
        vRock = rock;
    }

    public Outcome compete(RoShamBo2 it)
    {
        switch (it)
        {
            default:
            case PAPER: return vPaper;
            case SCISSORS: return vScissors;
            case ROCK: return vRock;
        }
    }

    public static void main(String[] args)
    {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
