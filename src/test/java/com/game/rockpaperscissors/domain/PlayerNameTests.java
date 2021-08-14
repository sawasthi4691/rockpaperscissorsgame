package com.game.rockpaperscissors.domain;

import com.game.rockpaperscissors.domain.Player.PlayerName;
import org.junit.Test;

import static com.game.rockpaperscissors.domain.FixtureFactory.VALID_PLAYER_NAME_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerNameTests {

    @Test
    public void givenValidPlayerNamesWithEqualValuesWhenEqualsThenReturnTrue() {
        PlayerName aPlayerName = PlayerName.of(VALID_PLAYER_NAME_ONE);
        PlayerName anotherPlayerName = PlayerName.of(VALID_PLAYER_NAME_ONE);
        assertEquals(aPlayerName, anotherPlayerName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenAnInvalidPlayerNameValueWhenOfThenThrowException() {
        PlayerName.of(FixtureFactory.INVALID_PLAYER_NAME_NULL_VALUE);
    }
}
