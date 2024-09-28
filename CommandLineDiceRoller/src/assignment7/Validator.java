    package assignment7;

import java.util.Scanner;

public class Validator                                                          //beginning of Validator class for getting verified acceptabele responses
{
    private final Scanner sc;                                                   //each validator has a Scanner for reading user input
    
    public Validator(){                                                         //default and only constructor
        sc = new Scanner (System.in);                                           //creates a new Scanner for keyboard input
    }
    
    public boolean yesOrNo ( String prompt ){                                   //public method yesOrNo returns a bool takes a String prompt (yes or no quesiton) as a parameter
        for(;;){                                                                //forever loop to guarantee a return
                                                                            
            System.out.print(prompt);                                           //print the prompt
            String response = sc.next();                                        //take users response
            if (response.equalsIgnoreCase("y")) {                               //if its "Y" or "y" aka yes
                return true;                                                    //return true and exit the loop
            }                                                               
            else if(response.equalsIgnoreCase("n")){                            //if its "N" or "n" aka no
                return false;                                                   //return false and exit the loop
            }
            else {                                                              //any other entry will not be accepted
                sc.nextLine();                                                  //discard any data entered on the line
                System.out.println( "Error! Please enter Y or N" );             //error message will display and loop will continue
            }
        }
    }                                                                           //end of method yesOrNo
    
    public int getInt  ( String prompt){                                        //public mehtod getInt returns an int and takes a String prompt as a parameter
        int input = 0;                                                          //creates and initializes an int as 0
        boolean isValid = false;                                                //creates a bool and initializes as false
        while (isValid == false){                                               //while loop exits when bool is set to true 
                System.out.print(prompt);                                       //print the given prompt
                if (sc.hasNextInt()){                                           //if the input is an integer value
                    input = sc.nextInt();                                       //sets it equal to the integer variable
                    isValid = true;                                             //sets bool to true and exits loop
                }
                else{                                                           //if a non-integer is entered
                    System.out.println("Error! Invalid integer value."          //prints error message
                                             + "Try again.");
                }
            sc.nextLine();                                                      // discard any data entered on the line
        }
        return input;                                                           //returns only valid integer inputs from user
    }                                                                           
    
    public int getInt ( String prompt, int min){                                //getInt method can also take an int as a min point
        int input = 0;                                                              //it will create an int and initialize it as 0
        boolean isValid = false;                                                //and create a bool and initialize it as false
        while ( isValid == false ){                                             //while loop exits when bool is set to True
        input = getInt(prompt);                                                     //takes advantage of existing getInt to provide a valid integer
            if ( input > min ){                                                     //checks that the int is greater then the min value
                isValid = true;                                                 //if yes sets bool to true and exits loop
            }
            else{
                System.out.println("Error! Integer must be greater than "       //if not prints error messgae loops until true
                                    + min + "Try again." );
            }
        }                                                                       
        return input;                                                               //returns the int
    } 

    public int getInt ( String prompt, int min, int max){                       //getInt method can also take two ints as min and max point
        int input = 0;                                                              
        boolean isValid = false;
        while ( isValid == false ){
        input = getInt(prompt);                                                 //uses getInt to get a valid input type    
            if ( input > min && input < max){                                   //if it's within the range 
                isValid = true;                                                 //sets bool to true and exits loop
            }
            else if (input < min){
                System.out.println("Error! Integer must be greater than "       //otherwise it prints out specific error
                                    + min + "Try again.");                      //messages for less than min or greater than max
            }                                                                   
            else{
                System.out.println("Error! Integer must be less than " + max);
            }
        }                                                                       //and keeps looping until a proper input is given
        return input;                                                           //returns the input
    } 
}