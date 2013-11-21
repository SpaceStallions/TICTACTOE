
package spacestallions.tictactoe;

import static spark.Spark.*;
import spark.*;

public class TicTacToe
{
	public static char switchPlayer (char currentPlayer)
	{
		if (currentPlayer == 'X')
			return 'O';
		else
			return 'X';
	}

	// Detects whether the game has ended after this move is made
	// Returns 1 if the current player has won, 2 if there is a tie and 0 if the game has not ended
	public static int detectEndGame (char[] gameState)
	{
		// Let's scan over all the possible ways to win in Tic Tac Toe
		if (((gameState[0] == gameState[1]) && (gameState[1] == gameState[2]) && gameState[2] != '0')
		|| ((gameState[3] == gameState[4]) && (gameState[4] == gameState[5]) && gameState[5] != '0')
		|| ((gameState[6] == gameState[7]) && (gameState[7] == gameState[8]) && gameState[8] != '0')
		|| ((gameState[0] == gameState[3]) && (gameState[3] == gameState[6]) && gameState[6] != '0')
		|| ((gameState[1] == gameState[4]) && (gameState[4] == gameState[7]) && gameState[7] != '0')
		|| ((gameState[2] == gameState[5]) && (gameState[5] == gameState[8]) && gameState[8] != '0')
		|| ((gameState[2] == gameState[4]) && (gameState[4] == gameState[6]) && gameState[6] != '0')
		|| ((gameState[0] == gameState[4]) && (gameState[4] == gameState[8]) && gameState[8] != '0'))
			return 1;

		// No one has won yet? Let's see if there is a tie...
		for (int i = 0 ; i < 9 ; i++)
		{
			if (gameState[i] == '0')
				return 0;	// Nope, there is an unused cell left
		}

		// Yup, it's a tie
		return 2;
	}

	// The entry point of the game logic, this is called from the /clickcell route below
	public static Object clickCell (char[] gameState, char player, int cellNumber)
	{
		boolean validMove = false;
		int endGame = 0;

		if (gameState[cellNumber - 1] == '0')
		{
			validMove = true;
			gameState[cellNumber - 1] = player;

			endGame = detectEndGame (gameState);

			player = switchPlayer (player);
		}

		String json = "{ \"nextPlayer\": \"" + String.valueOf (player) + "\", \"validMove\": " + String.valueOf (validMove) + ", \"endGame\": " + String.valueOf (endGame) + " }";

		return json;
	}

	public String greet() {
		return "Welcome to TicTacToe!";
	}

	public static void main (String[] args)
	{
		staticFileLocation("/public");

		// The port that we should run on can be set into an environment variable
		// Look for that variable and default to 8080 if it isn't there.
		String webPort =  System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()){
			webPort = "4567";
		}

		setPort(Integer.valueOf(webPort));

		// This route is called through AJAX when a player clicks a cell in the game board
		// Returns a json string back to the done() function in the javascript part of index.html
		get (new Route ("/clickcell")
		{
			@Override
			public Object handle (Request req, Response res)
			{
				char[] gameState = req.queryParams ("state").toCharArray ( );
				char player = req.queryParams ("player").charAt (0);
				int cellNumber = Integer.valueOf (req.queryParams ("cell"));

				return clickCell (gameState, player, cellNumber);
			}
		});

		get(new Route("/gettest") {
			@Override
			public Object handle(Request request, Response response) {
				return "SpaceStallions TicTacToe";
			}
		});

		post(new Route("/addtest") {
			@Override
			public Object handle(Request request, Response response) {
				return request.body();
			}
		});
	}
}