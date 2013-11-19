
package spacestallions.tictactoe;

import static spark.Spark.*;
import spark.*;

public class TicTacToe
{
	public String greet() {
		return "Welcome to TicTacToe!";
	}

	public static void main (String[] args)
	{
		staticFileLocation("/public");     
		setPort(Integer.valueOf(System.getenv("PORT")));

		get(new Route("/") {
			@Override
			public Object handle(Request request, Response response) {
				return "SpaceStallions TicTacToe";
			}
		});

		get(new Route("/") {
			@Override
			public Object handle(Request request, Response response) {
				return request.body();
			}
		});
	}
}
