package com.game.rockpaperscissors.domain;


import org.junit.Test;

import static com.game.rockpaperscissors.domain.FixtureFactory.INVALID_PLAYER_TWO;
import static com.game.rockpaperscissors.domain.FixtureFactory.VALID_PLAYER_ONE;

public class GamePlayTests {

    @Test(expected = NullPointerException.class)
    public void givenAValidAndANullPlayerWhenOfThenThrowException() {
        GamePlay.of(VALID_PLAYER_ONE, INVALID_PLAYER_TWO);
    }


}
