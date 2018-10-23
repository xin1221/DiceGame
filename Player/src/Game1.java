import java.util.Scanner;

/**
 *  Class that plays a game where a single player has
 *  ten six-sided dice and continually rerolls
 *  them until all dice show the same face value.
 *  The player starts with 10 points and loses one
 *  point for every reroll. The score can become
 *  negative.
 *  

 */
public class Game1 implements Game {
	/*
		Game 1 requires:
		- 1 player
		- 10 six sided dice (values 1->6)
		- a player score
	*/
	
	/**
	 *  Constructor to setup a game. Configures instance
	 *  variables and welcomes the user to the game.
	 *  
	 *  @param playerName the player's name
	 */
    private String Name;
    private int numOfDice;
    private int side;
    private int[] sides;
    private String playerInput;
    private boolean winning;
    //private int chose;
    private String faceSides;
    private int[] faceValue;
    private int score;
    private boolean gaming;
    private Player Player;
	private int input;

    
	public Game1(String playerName) {
		/*
			1. Setup instance variables.
			2. Give instructions to the user:
				Welcome to Game 1!
				You have ten dice. Each turn, you may choose to keep all dice showing some value. You win when all ten dice show the same value.
		*/
    this.numOfDice = 10;
    this.side = 6;
    this.score = 10;
    System.out.print("Welcome to Game 1!");
    System.out.println("You have ten dice. Each turn, you may choose to keep all dice showing some value.");
    System.out.println("You win when all ten dice show the same value.");
	this.Name = playerName;
    this.gaming = false;
    this.sides = new int [this.numOfDice];
    for (int i = 0; i<this.numOfDice; i++){
    this.sides[i] = this.side;
    
    }
    Player = new Player(Name, sides, gaming);
    
    System.out.print(Player.toString()+", Score: "+ this.score);

	takeTurn();
			
	}
	/**
	 *  Takes a single turn in the game. This method handles
	 *  invalid user input by looping until a valid turn has
	 *  been taken.
	 */
    
    public void takeTurn() {
		/**
			1. Get user input:
				What number would you like to keep? 
			2. If the user enters an invalid number:
				You must choose a valid number.
			3. Reroll all player's dice not equal to the value they wish to keep.
			4. Adjust the score.
		*/
    
     
      System.out.println("\nWhat number would like to keep.");
      Scanner in = new Scanner(System.in);
      this.playerInput = in.nextLine();
      winning =  (playerInput.equals("1")|| playerInput.equals("2")||playerInput.equals("3")
    		  ||playerInput.equals("4")||playerInput.equals("5")||playerInput.equals("6")); 
      while(!winning) {
    	  System.out.println("You must choose a vaild number");
    	  this.playerInput = in.nextLine();
    	 winning = (playerInput.equals("1")|| playerInput.equals("2")||playerInput.equals("3")
        		  ||playerInput.equals("4")||playerInput.equals("5")||playerInput.equals("6"));
      }  		
      this.input = Integer.parseInt(this.playerInput);
	  	for (int i = 0; i< this.numOfDice;i++) {
			  		if(Player.getDie(i).getCurrentFace() != this.input) {
			Player.rollDie(i);
          
      }  
		}
     
      this.score = this.score -1;
    }
            
      
	/**
	 *  Prints the current game's status
	 */
	public void printGameStatus() {

			/**Print the player and their current score, e.g. from the sample run:
				Raven: [6,5,4,6,5,1,3,6,4,1], Score: 10
			Hint: user the player's toString() method to convert a player to a string:
				Raven: [6,5,4,6,5,1,3,6,4,1]
		*/

      System.out.print(Player.toString()+", Score: "+ this.score);
	}
	
	/**
	 *  Get the game's winner. If there is
	 *  no winner yet, return null.
	 *  
	 *  @return the winner (if one exists) otherwise null
	 */
	public Player getWinner() {
		/*
			If all the dice a player has are equal, return the player.
			If the player has not gotten all their dice equal, return null.
		*/
 
		
      /*this.faceSides = a.toString();
      this.faceValue = a.getDiceValues();*/
		
      for (int i = 0; i < this.numOfDice; i++) {
      
            if(this.Player.getDie(i).getCurrentFace() != this.input) {
            
		      return null;
		      
		      }
            
	}
   
   
  
   return this.Player;
   }
}