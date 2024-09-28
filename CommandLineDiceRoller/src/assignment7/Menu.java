package assignment7;

public class Menu {                                                             //beginning of class Menu

    private final Validator vld;                                                //each menu has a validator for get user response
    private String options;                                                     //a string containting the options
    private int idx;                                                            //and an int to use as an index to keep track of number of Options

    public Menu( ){                                                             //default constructor   
        options = "\n";                                                         //add a blank line to options    
        vld = new Validator( );                                                 //declare a new Validator object
        idx = 1;                                                                //and set the index to 1 so it's actually 1 more than all the items we attatch
    }
    public Menu( String prompt ){                                               //constructor with prompt
        options = prompt + "\n";                                                //adds given prompt before the new line
        vld = new Validator( );
        idx = 1;
    }

    public void attach( String choice ){                                        //method to add a new option to the menu
        options += choice + "\n";                                               //adds the choice given to options String
        idx += 1;                                                               //adds 1 to the index to account for additional option
    }

    public int getUserChoice( ){                                                //method to let the user choose an option
        int choice = vld.getInt( options + "\n>>> ", 0, idx );                  //uses the validator to get back only an integer 
        return choice;                                                          //greater than 0 and less than the index
    }
}                                                                               //end of class Menu
