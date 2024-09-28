package assignment7;

public class Dice {                                                             //beginning of class Dice for how a pair of dice works
    
    private final Die die1;                                                     //each pair of dice has two Die objects
    private final Die die2;                                                     
    private int rollSum;                                                        //and an integer value that is the sum of its faceValues
    
    public Dice (){                                                             //default constructor
        die1 = new Die();                                                       //creates two default die objects 
        die2 = new Die();                                                       
        rollSum = this.roll();                                                  //rolls the dice to configure a sum 
    }
    
    public Dice(int sides1){                                                    //constructor that takes only one integer as a parameter
        die1 = new Die(sides1);                                                 //sets both die objects to the same number of sides as given by parameter
        die2 = new Die(sides1);                                                 
        rollSum = this.roll();                                                  //rolls the dice to confiugre a sum
    }
    
    public Dice (int sides1, int sides2){                                       //constructor for Dice class takes two integers as parameters
        die1 = new Die (sides1);                                                //sets each die object to the number of sides given in each parameter
        die2 = new Die (sides2);                                                
       rollSum = this.roll();                                                   //rolls the dice to confiugure a sum
    }
    
    public int roll ( ){                                                        //public method roll takes no parameters returns int
        rollSum = die1.roll() + die2.roll();                                    //rolls each die and adds the values
        return rollSum;                                                         //returns the sum
    }   
    
    public int maxCombo ( ){                                                    //public method maxCombo
        int max = die1.getSides( ) + die2.getSides( );                          //get the number of sides assigned to each die and adds them 
        return max;                                                             //returns the sum
    }
    
    public String combo ( ){
        switch ( rollSum ){                                                     //switch based on the sum rollSum
            case 2:                                                             //if total is 2
                return ( rollSum + " Snake eyes!\n" );                          //returns string containing the value and "Snake eyes!" and new line
            case 7:                                                             //if total is 7
                return ( rollSum +  " Craps!\n" );                              //returns string containing the value and "Craps!" and new line
            case 12:                                                            //if total is 12
                return ( rollSum + " Box cars!\n" );                            //returns string containing the value and "Box cars!" and new line             
            default:                                                            //if any other total
                return ( rollSum + "");                                         //returns string containing the value
        }                                                                        
    }
}                                                                               //end of class Dice