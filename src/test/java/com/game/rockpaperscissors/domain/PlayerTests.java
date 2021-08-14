package com.game.rockpaperscissors.domain;

import com.game.rockpaperscissors.domain.movestrategies.MoveStrategy;
import org.junit.Test;

public class PlayerTests {

    public static MoveStrategy INVALID_NULL_MOVE_STRATEGY = null;

    @Test(expected = IllegalArgumentException.class)
    public void givenANullStrategyAndValidPlayerNameWhenNewPlayerThenThrowException() {
        Player.newPlayer(FixtureFactory.validPlayerName(), INVALID_NULL_MOVE_STRATEGY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenAnInvalidNullPlayerNameAndAValidStrategyWhenNewPlayerThenThrowException() {
        Player.newPlayer(FixtureFactory.INVALID_NULL_PLAYER_NAME, INVALID_NULL_MOVE_STRATEGY);
    }
}
