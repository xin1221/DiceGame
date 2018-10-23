import java.util.Random;

/**
 *  Class representing a single die, the number
 *  of sides it has, the current face (value
 *  showing on the die), and whether the die
 *  starts at zero or one.
 *  

 */
public class Die {


		/**
		 *  Constructor for a single die. Die start showing
		 *  a random "face" (i.e. a random surface).
		 *  
		 *  @param numSides the number of sides this die has
		 *  @param startsAtZero whether or not this die starts at zero (alternative is 1)
		 */
	  private int numSides;
	  private boolean startsAtZero;
	  private int roll;
	  Random d = new Random();

	  
		public Die(int numSides, boolean startsAtZero) {
			 this.numSides = numSides;
	         this.startsAtZero = startsAtZero;
	         roll();
	  	}
		
		
			// TODO Auto-generated constructor stub
		


		public int getNumSides() 
	   {
			return this.numSides;
		}
		
		/**
		 *  Gets whether this die starts at zero or not.
		 *  
		 *  @return whether this die starts at zero
		 */
		public boolean getStartsAtZero() {
			return this.startsAtZero;
		}
		
		/**
		 *  Gets the current value of the die's face.
		 *  
		 *  @return whether this die starts at zero
		 */
		public int getCurrentFace() {
	   
	      return this.roll;
		}
		
		/**
		 *  Rolls the die allowing it to show a new random "face".
		 * @param  
		 */
		public void roll() 
	   {
	     
	      if(this.startsAtZero == true) {
				this.roll = d.nextInt(this.numSides);
			}
			else {
				this.roll = d. nextInt(this.numSides)+1;   
			}	

	       }
			
	}


