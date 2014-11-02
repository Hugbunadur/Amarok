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
        		//compplayerA.(request.queryParams("ComputerPlayer"));
        		response.status(200);
                return response;
        	}

        });
/*
        post(new Route("/playervsplayer"){
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


