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

    public void testCheckForInvalidMove(){
	String[][] testBoard = new String [3][3];
	testBoard = PlayGame.initialiazeTheBoard(testBoard);
	
	testBoard[0][0] = "X";
	testBoard[0][2] = "X";
	testBoard[1][1] = "O";
	testBoard[1][2] = "O";
	testBoard[2][1] = "O";
	
	Point point = new Point(0, 0);
	boolean result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);
 
	point = new Point(0, 1);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result);

	point = new Point(0, 2);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);

	point = new Point(1, 0);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result);

	point = new Point(1, 1);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);
	
	point = new Point(1, 2);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);

	point = new Point(2, 0);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result);

	point = new Point(2, 1);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);

	point = new Point(2, 2);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result);
    }

    @Test
    public void testMakeAValidMove(){
	ComputerPlayer comp_player = new ComputerPlayer();
	String[][] arr = new String[3][3];
	arr = PlayGame.initialiazeTheBoard(arr);
	arr[0][0] = "X";
	arr[0][1] = "O";
	arr[0][2] = "X";
	arr[1][0] = "X";
	arr[1][1] = "O";
	arr[1][2] = "X";
	arr[2][0] = "O";
	arr[2][1] = "X";
	Point point = new Point(0,1);
	point = PlayGame.makeAvalidMove(arr, point, comp_player);
	assertEquals(point.getX(), 2);
	assertEquals(point.getY(), 2);

	//using same algorithm as above, test 50 different cases...
	int tmp1 = 0;
	int tmp2 = 0;
	for(int i = 0; i < 50; i++){
	    int a = rand.nextInt(3);
	    int b = rand.nextInt(3);
	    arr[a][b] = " "; //make a single point available in the tic-tac-toe
	    for(int j = 0; j < 3; j++){
		for(int k = 0; k < 3; k++){
		    if(!arr[a][b].equals(arr[j][k])) {
			arr[j][k] = "X";
			tmp1 = j;
			tmp2 = k; 
		    }
		}
	    }

	    point = new Point(tmp1, tmp2);
	    point = PlayGame.makeAvalidMove(arr, point, comp_player);

	    assertEquals(point.getX(), a);
	    assertEquals(point.getY(), b);
	    
	    for(int e = 0; e < 3; e++)
		for(int t = 0; t < 3; t++)
		    arr[e][t] = "X";
	    
	}
    }

    @Test
    public void testSetAsymbolOnTheBoard(){
	String[][] arr = new String[3][3];
	Point point = new Point(1, 1);
	String symbol = "X";
        arr = PlayGame.initialiazeTheBoard(arr);
	arr = PlayGame.SetAsymbolOnTheBoard(arr, point, symbol);
	assertEquals("X", arr[1][1]);

	for(int i = 0; i < 50; i++){
	    arr = PlayGame.initialiazeTheBoard(arr);
	    int x = rand.nextInt(3);
	    int y = rand.nextInt(3);
	    if(i % 2 == 0) symbol = "X";
	    else symbol = "O";
	    point = new Point(x, y);
	    arr = PlayGame.SetAsymbolOnTheBoard(arr, point, symbol);
	    assertEquals(symbol, arr[x][y]);
	}
    }

    @Test 
    public void testDraw(){
	ComputerPlayer comp_A = new ComputerPlayer();
	ComputerPlayer comp_B = new ComputerPlayer();
	for(int i = 0; i < 15; i++){
	    int finishGame = rand.nextInt(15);
	    if(finishGame < 9) assertEquals(false, PlayGame.checkDraw(finishGame, comp_A, comp_B));
	    else assertEquals(true, PlayGame.checkDraw(finishGame, comp_A, comp_B));
	}
    }

    @Test //check if computer returns the random coordinates in correct range, that is between 0 =< x =< 2
    public void testGetApointFromComputerPlayer(){ 
	ComputerPlayer comp = new ComputerPlayer();	
	for(int i = 0; i < 20; i++){
	    Point ptn = PlayGame.getApointFromThePlayer(comp);
	    if(ptn.getX() > 2 || ptn.getY() > 2) fail();
	}
    }

    @Test
    public void testCheckWinsHorizontal(){
	String[][] win = new String[3][3];
	//test horizontal
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 3; j++){
		if(i % 2 == 0) win[i][j] = "O";
		else win[i][j] = "X";
	    }
	assertEquals(true, PlayGame.checkWins(win));
	}
    }

    @Test
    public void testCheckWinsVertical(){
	String[][] win = new String[3][3];
	//test vertical
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 3; j++){
		if(i % 2 == 0)win[j][i] = "X";
		else win[j][i] = "O";
	    }
	    assertEquals(true, PlayGame.checkWins(win));
	}
    }
}
