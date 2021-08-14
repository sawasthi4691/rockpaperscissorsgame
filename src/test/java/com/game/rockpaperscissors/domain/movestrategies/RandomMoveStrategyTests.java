package com.game.rockpaperscissors.domain.movestrategies;

import org.junit.Test;
import org.assertj.core.util.Lists;

import static org.junit.Assert.assertTrue;

public class RandomMoveStrategyTests {

    @Test(expected = IllegalArgumentException.class)
    public void givenAnEmptyMovesListWhenNewRandomMoveStrategyThenThrowsException() {
        new RandomMoveStrategy(Lists.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenANullMovesListWhenNewRandomMoveStrategyThenThrowsException() {
        new RandomMoveStrategy(null);
    }


}
