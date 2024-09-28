package assignment7;

public final class Die {                                                        //beginnning of class Die for an individual die
   
    private final int numberOfSides;                                            //data attributes each die has a number of sides
    private int faceValue;                                                      //and a faceValue
    
    public Die(){                                                               //default constructor
        numberOfSides = 6;                                                      //the most standard die has 6 sides
        faceValue = this.roll();                                                //roll the die immediately and assign it a faceValue
    }
    
    public Die(int sides){                                                      //constuctor that takes an int as a parameter
        numberOfSides = sides;                                                  //to determine numberOfSides
        faceValue = this.roll();                                                //roll the die immediately and assign it a faceValue
    }
    
    public int roll ( ){                                                        //public mehtod roll takes no paramaters returns a new faceValue
        faceValue = 1 + (int) ( Math.random() * numberOfSides );                //produces a random number between 1 and the numberOfSides of the Die
        return faceValue;                                                       //returns the integer value of the roll as the faceValue
    }                                                                           //end of mehtod roll    

    public int getSides( ){                                                     //public method to get the number of sides of that particular Die
        return numberOfSides;                                                   
    }
}                                                                               //end of class Die