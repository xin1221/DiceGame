
/**
 * Interface defining methods required of every game.
 * 

 */
public interface Game {
	/**
	 *  Takes a single turn in the game. This method handles
	 *  invalid user input by looping until a valid turn has
	 *  been taken.
	 */
	public void takeTurn();
	
	/**
	 *  Prints the current game's status
	 */
	public void printGameStatus();
	
	/**
	 *  Get the game's winner. If there is
	 *  no winner yet, return null.
	 *  
	 *  @return the winner (if one exists) otherwise null
	 */
	public Player getWinner();
}