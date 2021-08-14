package com.game.rockpaperscissors.service;

import com.game.rockpaperscissors.domain.Game;
import com.game.rockpaperscissors.domain.GamePlay;

import java.util.Collection;

@FunctionalInterface
public interface PrintServiceIntf {

    void printToConsole(Collection<GamePlay> gamePlays, Game.GameSummary gameSummary);
}
