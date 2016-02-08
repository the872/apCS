import javax.swing.JOptionPane;

/*
 
 Instructions: This class represents a Vending Machine.  Your tasks:
	#1: List the names of all the class variables
        
        Class variables:gumLeft;
 						doritosLeft;
 						centsEntered;
    					centsLeft;
 
	#2: List the names of all the methods:
 
        Methods:restockVendingMachine();
       			printDiagnostics();
 				runVendingMachine();
 				askUserForMoney();
 				quit()
 				buyGum()
 				buyDoritos()
 
	#3: Finish the runVendingMachine() method - specifically, finish the 3 missing conditional cases (the quit case is done)
	#4: Finish the restockVendingMachine() method - if this works, the console should display that there are 20 gums and Doritos win the program is first run
	#5: Finish the askUserForMoney() method - this should use Prompter
	#6: Finish the buyGum() method
	#7: Finish the buyDoritos() method
    #8: Have the quit method also display the amount of change that the user is getting back
 
 */

public class VendingMachine
{
    //the amount of each of the three products that are left in the vending machine
    static int gumLeft;
    static int doritosLeft;
    
    //amount of money that the user has entered in cents
    static int centsEntered;
    static int centsLeft;
    
    public static void main(String[] args) {
        
        restockVendingMachine();
        printDiagnostics();

        runVendingMachine();
    }
    
    public static void runVendingMachine()
    {
        //ask the user what they want to do next
        char choice = Prompter.promptForCharacter("What would you like to do?: " +
                                              "\n[E]nter money" +
                                              "\n[Q]uit and get change" +
                                              "\nPurchase: " +
                                              "\n    [G]um - 30 cents" +
                                              "\n    [D]oritos - 50 cents");
        
        
        //A bunch of cases to deal with the user selections
        //'E'/'e' -> ask the user to enter money
        //'Q'/'q' -> quit [you actually don't have to do anything for this case...]
        //'G'/'g' -> Buy 1 piece of gum
        //'D'/'d' -> Buy 1 Dorito
        
        if(choice == 'Q' || choice == 'q')
        {
            //method that makes your program  end
            quit();
        }        
        else if(choice == 'E' || choice == 'e'){
        	askUserForMoney();
        }
        else if(choice == 'G' || choice == 'g')
        {
        	buyGum();	
        }
        else if(choice == 'D' || choice == 'd')
        {
        	buyDoritos();
        }
        
        //print internal diagnostics so the repair man can fix the machine if needed
        printDiagnostics();

        //run the vending machine again!
        runVendingMachine();
        
    }
    
    //Fancy method that makes your program quit
    public static void quit() {
    	if(centsEntered < 0){
    		JOptionPane.showMessageDialog(null,"Thank you for shopping. Please take your" + centsEntered + " cents change.");
    	}
    		else if(centsEntered > 0){
    		JOptionPane.showMessageDialog(null,"Thank you for shopping.");
    	}
    	centsEntered = 0;
    	printDiagnostics();
        System.exit(0);
    }
    
    //put more gum and doritos in the vending machine
    //post condition: the variables gumLeft and doritosLeft are all set to 20 each
    public static void restockVendingMachine() {
    	
        gumLeft = 20;
        doritosLeft = 20;
        
    }

    
    //displays internal vending machine information
    public static void printDiagnostics() {
        System.out.println("Gums Left: " + gumLeft + ", Doritos Left: " + doritosLeft + ", User Money Entered: " + centsEntered + ", Cents Left in Machine: " + centsLeft );
    }
    
    //prompts the user to enter some amount of money
    //  post condition: the centsEntered variable is increased by how much the user enters
    public static void askUserForMoney() {
    	centsEntered += Prompter.promptForInteger("How many cents would you like to put in?");
        if (centsEntered > 1600)
        {
        	JOptionPane.showInputDialog(null,"Sorry, we cannot take that much money. Press enter to try again.");
        	centsEntered = 0;
        }
     
        
    }
    
    //dispenses one gum
    // if the user does not have enough money or if the machine is out of gum, the user should be told as such
    // otherwise, the gumLeft variable is decremented and the centsEntered variable is decreased appropriately.
    public static void buyGum() {
        if(centsEntered >= 30 && gumLeft > 0){
        	centsEntered -= 30; 
        	centsLeft += 30;
        	gumLeft -= 1;
        	JOptionPane.showMessageDialog(null,"Thank you for your purchase! Press enter to continue.");
        }
        else if(centsEntered < 30)
        {
        	JOptionPane.showMessageDialog(null,"Sorry, an error occured, please try agian.");
        }
    }
    
    //dispenses one Dorito bag
    // if the user does not have enough money or if the machine is out of Doritos, the user should be told as such
    // otherwise, the doritosLeft variables is decremented and the centsEntered variable is decreased appropriately.
    public static void buyDoritos() {
    	if(centsEntered >= 50 && doritosLeft > 0){
        	centsEntered -= 50; 
        	centsLeft += 50;
        	doritosLeft -= 1;
        	JOptionPane.showMessageDialog(null,"Thank you for your purchase! Press enter to continue.");
        }
        else if(centsEntered < 50)
        {
        	JOptionPane.showMessageDialog(null,"Sorry, an error occured, please try agian.");
        }
    }
}