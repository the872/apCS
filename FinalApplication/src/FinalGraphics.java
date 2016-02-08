/**
 *
 * NAME: Aid Idrizovic
 *
 * Program: FinalGraphics draws a number of pictures to the screen (some will be going off the screen!)
 *
 * Scoring: Half for correctly finishing drawShape method
 *          Half for correctly finishing paint method
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinalGraphics extends JPanel
{
	public static void main(String[] args) {
		JFrame fg = new JFrame();
        Container c = fg.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(new FinalGraphics(), BorderLayout.CENTER);
		fg.setTitle("Final Graphics");
		fg.setSize(600, 600);
		fg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fg.setVisible(true);
		fg.validate();
	}
	
	public FinalGraphics()
	{
		setBackground(Color.white);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
		
		//call drawShape(g, ..., ...) to draw your shape at the x,y coordinate you want
        //you should draw the shape multiple times to finish this assignment
		int n = 0;
		while(n < 25){
		drawShape(g, 0 + (60*n), 0);
		n++;
		}
        
	}

	//draws the shape ONCE at the given x and y coordinate
	public void drawShape(Graphics g, int x, int y)
	{
		g.setColor(Color.RED);
		g.fillRect(x, y, 30, 60);
		g.setColor(Color.BLUE);
		g.fillRect(x + 30, y, 30, 60);
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 60, 60);
	}
}
