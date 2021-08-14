package com.game.rockpaperscissors.domain;

import com.game.rockpaperscissors.domain.Game.GameSummary;
import com.game.rockpaperscissors.domain.Game.Iterations;
import com.game.rockpaperscissors.domain.Player.PlayerName;
import com.game.rockpaperscissors.domain.moves.Paper;
import com.game.rockpaperscissors.domain.moves.Rock;
import com.game.rockpaperscissors.domain.moves.Scissors;
import com.game.rockpaperscissors.domain.movestrategies.MoveStrategy;
import com.game.rockpaperscissors.domain.movestrategies.RandomMoveStrategy;
import com.game.rockpaperscissors.util.Move;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FixtureFactory {


    public static final ArrayList<Move> CLASSIC_MOVES = Lists.newArrayList(new Paper(), new Rock(), new Scissors());
    public static final String VALID_PLAYER_NAME_ONE = "ONE";
    public static final String VALID_PLAYER_NAME_TWO = "TWO";
    public static final String INVALID_PLAYER_NAME_NULL_VALUE = null;
    public static final PlayerName INVALID_NULL_PLAYER_NAME = null;

    public static final Player INVALID_PLAYER_TWO = null;
    public static final Player VALID_PLAYER_ONE = newRockMovingPlayer(VALID_PLAYER_NAME_ONE);
    public static final Player VALID_PLAYER_TWO = newRockMovingPlayer(VALID_PLAYER_NAME_TWO);

    public static final int INVALID_NEGATIVE_GAME_ITERATIONS_VALUE = -2;
    public static final int INVALID_ZERO_GAME_ITERATIONS_VALUE = 0;
    public static final int GREATER_ZERO_GAME_ITERATIONS_VALUE = 2;
    public static final Iterations GREATER_ZERO_GAME_ITERATIONS = Iterations.of(GREATER_ZERO_GAME_ITERATIONS_VALUE);
    public static final Iterations INVALID_GAME_ITERATIONS = null;


    public static PlayerName validPlayerName() {
        return validPlayerOneName();
    }

    public static PlayerName validPlayerOneName() {
        return PlayerName.of(VALID_PLAYER_NAME_ONE);
    }

    public static PlayerName validPlayerTwoName() {
        return PlayerName.of(VALID_PLAYER_NAME_TWO);
    }

    public static Player newRockMovingPlayer(String name) {
        PlayerName playerName = PlayerName.of(name);
        return Player.newPlayer(playerName, new RandomMoveStrategy(CLASSIC_MOVES));
    }


    public static GameSummary newPlayerOneAlwaysWinsGameSummary() {
        Map<PlayerName, Long> gamesWonByPlayerName = new HashMap<>();
        gamesWonByPlayerName.put(PlayerName.of(VALID_PLAYER_NAME_ONE), Long.valueOf(2));
        GameSummary playerOneAlwaysWinsGameSummary = new GameSummary(0, gamesWonByPlayerName);
        return playerOneAlwaysWinsGameSummary;
    }


}