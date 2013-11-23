
package spacestallions.tictactoe;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import spark.Spark;

public class TicTacToeTest
{
	@Test
	public void testJsonFromClickCell()
	{
		String expected = "{ \"nextPlayer\": \"O\", \"validMove\": true, \"endGame\": 0 }";

		assertEquals (TicTacToe.clickCell ("000000000".toCharArray(), 'X', 1), expected);
	}

	@Test
	public void testEndGameZero()
	{
		String gameState = "120010000";
		assertEquals (TicTacToe.detectEndGame(gameState.toCharArray()), 0);
	}

	@Test
	public void testEndGameOne()
	{
		String gameState1 = "200002111";
		assertEquals (TicTacToe.detectEndGame(gameState1.toCharArray()), 1);
		String gameState2 = "200111200";
		assertEquals (TicTacToe.detectEndGame(gameState2.toCharArray()), 1);
		String gameState3 = "111002002";
		assertEquals (TicTacToe.detectEndGame(gameState3.toCharArray()), 1);
		String gameState4 = "100102102";
		assertEquals (TicTacToe.detectEndGame(gameState4.toCharArray()), 1);
		String gameState5 = "010010212";
		assertEquals (TicTacToe.detectEndGame(gameState5.toCharArray()), 1);
		String gameState6 = "221001001";
		assertEquals (TicTacToe.detectEndGame(gameState6.toCharArray()), 1);
		String gameState7 = "100010221";
		assertEquals (TicTacToe.detectEndGame(gameState7.toCharArray()), 1);
		String gameState8 = "001010122";
		assertEquals (TicTacToe.detectEndGame(gameState8.toCharArray()), 1);
	}

	@Test
	public void testEndGameTwo()
	{
		String gameState1 = "222101011";
		assertEquals (TicTacToe.detectEndGame(gameState1.toCharArray()), 1);
		String gameState2 = "110222011";
		assertEquals (TicTacToe.detectEndGame(gameState2.toCharArray()), 1);
		String gameState3 = "110110222";
		assertEquals (TicTacToe.detectEndGame(gameState3.toCharArray()), 1);
		String gameState4 = "211200211";
		assertEquals (TicTacToe.detectEndGame(gameState4.toCharArray()), 1);
		String gameState5 = "021121120";
		assertEquals (TicTacToe.detectEndGame(gameState5.toCharArray()), 1);
		String gameState6 = "002112112";
		assertEquals (TicTacToe.detectEndGame(gameState6.toCharArray()), 1);
		String gameState7 = "201121102";
		assertEquals (TicTacToe.detectEndGame(gameState7.toCharArray()), 1);
		String gameState8 = "112020211";
		assertEquals (TicTacToe.detectEndGame(gameState8.toCharArray()), 1);
	}

	@Test
	public void testPlayerSwitchToOne()
	{
		assertEquals (TicTacToe.switchPlayer('X'), 'O');
	}

	@Test
	public void testPlayerSwitchToTwo()
	{
		assertEquals (TicTacToe.switchPlayer('O'), 'X');
	}

}
