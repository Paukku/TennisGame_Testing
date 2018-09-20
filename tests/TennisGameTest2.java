import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest2 {
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_Player1Have1MorePoint() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Player1 has advantage", "player1 has advantage", score);
		
		
	}
	@Test
	public void testTennisGame_Player2Have1MorePoint() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Player2 has advantage", "player2 has advantage", score);
		
		
	}
}
