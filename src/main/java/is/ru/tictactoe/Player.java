package is.ru.tictactoe;


public class Player {
   
    private int wins;
    private int lost;
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

    public void setLost(int new_lost){
        lost = new_lost;
    }

    public int getLost(){
        return lost;
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
