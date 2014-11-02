package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class PlayGameWeb implements SparkApplication {
    public static void main(String[] args){
	staticFileLocation("/public");
	SparkApplication playgameweb = new PlayGameWeb();
	String port = System.getenv("PORT");
	if (port != null) {
            setPort(Integer.valueOf(port));
        }
        playgameweb.init();
    }

    public void init(){
	final PlayGame playgame = new PlayGame();
	final HumanPlayer humplayerA = new HumanPlayer();
	final HumanPlayer humplayerB = new HumanPlayer();
	final ComputerPlayer compplayerA = new ComputerPlayer();
	final ComputerPlayer compplayerB = new ComputerPlayer();

	post(new Route("/username"){
                @Override
		    public Object handle(Request request, Response response){
		    String user = request.queryParams("id");
		    humplayerA.setUsername(user);
		    //response.status(200);
		    return humplayerA.getUsername();
		        
		}
	    });
	
	post(new Route("/computervscomputer"){
		@Override
		    public Object handle(Request request, Response response){
		    String resultSet = ""; 
		    Point point;
		    boolean win = false;
		    int finishGame = 0;
		    String symbol = "X";
		    Player player, loser;
		    String[][] board = new String [3][3];
		    board = PlayGame.initialiazeTheBoard(board);
		    while(!win){
			if(finishGame % 2 != 0) { //player2 makes a move
			    player = compplayerB;
			    loser = compplayerA;
			    symbol = "O";
			}else { // player 1 makes a move
			    symbol = "X";
			    player = compplayerA;
			    loser = compplayerB; 
			}
        
			point = PlayGame.getApointFromThePlayer(player);
			if(PlayGame.checkForInvalidMove(board, point)){
			    point = PlayGame.makeAvalidMove(board, point, player); 
			}
			board = PlayGame.SetAsymbolOnTheBoard(board, point, symbol);
			finishGame++; //player1 has made a move
			resultSet += point.getX();
			resultSet += point.getY();
			resultSet += ",";        
			win = PlayGame.checkWins(board);
			if(win){
			    PlayGame.setVictoryForSpecificPlayer(player, compplayerB);
			    resultSet = resultSet.substring(0,resultSet.length() - 2);
			    return resultSet;
			}
            
			// check if draw
			if(PlayGame.checkDraw(finishGame, compplayerA, compplayerB)){
			    resultSet = resultSet.substring(0,resultSet.length() - 2);
			    return resultSet;
			}


		    }
		   resultSet = resultSet.substring(0,resultSet.length() - 2);
		    return resultSet;
		}

	    });


        /*post(new Route("Player vs Computer"){
	  @Override
	  public Object handle(Request request, Response response){
	  humplayer.setUsername(request.queryParams("HumanPlayer"));
	  response.status(200);
                return response;
		}
        });
        post(new Route("Player vs Player"){
        @Override
        public Object handle(Request request, Response response){
        humplayer.setUsername(request.queryParams("HumanPlayer1"));
        humplayer.setUsername(request.queryParams("HumanPlayer2"));
        response.status(200);
                return response;
		}
        });
	*/
 
    }
}