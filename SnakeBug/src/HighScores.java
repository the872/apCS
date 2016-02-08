import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;


public class HighScores
{
	private int scores = ((int)(Math.random()*100)*20);

	public int HighScores() 
	{
		return scores;
	}

	public void storeScore(ArrayList<Location>snake)
	{
		
		//JOptionPane.showMessageDialog(null, "Your score is " + (snake.size()*100));
		JOptionPane.showMessageDialog(null, "Your score to beat is " + scores);
		if((snake.size()*100) == scores)
		{
			JOptionPane.showMessageDialog(null, "You tied the high score with " + (snake.size()*100) + " but that's not more so you lose!");
		}
		else if((snake.size()*100) > scores)
		{
			JOptionPane.showMessageDialog(null, "You are the new high score with " + (snake.size()*100));
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry, you did not beat the high score. =(");
		}
			
		if((snake.size()*100) > scores)
		{
			scores = (snake.size()*100);
		}
	}

}
