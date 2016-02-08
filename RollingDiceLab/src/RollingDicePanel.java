import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Your Tasks:
/*
0 - Change the code so that the randomly generated numbers represent a DICE roll, not a COIN flip

1 - Add code so that two different dice are rolled at the same time 
    You'll need a new variable, you'll need to change its value, and you'll need to draw it

2 - Add code so that bigger of the two rolled dice is displayed (I wish there was a Math function for this…)
    You'll need a new variable, you'll have to change its value when a roll is finished, and you'll need to draw it

3 - Add code so that the sum of the two rolled dice is displayed
    You'll need a new variable, you'll need to change its value, and you'll need to draw it

4 - Add code so that you keep a running total of the finished dice rolls
	For example: 	You roll a 5 and a 6, the running total is now 11
			You roll a 3 and a 2, the running total is now 16
			You roll a 1 and a 1, the running total is now 18
    You'll need a new variable, you'll have to change its value when a roll is finished, and you'll need to draw it
*/

public class RollingDicePanel extends JPanel
{	
	//class level variable that represents one die
	int firstRandomNum;
	int secondRandomNum;
	int maxNum;
	int totalNum;
	int runningTotal;

	
	
	//rolls the dice - called over and over again when the button in RollingDiceFrame is pressed
	public void roll() {
		
		firstRandomNum = (int)(Math.random() * 6)+2;
		secondRandomNum = (int)(Math.random() *6)+1;
		maxNum = Math.max(firstRandomNum, secondRandomNum);
		totalNum = firstRandomNum + secondRandomNum; 
		
		
	}
	
	//code that is executed ONCE after the dice finishing rolling
	public void finishedRolling() {
		
	
	runningTotal = runningTotal + totalNum;
	
		System.out.println("I finished rolling with a " + firstRandomNum);
		System.out.println("I finished rolling with a " + secondRandomNum);
	}
	
	//draws everything
	public void paint(Graphics g) {
		
		int width = getWidth();
		int height = getHeight();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		g.setFont(new Font("Geneva", Font.BOLD, 24));
		g.setColor(Color.BLUE);
		g.drawString("Dice 1:  " + firstRandomNum, 10, 25);
		g.drawString("Dice 2: " + secondRandomNum, 10, 50);
		g.drawString("Greater #: " + maxNum , 10, 75);
		g.drawString("Total: " + totalNum, 10, 100);
		g.drawString("Running Total: " + runningTotal, 10, 125);
	}
}