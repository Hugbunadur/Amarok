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
	//HumanPlayer human_A = new HumanPlayer();
	//HumanPlayer human_B = new HumanPlayer();
	//ComputerPlayer comp_A = new ComputerPlayer();
	//ComputerPlayer comp_B = new ComputerPlayer();

	printWelcome();
	printMenu();

	String choice;
	int tmp = 1;
	do{           
	    choice = selectGame();
	    if(choice.equals("1")|| choice.equals("2") ||choice.equals("3")){
		//out.print(referenceBoardToString());
	    }

	    if(choice.equals("0")) {
		//printInfo();
	    }
	            
	    //set the game mode
	    else if(choice.equals("1")){
		//play(human_A, human_B);
	    }
	            
	    else if(choice.equals("2")){
		//play(human_A, comp_A);
	    }
	    else if(choice.equals("3")){
		//play(comp_A, comp_B);
	    }
 
	    else if(choice.equals("4")){
		break;
	    }
	            
	}while(choice.equals("1")|| choice.equals("2") ||choice.equals("3") || choice.equals("0")); 
	
	//TODO: print results

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

}
