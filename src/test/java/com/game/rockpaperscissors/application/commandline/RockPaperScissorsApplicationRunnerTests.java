package com.game.rockpaperscissors.application.commandline;

import com.game.rockpaperscissors.service.GameServiceIntf;
import com.game.rockpaperscissors.service.PrintServiceIntf;
import org.junit.Test;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import static com.game.rockpaperscissors.util.GameConstant.*;
import static com.game.rockpaperscissors.util.GameMode.AUTO;
import static org.junit.Assert.assertEquals;

public class RockPaperScissorsApplicationRunnerTests {

    private static final String INVALID_MODE_NAME = "Something";
    private static final String INVALID_ITERATIONS_VALUE = "121D";
    private static final String INVALID_NEGATIVE_ITERATIONS_VALUE = "-10";
    private static final int VALID_ITERATIONS_VALUE = 12;
    private static final String VALID_ITERATIONS = String.valueOf(VALID_ITERATIONS_VALUE);
    private static final String COMMAND_LINE_OPTION_PREFIX = "--";
    private static final String SOME_RANDOM_COMMAND_LINE_OPTION = COMMAND_LINE_OPTION_PREFIX + "somethingElse";

    private GameServiceIntf gameServiceIntf;
    private PrintServiceIntf printServiceIntf;

    private RockPaperScissorsApplicationRunner rockPaperScissorsApplicationRunner =
            new RockPaperScissorsApplicationRunner(printServiceIntf,gameServiceIntf);

    @Test
    public void givenCommandLineArgumentsWithValidModeWhenGetGameModeThenReturnCorrectMode() {
        ApplicationArguments applicationArguments =
                new DefaultApplicationArguments(newCommandLineArgumentsWithMode(AUTO.name()));
        assertEquals(rockPaperScissorsApplicationRunner.getGameMode(applicationArguments), AUTO);
    }

    @Test
    public void givenCommandLineArgumentsWithValidModeButLowercaseWhenGetGameModeThenReturnCorrectMode() {
        ApplicationArguments applicationArguments =
                new DefaultApplicationArguments(newCommandLineArgumentsWithMode(AUTO.name().toLowerCase()));
        assertEquals(rockPaperScissorsApplicationRunner.getGameMode(applicationArguments), AUTO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenCommandLineArgumentsWithInvalidModeWhenGetGameModeThenThrowException() {
        ApplicationArguments applicationArguments =
                new DefaultApplicationArguments(newCommandLineArgumentsWithMode(INVALID_MODE_NAME));
        rockPaperScissorsApplicationRunner.getGameMode(applicationArguments);
    }

    @Test
    public void givenCommandLineArgumentsWithNoModeWhenGetGameModeThenReturnDefaultGameMode() {
        ApplicationArguments applicationArguments =
                new DefaultApplicationArguments(newCommandLineArgumentsWithNoMode());
        assertEquals(rockPaperScissorsApplicationRunner.getGameMode(applicationArguments), DEFAULT_GAME_MODE);
    }

    @Test
    public void givenCommandLineArgumentsWithEmptyModeWhenGetGameModeThenReturnDefaultGameMode() {
        ApplicationArguments applicationArguments =
                new DefaultApplicationArguments(newCommandLineArgumentsWithEmptyMode());
        assertEquals(rockPaperScissorsApplicationRunner.getGameMode(applicationArguments), DEFAULT_GAME_MODE);
    }

    @Test
    public void givenCommandLineArgumentsWithEmptyIterationsWhenGetGameIterationsThenReturnDefault() {
        ApplicationArguments applicationArgumentsWithEmptyIterations =
                new DefaultApplicationArguments(newCommandLineArgumentsWithEmptyIterations());
        assertEquals(
                rockPaperScissorsApplicationRunner.getGameIterations(applicationArgumentsWithEmptyIterations),
                DEFAULT_GAME_ITERATIONS);
    }

    @Test
    public void givenCommandLineArgumentsWithNoIterationsWhenGetGameIterationsThenReturnDefault() {
        ApplicationArguments applicationArgumentsWithNoIterations =
                new DefaultApplicationArguments(newCommandLineArgumentsWithNoIterations());
        assertEquals(
                rockPaperScissorsApplicationRunner.getGameIterations(applicationArgumentsWithNoIterations),
                DEFAULT_GAME_ITERATIONS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenCommandLineArgumentsWithInvalidIterationsWhenGetGameIterationsThenThrowException() {
        ApplicationArguments applicationArguments =
                new DefaultApplicationArguments(newCommandLineArgumentsWithIterations(INVALID_ITERATIONS_VALUE));
        rockPaperScissorsApplicationRunner.getGameIterations(applicationArguments);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenCommandLineArgumentsWithNoGreaterZeroIterationsWhenGetGameIterationsThenThrowException() {
        ApplicationArguments applicationArguments =
                new DefaultApplicationArguments(newCommandLineArgumentsWithIterations(INVALID_NEGATIVE_ITERATIONS_VALUE));
        rockPaperScissorsApplicationRunner.getGameIterations(applicationArguments);
    }

    @Test
    public void givenCommandLineArgumentsWithValidIterationsWhenGetGameIterationsThenReturnCorrectValue() {
        ApplicationArguments applicationArguments =
                new DefaultApplicationArguments(newCommandLineArgumentsWithIterations(VALID_ITERATIONS));
        assertEquals(rockPaperScissorsApplicationRunner.getGameIterations(applicationArguments).getValue(),
                VALID_ITERATIONS_VALUE);
    }



    private String[] newCommandLineArgumentsWithMode(String modeName) {
        String gameModeOption = COMMAND_LINE_OPTION_PREFIX + GAME_MODE_OPTION_ARG_NAME + "=" + modeName;
        return new String[] { gameModeOption };
    }

    private String[] newCommandLineArgumentsWithIterations(String iterations) {
        String gameIterationsOption = COMMAND_LINE_OPTION_PREFIX + GAME_ITERATIONS_OPTION_ARG_NAME + "=" + iterations;
        return new String[] { gameIterationsOption };
    }


    private String[] newCommandLineArgumentsWithNoIterations() {
        return newCommandLineArgumentsWithRandomOptions();
    }

    private String[] newCommandLineArgumentsWithNoMode() {
        return newCommandLineArgumentsWithRandomOptions();
    }

    private String[] newCommandLineArgumentsWithRandomOptions() {
        return new String[] {SOME_RANDOM_COMMAND_LINE_OPTION};
    }

    private String[] newCommandLineArgumentsWithEmptyMode() {
        String emptyGameModeOption = COMMAND_LINE_OPTION_PREFIX + GAME_MODE_OPTION_ARG_NAME;
        return new String[] { emptyGameModeOption };
    }

    private String[] newCommandLineArgumentsWithEmptyIterations() {
        String emptyGameIterationsOption = COMMAND_LINE_OPTION_PREFIX + GAME_ITERATIONS_OPTION_ARG_NAME;
        return new String[] { emptyGameIterationsOption };
    }


}
