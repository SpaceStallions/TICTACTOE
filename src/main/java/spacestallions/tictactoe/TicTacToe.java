
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

        // The port that we should run on can be set into an environment variable
        // Look for that variable and default to 8080 if it isn't there.
        String webPort =  System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()){
            webPort = "4567";
        }
        setPort(Integer.valueOf(webPort));


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