
package spacestallions.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

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
		String gameState = "200002111";
		assertEquals (TicTacToe.detectEndGame(gameState.toCharArray()), 1);
	}

	@Test
	public void testEndGameTwo()
	{
		String gameState = "112221121";
		assertEquals (TicTacToe.detectEndGame(gameState.toCharArray()), 2);
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
