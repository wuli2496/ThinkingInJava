package net.test.chapter19_enum;

import static net.test.chapter19_enum.Outcome.*;

public enum RoShamBo4 implements Competitor<RoShamBo4> {
    PAPER {
        public Outcome compete(RoShamBo4 it)
        {
            return compete(SCISSORS, it);
        }
    },
    SCISSORS {
        public Outcome compete(RoShamBo4 it)
        {
            return compete(PAPER, it);
        }
    },
    ROCK {
        public Outcome compete(RoShamBo4 it)
        {
            return compete(SCISSORS, it);
        }
    };
    public Outcome compete(RoShamBo4 loser, RoShamBo4 opponent)
    {
        if (opponent == this) return DRAW;
        else if (opponent == loser) return WIN;
        return LOSE;
    }

    public static void main(String[] args)
    {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
