/*
Assignment #7
Dice Roller Game 2.0
Andrew Napier
*/
package assignment7;

public class Main {                                                             //beginning of Main class

    static final Validator VLD = new Validator();                               //Validator object replaces Scanner but verifies input 
    static final String SIDES = "How many sides should the ";                   //declares some Strings that are re-used as constants
    static final String TIMES = "How many times would you like to roll?\n>>>";  
    static final String ROLL_EQUALS = "You rolled a(n): ";
    static final String CONTINUE = "Would you like to play again? ( Y/N )";

    
    public static void main (String [] Args){                                   //beginning of main method
        System.out.println( "Welcome to the Dice Roller Game 2.0\n" );          //welcome message
        
        Menu mainMenu = new Menu();                                             //creates main menu with options for 
        mainMenu.attach("Enter \"1\" for single roll");                         //single roll game from assignment 6
        mainMenu.attach("Enter \"2\" for series roll");                         //roll as many times as you'd like at once
        mainMenu.attach("Enter \"3\" to exit");                                 //to end program

        Menu subMenu = new Menu("Would you like to roll 1 die or 2?\n");        //creates sub menu to ask user to select 
        subMenu.attach("Enter \"1\" for single die");                           //to play with 1 die
        subMenu.attach("Enter \"2\" for a pair of dice");                       //to play with a pair of dice
        subMenu.attach("Enter \"3\" to return to main menu");                   //return to main menu
        
        Boolean replay = true;                                                  //creates boolean variable to track user choice to keep replaying
        
        while(replay == true){                                                  //exits game when replay is set to false
            int choice = mainMenu.getUserChoice();                              //prints main menu and gets validated input
            switch (choice){                                                    //switch to determine single or series roll
                case 1:                                                         //1 for single roll
                int subChoiceA = subMenu.getUserChoice();                       //prints sub menu and gets validated input
                switch (subChoiceA){                                            //switch to determine single die or dice pair
                    case 1:                                                     //1 for single die
                        int sides = VLD.getInt( SIDES + "die have?"             //asks user for number of sides and validates inpt with min = 0
                                                      + "\n>>> ", 0 );
                        Die single = new Die(sides);                            //creates new Die object scaled to user input
                        int roll = single.roll();                               //impliments the roll method of the Die class
                        System.out.println( ROLL_EQUALS + roll );               //displays total
                        replay = VLD.yesOrNo( CONTINUE );                       //asks user if they'd like to keep playing and validates input
                        continue;
                    case 2:                                                     //2 for pair of dice
                        int sides1 = VLD.getInt( SIDES + "first die have?"      //asks user for number of sides for die1 and validates inpt with min = 0
                                                       + "\n>>> ", 0 );
                        int sides2 = VLD.getInt( SIDES + "second die have?"     //asks user for number of sides for die2 and validates inpt with min = 0
                                                       + "\n>>> ", 0 );
                        Dice pairOfDice = new Dice(sides1, sides2);             //creates new Dice object scaled to user input
                        pairOfDice.roll();                                      //impliments the roll method of the Dice class
                        String diceRoll = pairOfDice.combo();
                        System.out.println( ROLL_EQUALS + diceRoll );           //display total and possibly a prompt depending on the result
                        replay = VLD.yesOrNo( CONTINUE );                       //uses yesOrNo method to determine value of replay     
                        continue;  
                    default: continue;
                }                                                               //end of case 1 for single roll
                case 2:                                                         //2 for series roll
                int subChoiceB = subMenu.getUserChoice();                       //prints sub menu and gets validated input 
                switch (subChoiceB) {                                           //switch to determine single die or dice pair
                    case 1:                                                     //1 for single die
                        int sides = VLD.getInt( SIDES + "die have?"             //asks user for number of sides and validates inpt with min = 0
                                                      + "\n>>> ", 0 ); 
                        Die single = new Die(sides);                            //create new Die object scaled to user input
                        int rolls = VLD.getInt( TIMES, 0 );                     //asks how many times user wants to roll and gets valid input
                        DiceRoller singleDie = new DiceRoller (single, rolls);  //creates a new DiceRoller object for a single die and a given number of rolls
                        singleDie.roll(single);                                 //rolls the die the specific amount of times method requires a die or dice as a parameter
                        singleDie.printStats();                                 //prints the outcomes of the rolls
                        replay = VLD.yesOrNo( CONTINUE );                       //uses yesOrNo method to determine value of replay
                        continue;
                    case 2:
                        int sides1 = VLD.getInt( SIDES + "first die have?"      //asks user for number of sides for die1 and validates inpt with min = 0
                                                       + "\n>>> ", 0 );
                        int sides2 = VLD.getInt( SIDES + "second die have?"     //asks user for number of sides for die2 and validates inpt with min = 0
                                                       + "\n>>> ", 0 );
                        Dice pair = new Dice(sides1, sides2);                   //creates new Dice object scaled to user input
                        int diceRolls = VLD.getInt( TIMES, 0 );                 //asks how many times user wants to roll and gets valid input
                        DiceRoller dicePair = new DiceRoller( pair, diceRolls); //creates new DiceRoller object for a pair of dice and a given number of rolls
                        dicePair.roll(pair);                                    //rolls the die the specific amount of times method requires a die or dice as a parameter
                        dicePair.printStats();                                  //prints the outcomes of the rolls
                        replay = VLD.yesOrNo( CONTINUE );                       //uses yesOrNO method to determine value of replay
                        continue;
                    default: continue;
                }                                                               //end of case 2 for series roll
                case 3:                                                         //when 3 is entered from the main menu
                replay = false;                                                 //sets replay to false and exits program
            }
        }                                                                       //end of loop/game
        System.out.println( "Thank you for playing!" );                         //prints thank you message
    }
}