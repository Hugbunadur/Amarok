package is.ru.tictactoe;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import java.util.*;

public class PlayGameTest {
	private Random rand = new Random();

    @Test
    public void testInitialiazeTheBoard() {
	String[][] correctBoard = new String[3][3];
	
	correctBoard[0][0] = " ";
	correctBoard[0][1] = " ";	
	correctBoard[0][2] = " ";	

	correctBoard[1][0] = " ";	
	correctBoard[1][1] = " ";	
	correctBoard[1][2] = " ";	

	correctBoard[2][0] = " ";	
	correctBoard[2][1] = " ";	
	correctBoard[2][2] = " ";	
	
	String[][] testBoard = new String[3][3];
	testBoard = PlayGame.initialiazeTheBoard(testBoard);
	assertArrayEquals(correctBoard, testBoard);
    }

    @Test //check if computer returns the random coordinates in correct range, that is between 0 =< x =< 2
    public void testGetApointFromComputerPlayer(){ 

	ComputerPlayer comp = new ComputerPlayer();	
	for(int i = 0; i < 20; i++){
	    Point ptn = PlayGame.getApointFromThePlayer(comp);
	    if(ptn.getX() > 2 || ptn.getY() > 2) fail();
	}
}