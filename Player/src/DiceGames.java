import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A game menu controller.
 * 

 */
public class DiceGames {
	/**
	 *  The option number for Game 1.
	 */
	public static final int GAME_1_OPTION = 1;
	
	/**
	 *  The option number for Game 2.
	 */
	public static final int GAME_2_OPTION = GAME_1_OPTION+1;

	/**
	 *  The option number for Global Thermonuclear War
	 */
	public static final int GTW_OPTION = GAME_2_OPTION+1;
	
	/**
	 *  The option to quit
	 */
	public static final int QUIT_OPTION = GTW_OPTION+1;
	
	/**
	 *  The menu prompt.
	 */
	public static final String MENU = "\n------------------\nShall we play a game?\n" +
		"\t["+GAME_1_OPTION+"] Roll Equal Dice (Single Player)\n"+
		"\t["+GAME_2_OPTION+"] Sum Dice (Two Player)\n"+
		"\t["+GTW_OPTION+"] Global Thermonuclear War\n"+
		"Enter "+QUIT_OPTION+" to quit.\n"+
		"------------------\nWhat game would you like to play? ";
	
	/**
	 *  A scanner to get user input from in the various functions
	 */
	private static Scanner in = new Scanner(System.in);
	
	/**
	 *  main method to prompt the user for their menu choice.
	 *  
	 *  @param args unused command line arguments
	 */
	public static void main(String[] args) {
		int choice = getChoice();
		while(choice != QUIT_OPTION) {
			switch(choice) {
				case GAME_1_OPTION:
					playGame1();
					break;
				case GAME_2_OPTION:
					playGame2();
					break;
				case GTW_OPTION:
					System.out.println("\nThe only winning move is not to play.");
					break;
				default:
					System.out.println("\nInvalid option, please select one of the games available.");
					break;
			}
			System.out.println("Hit enter to continue.");
			in.nextLine();
			choice = getChoice();
		}
	}
	
	/**
	 *  Get's the user's menu choice.
	 *  
	 *  @return the user's choice or -1 on error.
	 */
	public static int getChoice() {
		System.out.print(MENU);
		try {
			int choice = in.nextInt();
			return choice;
		}
		catch(InputMismatchException e) {
			return -1;
		}
		finally {
			//clear out after nextInt()
			in.nextLine();
		}
	}
	
	/**
	 *  Logic for setting up and running Game 1.
	 */
	public static void playGame1() {
		System.out.print("\nWhat is your name? ");
		String name = in.nextLine();
		Game g = new Game1(name);
		
		Player winner = g.getWinner();
		while(winner == null) {
			g.printGameStatus();
			g.takeTurn();
			winner = g.getWinner();
		}
		
		g.printGameStatus();
		System.out.println("Winner is: " + winner.getName());
	}
	
	/**
	 *  Logic for setting up and running Game 2.
	 */
	public static void playGame2() {
		System.out.print("\nWhat is Player 1's name? ");
		String name1 = in.nextLine();
		
		System.out.print("\nWhat is Player 2's name? ");
		String name2 = in.nextLine();
		
		Game g = new Game2(new String[] {name1, name2});
		
		Player winner = g.getWinner();
		while(winner == null) {
			g.printGameStatus();
			g.takeTurn();
			winner = g.getWinner();
		}
		
		g.printGameStatus();
		System.out.println("Winner is: " + winner.getName());
	}
}