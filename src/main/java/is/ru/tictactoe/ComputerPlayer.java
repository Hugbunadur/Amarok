package is.ru.tictactoe;

import java.util.Random;
public class ComputerPlayer extends Player{
    
    @Override 
    public Point nextMove(){

	Random rand = new Random(); 
	int coordinateX, coordinateY;
	coordinateX = rand.nextInt(3); //pick random x-coordinate
	coordinateY = rand.nextInt(3); //pick random y-coordinate
	
	Point ptn = new Point(coordinateX, coordinateY);
	return ptn;
	
    }

}
