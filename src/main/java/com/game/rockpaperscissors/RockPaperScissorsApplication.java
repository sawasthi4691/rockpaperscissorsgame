package com.game.rockpaperscissors;

import com.game.rockpaperscissors.domain.Game;
import com.game.rockpaperscissors.util.Move;
import com.game.rockpaperscissors.domain.movestrategies.MoveStrategy;
import com.game.rockpaperscissors.domain.moves.Paper;
import com.game.rockpaperscissors.domain.moves.Rock;
import com.game.rockpaperscissors.domain.moves.Scissors;
import com.game.rockpaperscissors.domain.movestrategies.RandomMoveStrategy;
import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * The Spring Boot entry point for the Rock Paper Scissors Game. This class also holds the Spring Configuration
 * that will be used for Bean creation and auto wiring
 */


@SpringBootApplication
public class RockPaperScissorsApplication {

	public static final ArrayList<Move> CLASSIC_MOVES = Lists.newArrayList(new Paper(), new Rock(), new Scissors());

    public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorsApplication.class, args);
	}

	@Bean("randomMoveStrategy")
	public MoveStrategy randomMoveStrategy() {
    	return new RandomMoveStrategy(CLASSIC_MOVES);
	}

    @Bean
	public Game classicRockPaperScissorsGame() {
        return new Game();
    }


}
