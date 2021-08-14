package com.game.rockpaperscissors.domain.moves;

import com.game.rockpaperscissors.util.ClassicMove;
import com.game.rockpaperscissors.util.Move;
import com.game.rockpaperscissors.domain.Result;

/**
 * A Classic Paper Move in a Classic Rock, Paper, Scissors game
 */
public class Paper implements ClassicMove {

    public static final String MOVE_NAME = "Paper";

    @Override
    public Result playedAgainst(Move move) {
        return ((ClassicMove) move).playedAgainst(this).opposite();
    }

    /**
     * @see ClassicMove#playedAgainst(Rock)
     */
    @Override
    public Result playedAgainst(Rock move) {
        return Result.WINS;
    }

    /**
     * @see ClassicMove#playedAgainst(Paper)
     */
    @Override
    public Result playedAgainst(Paper move) {
        return Result.DRAWS;
    }

    /**
     * @see ClassicMove#playedAgainst(Scissors)
     */
    @Override
    public Result playedAgainst(Scissors move) {
        return Result.LOSES;
    }

    @Override
    public String toString() {
        return MOVE_NAME;
    }

    @Override
    public int hashCode() {
        return MOVE_NAME.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        return obj instanceof Paper;
    }
}
