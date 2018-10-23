import java.util.Scanner;

public class Game2 implements Game {
	/*
		Game 2 requires:
		- 2 players
		- 5 dice per person which:
			- start at 1
			- have the following side counts, in this order: 4,8,12,16,20
	*/
	
	/**
	 *  Constructor to setup a game. Configures instance
	 *  variables and welcomes the user to the game.
	 *  
	 *  @param playerNames the player's names in order
	 */
	
	//create two player
	private String[] names;
	private String PlayerNames;
    private int[] sides = {4,8,12,16,20};
    //private static int s1,s2,s3,s4,s5;
    private String playerOneInput;
    private String playerTwoInput;
    private Player playerOne;
    private Player playerTwo; 
    private static int [] die = new int [5];
    private int sumOne=-1;
    private int sumTwo=-1;
    //private String faceSides;
    private boolean winning = false;
    private int numOfDice = 5;
    private boolean gaming = false;
	private int side;
	private int[] DieOne;
	private int[] DieTwo;
	private String[] inputOne;
	private String[] inputTwo;
  
    public Game2(String[] playerNames) {
		/*
			1. Setup instance variables.
			2. Give instructions to the user:
				Welcome to Game 2!
				You each have five dice with the following sides: 4, 8, 12, 16, and 20 (in that order). You may choose to reroll your dice once. The player with the highest sum will win. Your current dice values are shown below:
		*/    
     this.names = playerNames; 
     this.numOfDice = 5;
     System.out.println("Welcome to Game 2!");
     System.out.println("You each have five dice with following sides: 4, 8, 12, 16, and 20 (in that order). Yon may choose to reroll your dice once.  The player with the highest sum will win.Your current dice values are shown below:");
     this.gaming = false;
     playerOne = new Player(playerNames[0], sides, gaming);
     playerTwo = new Player(playerNames[1], sides, gaming);      
    }
	
	/**
	 *  Takes a single turn in the game. This method handles
	 *  invalid user input by looping until a valid turn has
	 *  been taken.
	 */
	public void takeTurn() {
		/**
			For each user:
			1. Get user input:
				[Player1Name], which dice would you like to reroll? Enter five integers separated by spaces. If you enter a 0, the corresponding die will not be rerolled. If you enter any other number, the die be rerolled.
			2. Get list of 5 integers from the user (all on one line, separated by spaces). If the user enters invalid input:
				You must enter five integers. Please try again.
			3. Reroll each die the user requested (0 = keep die, non-0 = reroll die).
		*/		
		System.out.println(playerOne + " which dice would you like to reroll? Enter five integers separated by spaces. If you enter a 0, the corresponding die will not be rerolled. If you enter any other number, the die be rerolled.");
		Scanner in = new Scanner(System.in);
		playerOneInput = in.nextLine();
		inputOne  = playerOneInput.split(" ");
		while (inputOne.length!=5) {
			System.out.println("You must enter five integers. Please try again. ");
			playerOneInput = in.nextLine();
			inputOne  = playerOneInput.split(" ");
			}
		for (int i = 0; i<5;i++) {			
			if( inputOne[i].equals("1") ) {
				playerOne.rollDie(i);			
				}
			}
		System.out.println(playerTwo + "which dice would you like to reroll? Enter five integers separated by spaces. If you enter a 0, the corresponding die will not be rerolled. If you enter any other number, the die be rerolled.");
	     playerTwoInput = in.nextLine();
			inputTwo = playerTwoInput.split(" ");
	
			while (inputTwo.length!=5) {
				System.out.println("You must enter five integers. Please try again. ");
				playerTwoInput = in.nextLine();
				inputTwo = playerTwoInput.split(" ");
			}
			for (int i = 0; i<5;i++) {
				if(inputTwo[i] .equals("1") ) {
					playerTwo.rollDie(i);			
					}
			}
	}
	/**
	 *  Prints the current game's status
	 */
	public void printGameStatus() {
		/*
			Print the player and their current score, e.g. from the sample run:
				Fred: [3,2,2,2,5,3,2,5,5,1], Sum: 30
				Allan: [5,6,4,4,1,4,4,2,2,3], Sum: 35
			Hint: user the player's toString() method to convert a player to a strings:
				Fred: [3,2,2,2,5,3,2,5,5,1]
				Allan: [5,6,4,4,1,4,4,2,2,3]
			*/
		this.DieOne = playerOne.getDiceValues();
	     for (int i = 0; i < DieOne.length; i++) {
	    	 this.sumOne = DieOne[0]+DieOne[1]+DieOne[2]+DieOne[3]+DieOne[4]; 
	     }	    
	    this. DieTwo = playerTwo.getDiceValues();
	     for (int i = 0; i < DieTwo.length; i++) {
	    	 this.sumTwo = DieTwo[0]+DieTwo[1]+DieTwo[2]+DieTwo[3]+DieTwo[4];	 
	     }
		System.out.println(playerOne.toString()+", Sum: "+ this.sumOne);
		System.out.println(playerTwo.toString()+", Sum: "+ this.sumTwo);
	}
	
	/**
	 *  Get the game's winner. If there is
	 *  no winner yet, return null.
	 *  
	 *  @return the winner (if one exists) otherwise null
	 */
	public Player getWinner() {
		/*
		If the players have not rerolled (i.e. they have not taken a turn), return null.
		If the players have rerolled their dice, return the player with the highest sum.
		In the case of ties, return the first player.
		*/
		if(sumOne == -1 && sumTwo ==-1) {
			return null;	
			}
		else if(this.sumOne>=this.sumTwo) {
			return this.playerOne;	
			}	
		else{
			return this.playerTwo;	
			}
	}
	
}
		
	
