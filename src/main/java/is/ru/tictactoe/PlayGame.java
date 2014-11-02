package is.ru.tictactoe;
import java.util.Scanner;
import java.util.Arrays;


public class PlayGame {

    private final static int boardSize = 9;
    private static Scanner scanner = new Scanner(System.in);


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
		System.out.print(referenceBoardToString());
	    if(choice.equals("0"))
		printInfo();
	            
	    //set the game mode
	    else if(choice.equals("1")){
		if(tmp == 1){
		    tmp++;
		    System.out.print("Player 2 Username: "); username = scanner.next();
		    System.out.println();
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
	System.out.println();
	System.out.print("Username: "); username = scanner.next();
	System.out.println();
	human_A.setUsername(username);
	return username; 
    }

    public static String selectGame(){
	System.out.print("Your choice: "); String choice = scanner.next();
	System.out.println();

	if(!Arrays.asList("1", "2", "3", "4",  "0").contains(choice)){
	    while(!Arrays.asList("1", "2", "3", "4", "0").contains(choice)){
		System.out.println("Illegal choice, please try again.");
		System.out.print("Your choice: "); choice = scanner.next();
		System.out.println();
	    }
	}
	return choice;
    }
    
    //printing functions
    public static void printInfo(){
	System.out.println("---------------------------------------------------------------------"); 
	System.out.println("\t\t\tProduction of AMAROK");
	System.out.println("---------------------------------------------------------------------"); 
	System.out.println("TicTacToe is a widely known Tic Tac Toe game for Linux and Unix OS.");
	System.out.println("In this game, player can play against another player, compete against");
	System.out.println("a computer and finally to spectate a game computer vs computer.");
	System.out.println("If you dont know how to play Tic Tac Toe, see the follwoing link ");
	System.out.println("for more information http://www.cs.jhu.edu/~jorgev/cs106/ttt.pdf");
System.out.println("---------------------------------------------------------------------"); 
System.out.println(); 
    }

    //the tilte was generated using terminal: figlet TicTacToe
    public static void printWelcome(){
System.out.println(" _____ _     _____         _____"); 
System.out.println("|_   _(_) __|_   _|_ _  __|_   _|__   ___"); 
System.out.println("  | | | |/ __|| |/ _` |/ __|| |/ _ \\ / _ \\"); 
System.out.println("  | | | | (__ | | (_| | (__ | | (_) |  __/");
System.out.println("  |_| |_|\\___||_|\\__,_|\\___||_|\\___/ \\___|");
System.out.println("\n--------------------------------------------"); 
System.out.println("\t\tVersion 0.1");
System.out.println("--------------------------------------------"); 
    }

    public static void printMenu(){
System.out.println("--------------------------------------------"); 
System.out.println("\t\t MAIN MENU ");
System.out.println("--------------------------------------------\n"); 
System.out.println("[ Game mode ]");
System.out.println("(1) Player vs Player ");
System.out.println("(2) Player vs Computer ");
System.out.println("(3) Computer vs Computer ");
System.out.println();
System.out.println("(0) Info");
System.out.println("(4) Quit");
System.out.println("\n");
    }

    public static void printResults(Player humanA, Player humanB, Player compA, Player compB){
System.out.println("--------------------------------------------");
System.out.println("\t\tResults");
System.out.println("--------------------------------------------");
if(humanA.getWins() > 0 || humanA.getDraw() > 0 || humanA.getLost() > 0) System.out.println("    " + humanA.getUsername() + " won: " + humanA.getWins() + " loss: " + humanA.getLost() + " and tied: " + humanA.getDraw() +" times"); 
if(humanB.getWins() > 0 || humanB.getDraw() > 0 || humanB.getLost() > 0) System.out.println("    " + humanB.getUsername() + " won: " + humanB.getWins() + " loss: " + humanB.getLost() + " and tied: " + humanB.getDraw() +" times"); 
if(compA.getWins() > 0 || compA.getDraw() > 0 || compA.getLost() > 0) System.out.println("    " + compA.getUsername() + " won: " + compA.getWins() + " loss: " + compA.getLost() + " and tied: " + compA.getDraw() +" times"); 
if(compB.getWins() > 0 || compB.getDraw() > 0|| compB.getLost() > 0) System.out.println("    " + compB.getUsername() + " won: " + compB.getWins() + " loss: " + compB.getLost() + " and tied: " + compB.getDraw() +" times"); 
System.out.println("--------------------------------------------\n");
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
Player player, loser;
String[][] board = new String [3][3];
board = initialiazeTheBoard(board);
while(!win){
    if(finishGame % 2 != 0) { //player2 makes a move
player = player2;
loser = player1;
symbol = "O";
    }else { // player 1 makes a move
symbol = "X";
player = player1;
loser = player2; 
    }
    
    point = getApointFromThePlayer(player);
    if(checkForInvalidMove(board, point)){
point = makeAvalidMove(board, point, player); 
    }
    board = SetAsymbolOnTheBoard(board, point, symbol);
    finishGame++; //player1 has made a move
            
    win = checkWins(board);
    if(win){
setVictoryForSpecificPlayer(player, player2);
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
    System.out.print("Invalid coordinate! Try again ");
    System.out.println(); 
    point = player.nextMove();
}
return point;
    }

    public static String[][] SetAsymbolOnTheBoard(String[][] board, Point point, String symbol){
System.out.println();
board[point.getX()][point.getY()] = symbol;
System.out.print(drawUpdatedBoard(board));
return board;
    }

    public static boolean checkDraw(int finishGame, Player player1, Player player2){
if(finishGame >= boardSize){
    System.out.println("--------------------------------------------"); 
    System.out.println("\t\t~~~DRAW~~~");
    System.out.println("--------------------------------------------");
    System.out.println("\tWould you like to play again!?\n");
    player1.setDraw(player1.getDraw() + 1);
    player2.setDraw(player2.getDraw() + 1);
    printMenu();
    return true;
}
return false;
}

public static Point getApointFromThePlayer(Player player){
    System.out.println(player.getUsername()+ "'s " + "time to play "); 
    return player.nextMove();
}


    public static boolean checkWins(String[][] board){ 
	if(checkHorizontalforX(board) || checkHorizontalforO(board)|| checkVerticalforX(board) || checkVerticalforO(board) || checkDiagonal(board)|| checkInvDiagonal(board)) return true;
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
	if(h1 || h2 || h3) return true;
	return false; 
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
 
    private static boolean checkDiagonal(String[][] board){
	if(board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") return true; 
	else if(board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") return true; 
	return false;
    }

    private static boolean checkInvDiagonal(String[][] board){
	if(board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") return true; 
	else if(board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O") return true; 
	return false;
    }

    public static void setVictoryForSpecificPlayer(Player player, Player loser){
	player.setWins(player.getWins() + 1);
	loser.setLost(loser.getLost() + 1);
	System.out.println("--------------------------------------------"); 
	System.out.println("\t\t~~~Victory~~~");
	System.out.println("--------------------------------------------"); 
	System.out.println("\t\t" + player.getUsername() + " won!");

	
	System.out.println("\tWould you like to play again!?\n");
	printMenu();
    }

}
