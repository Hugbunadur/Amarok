package is.ru.tictactoe;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class Player {
    protected static In in = new In();
    protected static Out out = new Out();
    
    private int wins;
    private int draws;
    private String username;

    public Player(){
	   wins = 0;
    }
    
    public void setWins(int new_win){
	   wins = new_win;
    }
    
    public int getWins(){
	   return wins;
    }

    public void setDraw(int new_draw){
        draws = new_draw;
    }

    public int getDraw(){
        return draws;
    }

    public String getUsername(){
	return username;
    }
    
    public void setUsername(String new_Username){
	   username = new_Username;
    }
    
    public Point nextMove(){ return null; } //function for @Override
}