
package spacestallions.tictactoe;

import static spark.Spark.*;
import spark.*;

public class TicTacToe
{
	// The entry point of the game logic, this is called from the /clickcell route below
	public static Object clickCell (String gameState, int player, int cellNumber)
	{
		// TODO: add more subroutines (and respective unit tests) and statements for game logic
		// We need to switch the player number between 1 and 2, determine whether clicking a cell was a valid move
		// and of course detect a winning / losing / tie condition
		// Finally wrap all that info into the json string and return to the ajax .done function and update the client side...

		String json = "{ \"player\": " + Integer.toString (player) + ", \"valid\": \"true\", \"endGame\": 0 }";

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
				String gameState = req.queryParams ("state");
				int player = Integer.valueOf (req.queryParams ("player"));
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