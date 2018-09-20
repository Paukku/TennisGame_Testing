import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest3 {

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
