
package spacestallions.tictactoe;

import static spark.Spark.*;
import spark.*;

public class TicTacToe
{
	static final int GAME_CONTINUE = 0;
	static final int GAME_WIN = 1;
	static final int GAME_TIE = 2;

    // Switches player between X and O
    // If input is X, O is returned, and if input is O, X is returned
    public static char switchPlayer(char currentPlayer)
    {
        return (currentPlayer == 'X' ? 'O' : 'X');
    }

    // Detects whether the game has ended after this move is made
    // Returns 1 if the current player has won, 2 if there is a tie and 0 if the game has not ended
    public static int detectEndGame(char[] gameState)
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
        {
            return GAME_WIN;
        }

        // No one has won yet? Let's see if there is a tie...
        for (int i = 0 ; i < 9 ; i++)
        {
            if (gameState[i] == '0')
            {
                return GAME_CONTINUE;   // Nope, there is an unused cell left
            }
        }

        // Yup, it's a tie
        return GAME_TIE;
    }

    // The entry point of the game logic, this is called from the /clickcell route below
    public static Object clickCell(char[] gameState, char player, int cellNumber)
    {
        boolean validMove = false;
        int endGame = 0;

        if (gameState[cellNumber - 1] == '0')
        {
            validMove = true;
            gameState[cellNumber - 1] = player;

            endGame = detectEndGame(gameState);

            player = switchPlayer(player);
        }

        String json = "{ \"nextPlayer\": \"" + String.valueOf (player) + "\", \"validMove\": " + String.valueOf (validMove) + ", \"endGame\": " + String.valueOf (endGame) + " }";

        return json;
    }

    // Setup the environment
    public static Boolean setupEnviroment()
    {
        try {


        }
        catch (Exception err){
            System.out.println("Error occurred while setting up the environment, error: " + err.getMessage());
            return false;
        }
        return true;
    }

    // This route is called through AJAX when a player clicks a cell in the game board
    // Returns a json string back to the done() function in the javascript part of index.html
    public static boolean routeRequest(){
        try {
            get (new Route ("/clickcell")
            {
                @Override
                public Object handle(Request req, Response res)
                {
                    char[] gameState = req.queryParams("state").toCharArray();
                    char player = req.queryParams("player").charAt(0);
                    int cellNumber = Integer.valueOf(req.queryParams("cell"));

                    return clickCell(gameState, player, cellNumber);
                }
            });
        }
        catch (Exception err){
            System.out.println("Error occurred while processing a request route for clickcell, error: " + err.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        setupEnviroment();
        routeRequest();
    }
}