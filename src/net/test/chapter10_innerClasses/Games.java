package net.test.chapter10_innerClasses;

import static net.test.util.Print.*;

interface Game
{
    boolean move();
}

interface GameFactory
{
    Game getGame();
}

class Checkers implements Game
{
    private Checkers() {}

    private int moves = 0;
    private static final int MOVES = 3;

    public boolean move()
    {
        print("Checkers move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory fact = new GameFactory() {
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };
}

class Chess implements Game
{
    private Chess() {}
    private int moves = 0;
    private static final int MOVES = 4;

    public boolean move()
    {
        print("Chess move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory fact = new GameFactory() {
        @Override
        public Game getGame() {
            return new Chess();
        }
    };
}

public class Games {

    public static void playGame(GameFactory fact)
    {
        Game game = fact.getGame();
        while(game.move());
    }
    public static void main(String[] args)
    {
        playGame(Checkers.fact);
        playGame(Chess.fact);
    }
}
