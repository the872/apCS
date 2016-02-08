import javax.swing.*;

public class Runner {
    
    public static void main(String[] args) {
        
        HangMan game = new HangMan("TONSILS");
        
        while(!game.didLose() && !game.didWin()) {
            
            JOptionPane.showMessageDialog(null, "Your word so far is " + game.getWordSoFar());
            
            String guess = Prompter.promptForString("Guess a letter");
            
            boolean result = game.guess(guess);
            if(result == true)
                JOptionPane.showMessageDialog(null, "Good Guess!");
            else
                JOptionPane.showMessageDialog(null, "Sorry =(");
        }
        
        if(game.didLose()) {
             JOptionPane.showMessageDialog(null, "You Lost =(");
        }
        else {
             JOptionPane.showMessageDialog(null, "You won =)");
        }
        
    }

}