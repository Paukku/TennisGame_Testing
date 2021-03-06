import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Both have zero points
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();
		String score = game.getScore();
		
		//Assert
		assertEquals("Player 1 win", "40", score);
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		//T�M� EI TOIMI VIEL� OIKEIN!!!!!!!
		game.player2Scored();
		String score = game.getScore();
		
		//Assert
		assertEquals("Player 2 win", "40", score);
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
	@Test
	public void testTennisGame_Player1Have1Point() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("love - 15", "love - 15", score);
	}
	@Test
	public void testTennisGame_Player1Have2Point() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("love - 30", "love - 30", score);
	}
	
	@Test
	public void testTennisGame_Player2Have1Point() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("15 - love", "15 - love", score);
	}
	@Test
	public void testTennisGame_Player2Have2Point() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("30 - love", "30 - love", score);
	}
	
	@Test
	public void testTennisGame_Player1Have1Point_Player2Have1Point() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("15 - 15", "15 - 15", score) ;
	}
	
	@Test
	public void testTennisGame_Player1Have2Point_Player2Have1Point() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("15 - 30", "15 - 30", score) ;
	}
	
	@Test
	public void testTennisGame_Player1Have1Point_Player2Have2Point() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("30 - 15", "30 - 15", score) ;
	}
	
	@Test
	public void testTennisGame_Player1Have2Point_Player2Have2Point() throws TennisGameException{
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("30 - 30", "30 - 30", score) ;
	}

}
