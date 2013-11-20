
package spacestallions.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest
{
	@Test
	public void greetResultsInWelcome(){
		TicTacToe ttt = new TicTacToe();
		assertEquals("Welcome to TicTacToe!",ttt.greet());
	}

	@Test
	public void testJsonFromClickCell ( )
	{
		String expected = "{ \"player\": 1, \"valid\": \"true\", \"endGame\": 0 }";

		assertEquals (TicTacToe.clickCell ("000000000", 1, 1), expected);
	}
}
