import java.awt.*;
import javax.swing.*;

public class LoopedDrawingPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//no-argument constructor
	//builds an object with no instance data
	public LoopedDrawingPanel()
	{
		setBackground(Color.WHITE);
	}

	//draws the stuff I want you to draw using loops!	
	public void paint(Graphics g)
	{
		super.paint(g); //draw the white background color

		//Tells java to draw 4 squares
		checkerBoard(g);
	}


	//Problem #1 - draws 4 squares with widths 15, 30, 45, and 60
	//all 4 squares should be in the upper left hand corner of the screen
	public void drawSquares(Graphics g)
	{
		int h = 15;
		int w = 15;

		for(int sq =1; sq <= 4; sq++)
		{
			g.drawRect(0,0,w,h);
			w+= 15;
			h+= 15;
		}
	}


	//Problem #2 - draws n circles, all with the same *diameter* of 50
	//the circles should be going down the left side of the screen
	public void drawNCircles(Graphics g, int n)
	{
		int y=0;

		for(int circle =0; circle < n; circle++)
		{
			g.drawOval(0, y, 50, 50);
			y+=50;
		}
	}

	//Problem #3 - draws a n x n grid of circles, all with the same diameter of 50
	public void drawGridOfNCircles(Graphics g, int n)
	{
		int y=0;
		int x=0;

		for(int rows = 0; rows < n; rows++)
		{
			for(int columns= 0; columns < n; n++){
				g.drawOval(0, y, 50, 50);
				x+=50;
			}
			x= 0;
			y+=50;
		}
	}

	//Problem #4 - draws n circles, the first of which has a diameter of 50
	//Every subsequent circle should have a larger diameter as specified by
	//the diamGrowth variable.
	//the circles should be going across the top side of the screen
	public void drawNChangingCircles(Graphics g, int n, int diamGrowth)
	{
		int x = 0; 
		int diameter = diamGrowth;
		for(int circles = 0; circles < n; circles++)
		{
			g.fillOval(x, 0, diameter, diameter);

			diameter= diamGrowth;
			x+= diameter;

		}

	}

	//Problem #5 - draws a rectangle with a width of 100 and a height of 50
	//The upper left hand corner of the rectangle is (x,y).  The left half of the
	//rectangle should be filled with red, while the right half of the rectangle
	//should be filled with blue
	public void drawStamp(Graphics g, int x, int y)
	{
		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 50);
		g.setColor(Color.BLUE);
		g.fillRect(x+50, y, 50, 50);
	}

	//Challenge - draw a checker board!
	
	//I made a simple version of one. The rest we are supposed to imagine! 
	public void checkerBoard(Graphics g)
	{
		int x= 0;
		int y=0;
		Color theColor = Color.BLACK;
		
		for(int columns = 0; columns < getWidth(); columns++){
			for(int rows =0; rows < getHeight(); rows++){
				g.setColor(theColor);
				g.fillRect(x, y, 50, 50);
				x+=50;
				if(theColor == Color.WHITE){
					theColor=Color.black;
				}
				else
				{
					theColor = Color.WHITE;
				}
				x= 0;
				y+=50;
			}
		}
	}
}