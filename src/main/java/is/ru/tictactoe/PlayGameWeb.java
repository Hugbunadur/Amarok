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
    	final Player player = new Player(); 
    	final HumanPlayer humplayer = new HumanPlayer();
    	final ComputerPlayer compplayer = new ComputerPlayer();

        post(new Route("Player vs Computer"){
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

 
    }
}


