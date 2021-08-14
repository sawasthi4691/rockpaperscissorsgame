package com.game.rockpaperscissors.util;

import com.game.rockpaperscissors.domain.Game;

import static com.game.rockpaperscissors.util.GameMode.*;

/**
 * Contains Constant
 */
public interface GameConstant {

    GameMode DEFAULT_GAME_MODE = AUTO;
    String DEFAULT_GAME_MODE_NAME = DEFAULT_GAME_MODE.name();
    int DEFAULT_GAME_ITERATIONS_VALUE = 10;
    Game.Iterations DEFAULT_GAME_ITERATIONS = Game.Iterations.of(DEFAULT_GAME_ITERATIONS_VALUE);
    String COMP_ONE_NAME = "COMP_ONE";
    String COMP_TWO_NAME = "COMP_TWO";
    String  GAME_SUMMARY_HORIZONTAL_LINE = "----------------------------------------------------";
    String GAME_MODE_OPTION_ARG_NAME = "mode";
    String FIRST_PLAYER_NAME_ARG_NAME = "firstPlayer";
    String SECOND_PLAYER_NAME_ARG_NAME = "secondPlayer";
        String GAME_ITERATIONS_OPTION_ARG_NAME = "iterations";
    String ROCK_PAPER_SCISSORS_GAME_USAGE = "Usage : --mode=[fair, unfair, remote] --iterations=non_zero_positive_integer --file=output_filename";
    String INVALID_ARGUMENTS_ERROR_MSG = "Invalid input arguments!!!!";
    int SUCCESS_EXIT_CODE = 0;
    int FAILURE_EXIT_CODE = -1;
}
