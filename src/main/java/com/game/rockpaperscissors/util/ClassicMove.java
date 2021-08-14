package com.game.rockpaperscissors.util;

import com.game.rockpaperscissors.domain.Result;
import com.game.rockpaperscissors.domain.moves.Paper;
import com.game.rockpaperscissors.domain.moves.Rock;
import com.game.rockpaperscissors.domain.moves.Scissors;

/**
 * A Classic Rock Paper Scissors game Move. Classic Moves include Rock, Paper and Scissors
 */
public interface ClassicMove extends Move {

    /**
     * Gets the result of a Classic Rock Paper Scissors game, should this Classic Move be played against Paper
     * @param move <p>a Paper Classic Move this one would be played against</p>
     * @return <p>the Result of playing this Classic Move against Paper</p>
     */
    Result playedAgainst(Paper move);
    /**
     * Gets the result of a Classic Rock Paper Scissors game, should this Classic Move be played against Rock
     * @param move <p>a Rock Classic Move this one would be played against</p>
     * @return <p>the Result of playing this Classic Move against Rock</p>
     */
    Result playedAgainst(Rock move);
    /**
     * Gets the result of a Classic Rock Paper Scissors game, should this Classic Move be played against Scissors
     * @param move <p>a Scissors Classic Move this one would be played against</p>
     * @return <p>the Result of playing this Classic Move against Scissors</p>
     */
    Result playedAgainst(Scissors move);

}
