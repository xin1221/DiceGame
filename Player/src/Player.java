public class Player {
	/**
	 *  Constructor that makes a new player with a name and
	 *  some dice that all start at either 0 or 1, but may
	 *  each have a different number of sides.
	 *  
	 *  @param name the player's name
	 *  @param sides an array containing a list of each die's number of sides
	 *  @param startsAtZero whether or not the player's dice start at 0, all dice the player have start at the same value
	 */
   private String name;
   private int NumDice;
   private int[] sides;
   private int[]DiceValues;
   private int[] Numfaces;
   private boolean startsAtZero;
   private String printOut;
   private Die[] die;		
   
   public  Player(String name, int[] sides, boolean startsAtZero) {
	   this.name = name;
	   this.sides = sides; 
	   this.startsAtZero = startsAtZero;
	   this.NumDice = this.sides.length;
	   //die = new Die[this.NumDice];
	   this.Numfaces = new int[this.NumDice];
	   this.die = new Die [this.NumDice];
	   for(int i=0;i < sides.length;i++){
		   this.die[i] = new Die(this.sides[i], startsAtZero);
		   }
   }
	
	/**
	 *  Returns the player's name.
	 *  
	 *  @return the player's name
	 */
	public String getName() {
      
		return this.name;
	}
	
	/**
	 *  Returns the number of dice the player has.
	 *  
	 *  @return the number of dice the player has
	 */
	public int getNumDice() {
		return this.NumDice;
	}
	
	/**
	 *  Returns the current face value of each die (in order).
	 *  
	 *  @return an array of dice face values in order
	 */
	public int[] getDiceValues() {
	      this.DiceValues = new int [this.NumDice];

      for (int i = 0; i <this.NumDice; i++)
      {
         this.DiceValues[i] = this.die[i].getCurrentFace();
          
       }
      return DiceValues;
	}
	
	/**
	 *  Returns the number of sides of each die (in order)
	 *  that the player has. This should be the same as
	 *  sides in {@link Player#Player(String,int[],boolean)}.
	 *  
	 *  @return an array of dice face values in order
	 */
	public int[] getDiceNumSides() {
		return sides;
	}
	
	/**
	 *  Get a single die from the player.
	 *  
	 *  @param i the index of the die in the player's set of die
	 *  @return the die in that location
	 */
	public Die getDie(int i) {
      return die[i] ;
	}
   
   

	/**
	 *  Rolls all the player's dice.
	 */
	public void rollDice() {
      //this.DiceValues = new int [this.NumDice];
            for (int i = 0; i <this.NumDice; i++)
               {
                   die[i].roll();
                }
        }  
                 
            
   
   
  
  
	
	/**
	 *  Rolls a single die at the index specified
	 *  by the user.
	 *  
	 *  @param i index of the die to roll
	 * @param  
	 */
	public void rollDie(int i) {
   
		die[i].roll();   

		
	}
	
	/**
	 *  Rolls all the dice a player has which do not
	 *  currently have a face value specified.
	 *  
	 *  @param value the face value of dice not to reroll
	 */
	public void rollKeepValue(int value) {
     
		for(int i=0;i<this.NumDice;i++) {
			if(this.die[i].getCurrentFace() != value) {
				rollDie(i);
			}
		}
		
	}
		
	/**
	 *  <p>Prints the current player as a string in the format:</p>
	 *  <pre>PlayerName: [#,#,#,#,#]</pre>
	 *  <p>Where PlayerName is the player's name and [#,#,#,#,#]
	 *  represents the face value of the player's dice, in order.
	 *  For example, a player named "Rebecca" with four six-sided
	 *  dice might print as:</p>
	 *  <pre>Rebecca: [1,3,2,3]</pre>
	 *  <p>if her dice show 1, 3, 2, and 3 respectively.</p>
	 */
	public String toString() {
     this.printOut = this.name +": " + "[";
     for(int i =0; i<this.NumDice; i++) {
    	 this.printOut += this.getDiceValues() [i];
       int j = i+1;
       if (j < this.NumDice){
       this.printOut += ",";
       
       }
     }
       //string s = "<pre>"+this.name+":"+ "this.Numfaces".
       this.printOut += "]";
       return this.printOut;
     }
     
      
     
   
   
	}

