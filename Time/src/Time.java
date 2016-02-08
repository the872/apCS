//Your Tasks
//
// #1 - Call the printCurrentTime() method from the main method() to see the current date and time appear on the screen!
// #2 - Finish the displayTime() method.  Call it from the main method to make sure it works!
// #3 - Finish the toSeconds() method.  Call it from the main method to make sure it works!  Be sure to store the result in a variable.
// #4 - Finish the timeDifference() method.  Call it from the main metho to make sure it works!  Be sure to store the result in a variable.

import java.util.Date;

import javax.swing.JOptionPane;


public class Time
{
    
    public static void main(String[] args)
    {
    	printCurrentTime();
    	displayTime(6, 3, true);
    	
    	int seconds = toSeconds(1, 10, 30);
    	JOptionPane.showMessageDialog(null, + seconds + " seconds.");
    	
    	int difference = timeDifference(12, 30, 11, 0);
    	JOptionPane.showMessageDialog(null, "The time difference is " + difference + " minutes.");
    }
    
    //Prints the current time
    public static void printCurrentTime()
    {
        Date date = new Date();
        System.out.println(date.toString());
    }
    
    //Displays the time based on the given hours, minutes, and am/pm
    // Ex1: hours=12, minutes=11, isAM=true => 12:11 AM
    // Ex2: hours=6, minutes=3, isAM=false => 6:03 PM
    public static void displayTime(int hours, int minutes, boolean isAM)
    {
    	if (isAM == true){
    		if(minutes > 9){
    		JOptionPane.showMessageDialog(null,  "Time is " + hours + ":" + minutes + " AM.");
    		}
    			else
    				JOptionPane.showMessageDialog(null,  "Time is " + hours + ":0" + minutes + " AM.");
    		}
    	else {
    		if(minutes > 9){
        		JOptionPane.showMessageDialog(null,  "Time is " + hours + ":" + minutes + " AM.");
    		}
        		else
        			JOptionPane.showMessageDialog(null,  "Time is " + hours + ":0" + minutes + " AM.");
        		}
    }
    
    //Returns the total seconds represented by hours, minutes, and seconds.
    // Ex1: hours=1, minutes=10, seconds=30 => 4230
    // Ex2: hours=0, minutes=50, seconds=10 => 3010
    public static int toSeconds(int hours, int minutes, int seconds)
    {
        seconds += (minutes * 60);
        minutes = 0;
        seconds += (hours * 3600);
        hours = 0;
                
        return seconds; 
        
    }
    
    //Calculates the time difference in minutes between the two times - returns this value
    //You may assume both times are on the same part of the day, and that the first time
    //is later in the day
    // Ex1: 3:15 and 1:20 => 115 minutes
    // Ex2: 3:05 and 12:00 => 185 minutes [Tricky!]
    // Ex3: 11:00 and 12:30 => 630 minutes
    public static int timeDifference(int h1, int m1, int h2, int m2)
    {
    	if(h1 != 12 || h2 != 12){
    		m1 = (h1 *60) + m1;
    		m2 = (h2 *60) + m2;
    		m1 = m2 - m1;
    	}
    	else{
    		m1 = (0) + m1;
    		m2 = (0) + m2;
    		m1 = m2 - m1;
    		
    	}
        return -m1;
    }
    
        
}
