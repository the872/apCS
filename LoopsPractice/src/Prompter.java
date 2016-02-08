import javax.swing.*;

/*
 
 Examples:
 
	int age = Prompter.promptForInteger("Enter your age.");
 
	double price = Prompter.pomptForDecimal("What is the price?");
 
	char choice = Prompter.promptForCharacter("What option will you pick?");
 
	String sentence = Prompter.promptForString("Enter your favorite sentence.");
 
 */

public class Prompter
{
	public static String promptForString(String message) {
		return JOptionPane.showInputDialog(null, message);
	}
	
	public static int promptForInteger(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(null, message));
	}
	
	public static double promptForDecimal(String message) {
		return Double.parseDouble(JOptionPane.showInputDialog(null, message));
	}
	
	public static char promptForCharacter(String message) {
		return JOptionPane.showInputDialog(null, message).charAt(0);
	}
}