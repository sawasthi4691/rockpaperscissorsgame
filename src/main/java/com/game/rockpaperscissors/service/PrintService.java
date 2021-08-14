package com.game.rockpaperscissors.service;

import com.game.rockpaperscissors.domain.Game;
import com.game.rockpaperscissors.domain.GamePlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.game.rockpaperscissors.util.GameConstant.GAME_SUMMARY_HORIZONTAL_LINE;

@Service
public class PrintService implements PrintServiceIntf {

    private static final Logger logger = LoggerFactory.getLogger(PrintService.class);

    /**
     * Prints the given game plays and summary to the system console
     *
     * @param gamePlays   <p>the game plays to print</p>
     * @param gameSummary <p>the game summary to print</p>
     */
    @Override
    public void printToConsole(Collection<GamePlay> gamePlays, Game.GameSummary gameSummary) {
        printGamePlays(gamePlays);
        printSummary(gameSummary);
    }

    /**
     * Prints the given game plays to the system console
     * @param gamePlays <p>the game plays to print</p>
     */
    private void printGamePlays(Collection<GamePlay> gamePlays) {
        gamePlays.stream().forEach(gp -> logger.info(gp.toString()));
    }

    /**
     * prints a summary of the given game plays to the system console
     * @param gameSummary <p>the game summary we would like to print</p>
     */
    private void printSummary(Game.GameSummary gameSummary) {
        logger.info(GAME_SUMMARY_HORIZONTAL_LINE);
        logger.info(gameSummary.toString());
    }

}
