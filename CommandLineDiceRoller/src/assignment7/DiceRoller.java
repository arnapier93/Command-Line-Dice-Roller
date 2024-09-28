package assignment7;

import java.text.NumberFormat;
import java.util.Arrays;

public class DiceRoller{                                                        //beginning of class DiceRoller

    private final double count;                                                 //data attributes - a double called count to keep track of multiple rolls
    private final int[] combos;                                                 //and an integer array called combos to keep track of the values that are rolled
                                                                                    
    public DiceRoller (Die single, int totalRolls){                             //DiceRoller constructors require a Die or Dice object
        combos = new int [ 1 + single.getSides() ];                             //and an integer for total rolls to create a DiceRoller
        count = totalRolls;                                                     //though both work almost identically
    }                                                                               
                                                                                
    public DiceRoller (Dice pair, int totalRolls){                              //set the length for possible values equal to the total
        combos = new int [ 1 + pair.maxCombo() ];                               //number of sides and then add 1 to include for the intitial 0
        count = totalRolls;                                                     //and set the integer count to the int passed by the caller 
    }
    public int [] roll (Die single){                                            //public method roll also takes a die or dice as parameters
        for (int rolls = 0; rolls < count; rolls++){                            //agiain they are nearly identical
            int sum = single.roll();                                            //except for on this line single becomes pair 
            combos[sum]+=1;                                                     //the DiceRoller doesnt have a Die or Dice specific to it so it must 
        }                                                                       //always be passes the dice (just like a person playing a board game)
        return combos;                                                          //note--if no roll is made than combos remain filled with 0's and none of the rest of the code would do anything
    }
    public int [] roll (Dice pair){                                             //the die or dice are taken 
        for( int rolls = 0; rolls < count; rolls++ ){                           //a for loop based on count keeps track of rolls taken
            int sum = pair.roll();                                              //the roll is made wether pair or single
            combos[sum]+=1;                                                     //and the position on the combos array is properly marked
        }
        return combos;                                                          //return updated array with results of rolls
        }
    public int [ ] sums ( ){                                                    //public method sums returns an integer array and takes no parameters
        int [ ] values = new int [combos.length];                               //it creates an array values the length of the final combos array
        int pos = 0;                                                            //creates an integer, position, and sets it to 0
        for ( int idx = 0 ; idx < combos.length ;idx++ ){                       //for each possible index in the array (not the values of them but the actual 0-12)
            if (combos[idx] > 0){                                               //if the value stored at that index is greater than 0
                values[pos] = idx;                                              //add the value into the values array at position -- starts at 0
                pos++;                                                          //increment the position
            }   
        }
        int [] sums = Arrays.copyOfRange(values, 0, pos);                       //makes a copy of the values array dicarding anything after the last updated position
        return sums;                                                            //return the copy of the array which should remove all zeros
    }
    public int [ ] rollCount ( ) {
        int [ ] times = new int [combos.length];                                //creates new integer array times the length of the final combos array
        int pos= 0;                                                             //create another integer to track the position set it to 0
        for ( int idx : combos ){                                               //for each loop iterates through every value in the array
            if (idx > 0){                                                       //if said value is greater than 0
                times[pos] = idx;                                               //add the value to the times array at position -- starts at 0
                pos++;                                                          //increment position
            }
        }
        int [] rollCount = Arrays.copyOfRange(times, 0, pos);                   //makes a copy of the times array discarding anything after the last updated position
        return rollCount;                                                       //return the copy of the array which should remove all zeros
    }
    public String [ ] percents ( ){                                             //public method percents returns a String array and takes no parameters
        int [ ] rollCount = this.rollCount( );                                  //the values stored as the rollCount is required to get the percents
        String [ ] percents = new String [rollCount.length];                    //new string array percents of the same length as the rollCount
        int pos = 0;                                                            //set integer, position, to 0
        for (int idx : rollCount) {                                             //iterates through all values indexed in the rollCount array
            double ratio = idx / count;                                         //takes the value divided by the count as a double 
            NumberFormat percent = NumberFormat.getPercentInstance();           //creates a new number format
            String ratios = percent.format(ratio);                              //formats the doubles as Strings
            percents[pos] = ratios;                                             //sets the value of the array at that position -- starts at 0
            pos++;                                                              //increments the position
        }
        return percents;                                                        //returns the formated array of percentages
    }
    
    public String [] line (int row){                                            //public method line takes an integer "row" as a parameter
        int [ ] sums = this.sums();                                             //uses all 3 of the methods above
        int [ ] rollCount = this.rollCount();                                   //to find the various arrays and relate them  
        String [ ] percents = this.percents();                                  //to report on each combo that got rolled individually
        String [ ] line = new String [3];                                       //each line will be a string array with 3 elements
        line [0] = Integer.toString(sums[row]);                                 //the first being the sum found at that "row" or index value
        line [1] = Integer.toString(rollCount[row]);                            //the second being the number of times it landed on that particular sum
        line [2] = percents[row] ;                                              //the third being the percent of the total rolls that the second was
        return line;
    }
    public void printStats (){                                                  //public method printStats takes no parameters and returns void 
        System.out.println("Sum\tCount\tPercent%");                             //prints out a header for the table of statistics
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        int [] sums = this.sums();                                              //requires one of the arrays above
        String [] [] stats = new String [sums.length][3];                       //to determine the number of rows the columns are hardwired as 3 for this format
        for (int idx = 0 ; idx < sums.length ; idx++){                          //for any index integer less than the number of rows
            stats [idx] =  this.line(idx);                                      //set the row equal to the corresponding line mehtod at the same index 
        }
        for ( String[] row : stats ) {                                          //then use two for-each loops
            for ( String col : row ) {                                          //to print each col in each row
                System.out.print(col + "\t");                                   //with a tab to seperate them
            }
            System.out.println();                                               //and a new line for each row
        }
    }                                                                           
}                                                                               //end of DiceRoller class