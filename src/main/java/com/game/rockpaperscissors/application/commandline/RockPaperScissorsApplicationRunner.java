package com.game.rockpaperscissors.application.commandline;

import com.game.rockpaperscissors.domain.Game;
import com.game.rockpaperscissors.domain.GamePlay;
import com.game.rockpaperscissors.domain.Player;
import com.game.rockpaperscissors.service.GameServiceIntf;
import com.game.rockpaperscissors.service.PrintServiceIntf;
import com.game.rockpaperscissors.util.GameMode;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.game.rockpaperscissors.util.GameConstant.*;
import static java.lang.System.exit;

/**
 * A SpringBoot based, command line Rock, Paper, Scissors Game implementation
 */
@Profile("tool")
@Component
public class RockPaperScissorsApplicationRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(RockPaperScissorsApplicationRunner.class);

    private PrintServiceIntf printService;
    private GameServiceIntf gameService;

    @Autowired
    public RockPaperScissorsApplicationRunner(PrintServiceIntf printService, GameServiceIntf gameService){
        this.printService = printService;
        this.gameService = gameService;
    }

    @Override
    public void run(ApplicationArguments arguments) {
        try {
            GameMode selectedGameMode = getGameMode(arguments);
            Game.Iterations selectedGameIterations = getGameIterations(arguments);
            Player.PlayerName selectedFirstPlayer = getFirstPlayerName(arguments);
            Player.PlayerName selectedSecondPlayer = getSecondPlayerName(arguments);
            logger.info("Playing Rock Paper Scissors in mode  {} with iterations  {} , and printing to Console" , selectedGameMode , selectedGameIterations);
            Collection<GamePlay> gamePlays = gameService.performSelectedGamePlays(selectedGameMode, selectedGameIterations,selectedFirstPlayer,selectedSecondPlayer);
            Game.GameSummary gameSummary = gameService.getGameSummary(gamePlays);
            printService.printToConsole(gamePlays, gameSummary);
            exitApplicationWithSuccess();
        } catch (IllegalArgumentException e) {
            exitApplicationWithFailure();
        }
    }

    /**
     * Gets the Player from the given command line arguments. Argument validation is also performed. In case there
     * is no matching argument in the command line, a default is provided that is COMPUTER.
     * @param arguments  <p>the command line arguments to get the player name</p>
     * @return  <p>the playername parsed from the command line arguments</p>
     */
    private Player.PlayerName getFirstPlayerName(ApplicationArguments arguments) {
        Optional<List<String>> playerName = Optional.ofNullable(arguments.getOptionValues(FIRST_PLAYER_NAME_ARG_NAME));
        Optional<String> gameModePlayerName = playerName.flatMap(g -> g.stream().findFirst());
        return gameModePlayerName.map(s -> Player.PlayerName.of(s.toLowerCase())).orElse(Player.PlayerName.of(COMP_ONE_NAME));
    }

    /**
     * Gets the Player from the given command line arguments. Argument validation is also performed. In case there
     * is no matching argument in the command line, a default is provided that is COMPUTER.
     * @param arguments  <p>the command line arguments to get the player name</p>
     * @return  <p>the playername parsed from the command line arguments</p>
     */
    private Player.PlayerName getSecondPlayerName(ApplicationArguments arguments) {
        Optional<List<String>> playerName = Optional.ofNullable(arguments.getOptionValues(SECOND_PLAYER_NAME_ARG_NAME));
        Optional<String> gameModePlayerName = playerName.flatMap(g -> g.stream().findFirst());
        return gameModePlayerName.map(s -> Player.PlayerName.of(s.toLowerCase())).orElse(Player.PlayerName.of(COMP_ONE_NAME));
    }

    /**
     * Gets the GameMode from the given command line arguments. Argument validation is also performed. In case there
     * is no matching argument in the command line, a sensible default is provided
     * @param arguments <p>the command line arguments to get the GameMode from</p>
     * @return <p>the GameMode parsed from the command line arguments</p>
     */
    GameMode getGameMode(ApplicationArguments arguments) {
        Optional<List<String>> gameModeOptions = Optional.ofNullable(arguments.getOptionValues(GAME_MODE_OPTION_ARG_NAME));
        Optional<String> gameModeName = gameModeOptions.flatMap(g -> g.stream().findFirst());
        return gameModeName.map(gmn -> GameMode.valueOf(gmn.toUpperCase())).orElse(DEFAULT_GAME_MODE);
    }

    /**
     * Gets the Iterations from the given command line arguments. Argument validation is also performed. In case there
     * is no matching argument in the command line, a sensible default is provided
     * @param arguments <p>the command line arguments to get the Iterations from</p>
     * @return <p>the Iterations parsed from the command line arguments</p>
     */
    Game.Iterations getGameIterations(ApplicationArguments arguments) {
        Optional<List<String>> gameIterationsOptions =
                Optional.ofNullable(arguments.getOptionValues(GAME_ITERATIONS_OPTION_ARG_NAME));
        Optional<String> gameIterations = gameIterationsOptions.flatMap(g -> g.stream().findFirst());
        int correctedGameIterations = gameIterations.map(Integer::parseInt).orElse(DEFAULT_GAME_ITERATIONS_VALUE);
        return Game.Iterations.of(correctedGameIterations);
    }


    void exitApplicationWithSuccess() {
        exit(SUCCESS_EXIT_CODE);
    }

    void exitApplicationWithFailure() {
        logger.error(INVALID_ARGUMENTS_ERROR_MSG);
        logger.error(ROCK_PAPER_SCISSORS_GAME_USAGE);
        exit(FAILURE_EXIT_CODE);
    }
}
