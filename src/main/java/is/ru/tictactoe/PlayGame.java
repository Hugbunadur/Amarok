package is.ru.tictactoe;

import java.util.Arrays;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class PlayGame {

    private final static int boardSize = 9;
    //from algs4
    private static In in = new In();     
    private static Out out = new Out();
    

    public static void main(String[] args){

	//the game has 3 modes: human vs. human, computer vs. computer and human vs. computer
	HumanPlayer human_A = new HumanPlayer();
	HumanPlayer human_B = new HumanPlayer();
	ComputerPlayer comp_A = new ComputerPlayer();
	ComputerPlayer comp_B = new ComputerPlayer();

	comp_A.setUsername("Awesom-O"); //set computer names
	comp_B.setUsername("R2-D2"); 

	printWelcome();
	//----------------
	String username = getUsernameForPlayer1(human_A);
	//----------------
	printMenu();

	String choice;
	int tmp = 1;
	do{ 
	    choice = selectGame();
	    if(choice.equals("1")|| choice.equals("2") ||choice.equals("3"))
	    out.print(referenceBoardToString());
	    if(choice.equals("0"))
	    printInfo();
	        
	    //set the game mode
	    else if(choice.equals("1")){
		if(tmp == 1){
		    tmp++;
		    out.print("Player 2 Username: "); username = in.readString();
		    out.println();
		    human_B.setUsername(username);
		}
		play(human_A, human_B);
	    }
	        
	    else if(choice.equals("2")) play(human_A, comp_A);
	    else if(choice.equals("3")) play(comp_A, comp_B);
	    else if(choice.equals("4")) break;
	        
	}while(choice.equals("1")|| choice.equals("2") ||choice.equals("3") || choice.equals("0"));
	printResults(human_A, human_B, comp_A, comp_B); 
   }

    //basic functions
    public static String getUsernameForPlayer1(HumanPlayer human_A){
	String username;
	out.println();
	out.print("Username: "); username = in.readString();
	out.println();
	human_A.setUsername(username);
	return username; 
    }

    public static String selectGame(){
	out.print("Your choice: "); String choice = in.readString();
	out.println();

	if(!Arrays.asList("1", "2", "3", "4",  "0").contains(choice)){
	    while(!Arrays.asList("1", "2", "3", "4", "0").contains(choice)){
		out.println("Illegal choice, please try again.");
		out.print("Your choice: "); choice = in.readString();
		out.println();
	    }
	}
	return choice;
    }
    
    //printing functions
    public static void printInfo(){
	out.println("---------------------------------------------------------------------"); 
	out.println("\t\t\tProduction of AMAROK");
	out.println("---------------------------------------------------------------------"); 
	out.println("TicTacToe is a widely known Tic Tac Toe game for Linux and Unix OS.");
	out.println("In this game, player can play against another player, compete against");
	out.println("a computer and finally to spectate a game computer vs computer.");
	out.println("If you dont know how to play Tic Tac Toe, see the follwoing link ");
	out.println("for more information http://www.cs.jhu.edu/~jorgev/cs106/ttt.pdf");
	out.println("---------------------------------------------------------------------"); 
	out.println(); 
    }

    //the tilte was generated using terminal: figlet TicTacToe
    public static void printWelcome(){
	out.println(" _____ _     _____         _____"); 
	out.println("|_   _(_) __|_   _|_ _  __|_   _|__   ___"); 
	out.println("  | | | |/ __|| |/ _` |/ __|| |/ _ \\ / _ \\"); 
	out.println("  | | | | (__ | | (_| | (__ | | (_) |  __/");
	out.println("  |_| |_|\\___||_|\\__,_|\\___||_|\\___/ \\___|");
	out.println("\n--------------------------------------------"); 
	out.println("\t\tVersion 0.1");
	out.println("--------------------------------------------"); 
    }

    public static void printMenu(){
	out.println("--------------------------------------------"); 
	out.println("\t\t MAIN MENU ");
	out.println("--------------------------------------------\n"); 
	out.println("[ Game mode ]");
	out.println("(1) Player vs Player ");
	out.println("(2) Player vs Computer ");
	out.println("(3) Computer vs Computer ");
	out.println();
	out.println("(0) Info");
	out.println("(4) Quit");
	out.println("\n");
    }

    public static void printResults(Player humanA, Player humanB, Player compA, Player compB){
	out.println("--------------------------------------------");
	out.println("\t\tResults");
	out.println("--------------------------------------------");
	if(humanA.getWins() > 0 || humanA.getDraw() > 0) out.println("    " + humanA.getUsername() + " won: " + humanA.getWins() + " and tied: " + humanA.getDraw() +" times"); 
	if(humanB.getWins() > 0 || humanB.getDraw() > 0) out.println("    " + humanB.getUsername() + " won: " + humanB.getWins() + " and tied: " + humanB.getDraw() +" times"); 
	if(compA.getWins() > 0 || compA.getDraw() > 0) out.println("    " + compA.getUsername() + " won: " + compA.getWins() + " and tied: " + compA.getDraw() +" times"); 
	if(compB.getWins() > 0 || compB.getDraw() > 0) out.println("    " + compB.getUsername() + " won: " + compB.getWins() + " and tied: " + compB.getDraw() +" times"); 
	out.println("--------------------------------------------\n");
    }

    public static String referenceBoardToString(){
	StringBuilder sb = new StringBuilder();
	sb.append("--------------------------------------------\n");
	sb.append("\t\tCoordinate map\n");
	sb.append("--------------------------------------------\n");
	sb.append("\t\t a1 | a2 | a3");
	sb.append("\n\t\t----+----+----\n");
	sb.append(" \t\t b1 | b2 | b3");
	sb.append("\n\t\t----+----+----\n");
	sb.append(" \t\t c1 | c2 | c3\n");
	sb.append("--------------------------------------------\n");
	return sb.toString(); 
    }

    public static String drawUpdatedBoard(String[][] board){
	StringBuilder sb = new StringBuilder(); 
	
	sb.append("  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\t\t|\t     " + " a1 | a2 | a3\n");
	sb.append("----+---+----" + "\t\t|\t     " + "----+----+----\n");
	sb.append("  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\t\t|\t     " + " b1 | b2 | b3\n");
	sb.append("----+---+----" + "\t\t|\t     " + "----+----+----\n");
	sb.append("  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\t\t|\t     " + " c1 | c2 | c3\n");
	
	return sb.append("\n").toString(); 
    }

    //-----Game logic starts here-----
    
    public static String[][] initialiazeTheBoard(String[][] board){
	for(int i = 0; i < 3; i++)
	    for(int j = 0; j < 3; j++)
		board[i][j] = " ";
	return board; 
    }

    //play the game...
    public static void play(Player player1, Player player2){
	Point point;
	boolean win = false;
	int finishGame = 0;
	String symbol = "X";
	Player player;
	String[][] board = new String [3][3];
	board = initialiazeTheBoard(board);
	while(!win){
	    if(finishGame % 2 != 0) { //player2 makes a move
		player = player2;
		symbol = "O";
	    }else { // player 1 makes a move
		symbol = "X";
		player = player1; 
	    }
	    
	    point = getApointFromThePlayer(player);
	    if(checkForInvalidMove(board, point)){
		point = makeAvalidMove(board, point, player); 
	    }
	    board = SetAsymbolOnTheBoard(board, point, symbol);
	    finishGame++; //player1 has made a move
	            
	    win = checkWins(board);
	    if(win){
		setVictoryForSpecificPlayer(player);
		return;
	    }
	        
	    // check if draw
	    if(checkDraw(finishGame, player1, player2)){
		return;
	    }      
	}
	}

    public static boolean checkForInvalidMove(String[][] board, Point point){
	if(board[point.getX()][point.getY()] != " "){
	    return true; 
	}
	return false;
	}

	public static Point makeAvalidMove(String[][] board, Point point, Player player){
	while(board[point.getX()][point.getY()] != " ") {
	    out.print("Invalid coordinate! Try again ");
	    out.println(); 
	    point = player.nextMove();
	}
	return point;
    }

    public static String[][] SetAsymbolOnTheBoard(String[][] board, Point point, String symbol){
	out.println();
	board[point.getX()][point.getY()] = symbol;
	out.print(drawUpdatedBoard(board));
	return board;
    }

    public static boolean checkDraw(int finishGame, Player player1, Player player2){
	if(finishGame >= boardSize){
	    out.println("--------------------------------------------"); 
	    out.println("\t\t~~~DRAW~~~");
	    out.println("--------------------------------------------");
	    out.println("\tWould you like to play again!?\n");
	    player1.setDraw(player1.getDraw() + 1);
	    player2.setDraw(player2.getDraw() + 1); 
	    return true;
	}
	return false;
	}

	public static Point getApointFromThePlayer(Player player){
	out.println(player.getUsername()+ "'s " + "time to play "); 
	return player.nextMove();
    }


    public static boolean checkWins(String[][] board){ 
	if(checkHorizontalforX(board) || checkHorizontalforO(board)|| checkVerticalforX(board) || checkVerticalforO(board)) return true;
	return false; 
    }

    private static boolean checkHorizontalforX(String[][] board){
	boolean h1 = true;
	boolean h2 = true;
	boolean h3 = true;
	
	for(int i = 0; i < 3; i++){
	    if(board[0][i] != "X") h1 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[1][i] != "X") h2 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[2][i] != "X") h3 = false; 
	}
	
	if(h1 || h2 || h3) return true;
	return false; 
    }

    private static boolean checkHorizontalforO(String[][] board){
	boolean h1 = true;
	boolean h2 = true;
	boolean h3 = true;
	
	for(int i = 0; i < 3; i++){
	    if(board[0][i] != "O") h1 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[1][i] != "O") h2 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[2][i] != "O") h3 = false; 
	}

    public static void setVictoryForSpecificPlayer(Player player){
	player.setWins(player.getWins() + 1);
	out.println("--------------------------------------------"); 
	out.println("\t\t~~~Victory~~~");
	out.println("--------------------------------------------"); 
	out.println("\t\t" + player.getUsername() + " won!");

	
	out.println("\tWould you like to play again!?\n");
	printMenu();
    }


    private static boolean checkVerticalforX(String[][] board){
	boolean v1 = true;
	boolean v2 = true;
	boolean v3 = true;
	
	for(int i = 0; i < 3; i++){
	    if(board[i][0] != "X") v1 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[i][1] != "X") v2 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[i][2] != "X") v3 = false; 
	}
	
	if(v1 || v2 || v3) return true;
	return false; 
    }
    
    private static boolean checkVerticalforO(String[][] board){
	boolean v1 = true;
	boolean v2 = true;
	boolean v3 = true;
	
	for(int i = 0; i < 3; i++){
	    if(board[i][0] != "O") v1 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[i][1] != "O") v2 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[i][2] != "O") v3 = false; 
	}
	
	if(v1 || v2 || v3) return true;
	return false; 
    }
}


}

