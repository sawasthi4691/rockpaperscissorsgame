package com.game.rockpaperscissors.service;

import com.game.rockpaperscissors.domain.Game;
import com.game.rockpaperscissors.domain.GamePlay;
import com.game.rockpaperscissors.domain.Player;
import com.game.rockpaperscissors.domain.movestrategies.MoveStrategy;
import com.game.rockpaperscissors.util.GameMode;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

import static com.game.rockpaperscissors.util.GameConstant.COMP_ONE_NAME;
import static com.game.rockpaperscissors.util.GameConstant.COMP_TWO_NAME;

@Service
public class GameService implements GameServiceIntf {


    @Qualifier("randomMoveStrategy")
    private MoveStrategy randomMoveStrategy;

    private Game classicGame;

    @Autowired
    public GameService(MoveStrategy randomMoveStrategy,Game classicGame){
        this.randomMoveStrategy = randomMoveStrategy;
        this.classicGame = classicGame;

    }

    /**
     * Performs a number of Rock, Paper, Scissors game plays in the given mode and for the given number of iterations
     * @param selectedGameMode       <p>the GameMode in which to perform the game plays</p>
     * @param selectedGameIterations <p>the number of game plays to perform</p>
     * @param selectedPlayerName  <p>the name of players to perform</p>
     * @return <p>a collection of the game plays performed</p>
     */
    @Override
    public Collection<GamePlay> performSelectedGamePlays(GameMode selectedGameMode, Game.Iterations selectedGameIterations, Player.PlayerName selectedPlayerName,Player.PlayerName selectedPlayerName2) {
        Collection<GamePlay> gamePlays = new ArrayList<>();
        if (selectedGameMode == GameMode.AUTO) {
            gamePlays = performAutoPlays(selectedGameIterations);
        } else if (selectedGameMode == GameMode.SINGLE_PLAYER) {
            gamePlays = performPlayerPlays(selectedGameIterations, selectedPlayerName);
        }else if(selectedGameMode == GameMode.BOTH_PLAYER){
            gamePlays = performBothPlayerPlays(selectedGameIterations,selectedPlayerName,selectedPlayerName2);
        }
        return gamePlays;
    }

    /**
     * Performs the given number of game plays in the given AUTO mode.
     * @param iterations <p>the number of game plays to perform</p>
     * @return <p>a collection of game plays performed in FAIR mode</p>
     */
    private Collection<GamePlay> performAutoPlays(Game.Iterations iterations) {
        Player playerOne = Player.newPlayer(Player.PlayerName.of(COMP_ONE_NAME), randomMoveStrategy);
        Player playerTwo = Player.newPlayer(Player.PlayerName.of(COMP_TWO_NAME), randomMoveStrategy);
        return classicGame.play(iterations, playerOne, playerTwo);
    }

    /**
     * Performs the given number of game plays in SINGLE_PLAYER mode
     * @param iterations <p>the number of game plays to perform</p>
     * @param selectedPlayerName  <p>the name of players to perform</p>
     * @return <p>a collection of game plays performed in SINGLE_PLAYER mode</p>
     */
    private Collection<GamePlay> performPlayerPlays(Game.Iterations iterations,Player.PlayerName selectedPlayerName) {
        Player playerOne = Player.newPlayer(Player.PlayerName.of(selectedPlayerName.getValue()), randomMoveStrategy);
        Player playerTwo = Player.newPlayer(Player.PlayerName.of(COMP_TWO_NAME), randomMoveStrategy);
        return classicGame.play(iterations, playerOne, playerTwo);
    }


    /**
     * Performs the given number of game plays in BOTH_PLAYER mode
     * @param iterations <p>the number of game plays to perform</p>
     * @param selectedPlayerName  <p>the name of players to perform</p>
     * @param selectedPlayerName2  <p>the name of players to perform</p>
     * @return <p>a collection of game plays performed in BOTH_PLAYER mode</p>
     */
    private Collection<GamePlay> performBothPlayerPlays(Game.Iterations iterations,Player.PlayerName selectedPlayerName, Player.PlayerName selectedPlayerName2) {
        Player playerOne = Player.newPlayer(Player.PlayerName.of(selectedPlayerName.getValue()), randomMoveStrategy);
        Player playerTwo = Player.newPlayer(Player.PlayerName.of(selectedPlayerName2.getValue()), randomMoveStrategy);
        return classicGame.play(iterations, playerOne, playerTwo);
    }

    /**
     * Gets the GameSummary for the given game plays. Just added this one liner for easier testing
     */
    public Game.GameSummary getGameSummary(Collection<GamePlay> gamePlays) {
        return classicGame.summarize(gamePlays);
    }


}
