import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JOptionPane;


public class RPS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variable for your choice 
		char choice;
		//computer choice
		int computerChoice;
		char playAgain;
		//title
		JOptionPane.showMessageDialog(null, "Press OK to play Rock, Paper, Scissors");
		//asking for your choice 
		choice = Prompter.promptForCharacter("Type a letter!(Rock: r, Paper: p, Scissors: s)");
		//computer's random choice 
		computerChoice = (int) Math.random()*2;
		//possible result 1 
		if (computerChoice == 0 && choice == 'r')
		//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw rock. Tie!");
		//possible result 2
		if (computerChoice == 0 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw rock. You Win!");
		//possible result 3
		if (computerChoice == 0 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw rock. You Lose!");
		//possible result 4
		if (computerChoice == 1 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw paper. You Lose!");
		//possible result 5
		if (computerChoice == 1 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw paper. Tie!");
		//possible result 6
		if (computerChoice == 1 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw paper. You Win!");
		//possible result 7
		if (computerChoice == 2 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw scissors. You Win!");
		//possible result 8
		if (computerChoice == 2 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw scissors. You Lose!");
		//possible result 9
		if (computerChoice == 2 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw scissors. Tie!");
		
		playAgain = Prompter.promptForCharacter("Do you want to play again? (Type y)");
		if(playAgain == 'y' || playAgain == 'Y');
		
		JOptionPane.showMessageDialog(null, "Press OK to play Rock, Paper, Scissors");
		//asking for your choice 
		choice = Prompter.promptForCharacter("Type a letter!(Rock: r, Paper: p, Scissors: s)");
		//computer's random choice 
		computerChoice = (int) Math.random()*2;
		//possible result 1 
		if (computerChoice == 0 && choice == 'r')
		//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw rock. Tie!");
		//possible result 2
		if (computerChoice == 0 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw rock. You Win!");
		//possible result 3
		if (computerChoice == 0 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw rock. You Lose!");
		//possible result 4
		if (computerChoice == 1 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw paper. You Lose!");
		//possible result 5
		if (computerChoice == 1 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw paper. Tie!");
		//possible result 6
		if (computerChoice == 1 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw paper. You Win!");
		//possible result 7
		if (computerChoice == 2 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw scissors. You Win!");
		//possible result 8
		if (computerChoice == 2 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw scissors. You Lose!");
		//possible result 9
		if (computerChoice == 2 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw scissors. Tie!");
		
		playAgain = Prompter.promptForCharacter("Do you want to play again? (Type y)");
		if(playAgain == 'y' || playAgain == 'Y');
		
		JOptionPane.showMessageDialog(null, "Press OK to play Rock, Paper, Scissors");
		//asking for your choice 
		choice = Prompter.promptForCharacter("Type a letter!(Rock: r, Paper: p, Scissors: s)");
		//computer's random choice 
		computerChoice = (int) Math.random()*2;
		//possible result 1 
		if (computerChoice == 0 && choice == 'r')
		//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw rock. Tie!");
		//possible result 2
		if (computerChoice == 0 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw rock. You Win!");
		//possible result 3
		if (computerChoice == 0 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw rock. You Lose!");
		//possible result 4
		if (computerChoice == 1 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw paper. You Lose!");
		//possible result 5
		if (computerChoice == 1 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw paper. Tie!");
		//possible result 6
		if (computerChoice == 1 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw paper. You Win!");
		//possible result 7
		if (computerChoice == 2 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw scissors. You Win!");
		//possible result 8
		if (computerChoice == 2 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw scissors. You Lose!");
		//possible result 9
		if (computerChoice == 2 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw scissors. Tie!");
		
		playAgain = Prompter.promptForCharacter("Do you want to play again? (Type y)");
		if(playAgain == 'y' || playAgain == 'Y');
		
		JOptionPane.showMessageDialog(null, "Press OK to play Rock, Paper, Scissors");
		//asking for your choice 
		choice = Prompter.promptForCharacter("Type a letter!(Rock: r, Paper: p, Scissors: s)");
		//computer's random choice 
		computerChoice = (int) Math.random()*2;
		//possible result 1 
		if (computerChoice == 0 && choice == 'r')
		//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw rock. Tie!");
		//possible result 2
		if (computerChoice == 0 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw rock. You Win!");
		//possible result 3
		if (computerChoice == 0 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw rock. You Lose!");
		//possible result 4
		if (computerChoice == 1 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw paper. You Lose!");
		//possible result 5
		if (computerChoice == 1 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw paper. Tie!");
		//possible result 6
		if (computerChoice == 1 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw paper. You Win!");
		//possible result 7
		if (computerChoice == 2 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw scissors. You Win!");
		//possible result 8
		if (computerChoice == 2 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw scissors. You Lose!");
		//possible result 9
		if (computerChoice == 2 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw scissors. Tie!");
		
		playAgain = Prompter.promptForCharacter("Do you want to play again? (Type y)");
		if(playAgain == 'y' || playAgain == 'Y');
		
		JOptionPane.showMessageDialog(null, "Press OK to play Rock, Paper, Scissors");
		//asking for your choice 
		choice = Prompter.promptForCharacter("Type a letter!(Rock: r, Paper: p, Scissors: s)");
		//computer's random choice 
		computerChoice = (int) Math.random()*2;
		//possible result 1 
		if (computerChoice == 0 && choice == 'r')
		//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw rock. Tie!");
		//possible result 2
		if (computerChoice == 0 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw rock. You Win!");
		//possible result 3
		if (computerChoice == 0 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw rock. You Lose!");
		//possible result 4
		if (computerChoice == 1 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw paper. You Lose!");
		//possible result 5
		if (computerChoice == 1 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw paper. Tie!");
		//possible result 6
		if (computerChoice == 1 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw paper. You Win!");
		//possible result 7
		if (computerChoice == 2 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw scissors. You Win!");
		//possible result 8
		if (computerChoice == 2 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw scissors. You Lose!");
		//possible result 9
		if (computerChoice == 2 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw scissors. Tie!");
		
		playAgain = Prompter.promptForCharacter("Do you want to play again? (Type y)");
		if(playAgain == 'y' || playAgain == 'Y');
		
		JOptionPane.showMessageDialog(null, "Press OK to play Rock, Paper, Scissors");
		//asking for your choice 
		choice = Prompter.promptForCharacter("Type a letter!(Rock: r, Paper: p, Scissors: s)");
		//computer's random choice 
		computerChoice = (int) Math.random()*2;
		//possible result 1 
		if (computerChoice == 0 && choice == 'r')
		//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw rock. Tie!");
		//possible result 2
		if (computerChoice == 0 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw rock. You Win!");
		//possible result 3
		if (computerChoice == 0 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw rock. You Lose!");
		//possible result 4
		if (computerChoice == 1 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw paper. You Lose!");
		//possible result 5
		if (computerChoice == 1 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw paper. Tie!");
		//possible result 6
		if (computerChoice == 1 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw paper. You Win!");
		//possible result 7
		if (computerChoice == 2 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw scissors. You Win!");
		//possible result 8
		if (computerChoice == 2 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw scissors. You Lose!");
		//possible result 9
		if (computerChoice == 2 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw scissors. Tie!");
		
		playAgain = Prompter.promptForCharacter("Do you want to play again? (Type y)");
		if(playAgain == 'y' || playAgain == 'Y');
		
		JOptionPane.showMessageDialog(null, "Press OK to play Rock, Paper, Scissors");
		//asking for your choice 
		choice = Prompter.promptForCharacter("Type a letter!(Rock: r, Paper: p, Scissors: s)");
		//computer's random choice 
		computerChoice = (int) Math.random()*2;
		//possible result 1 
		if (computerChoice == 0 && choice == 'r')
		//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw rock. Tie!");
		//possible result 2
		if (computerChoice == 0 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw rock. You Win!");
		//possible result 3
		if (computerChoice == 0 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw rock. You Lose!");
		//possible result 4
		if (computerChoice == 1 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw paper. You Lose!");
		//possible result 5
		if (computerChoice == 1 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw paper. Tie!");
		//possible result 6
		if (computerChoice == 1 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw paper. You Win!");
		//possible result 7
		if (computerChoice == 2 && choice == 'r')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw rock and the computer threw scissors. You Win!");
		//possible result 8
		if (computerChoice == 2 && choice == 'p')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw paper and the computer threw scissors. You Lose!");
		//possible result 9
		if (computerChoice == 2 && choice == 's')
			//display result 
			JOptionPane.showMessageDialog(null, "You threw scissors and the computer threw scissors. Tie!");
		
		playAgain = Prompter.promptForCharacter("Do you want to play again? (Type y)");
		if(playAgain == 'y' || playAgain == 'Y');
		
		
	}
	
}
			
	


			
		
		
		
		
		


