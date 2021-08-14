package com.game.rockpaperscissors.service;

import com.game.rockpaperscissors.domain.Game;
import com.game.rockpaperscissors.domain.GamePlay;
import com.game.rockpaperscissors.domain.Player;
import com.game.rockpaperscissors.util.GameMode;

import java.util.Collection;

public interface GameServiceIntf {

    Collection<GamePlay> performSelectedGamePlays(GameMode selectedGameMode, Game.Iterations selectedGameIterations, Player.PlayerName selectedPlayerName,Player.PlayerName selectedPlayerName2);

    Game.GameSummary getGameSummary(Collection<GamePlay> gamePlays);
}
