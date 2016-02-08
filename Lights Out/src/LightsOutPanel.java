import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LightsOutPanel extends JPanel implements MouseListener
{
	//define your 2D array of booleans
	private boolean[][] board = new boolean[5][5];

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("Lights Out!");
		frame.setSize(500, 500);
		frame.setVisible(true);

		LightsOutPanel panel = new LightsOutPanel();
		panel.addMouseListener(panel);

		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel, BorderLayout.CENTER);

	}

	public LightsOutPanel()
	{
		for(int row = 0; row < board.length; row++) 
		{
			for(int col = 0; col < board.length; col++) 
			{
				board[row][col] = true;
			}
		}
	}

	//unused methods
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public void paint(Graphics g)
	{

		int panelWidth = getWidth();
		int panelHeight = getHeight();
		int boxWidth = panelWidth / board.length; 
		int boxHeight = panelHeight / board.length;

		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) 
			{
				if(board[row][col] == true) 
				{
					g.setColor(Color.YELLOW);
					g.fillRoundRect(row  * (boxWidth), col * (boxHeight), boxWidth, boxHeight, boxWidth/4, boxHeight/4);

				} 
				else
				{
					g.setColor(Color.WHITE);
					g.fillRoundRect(row  * (boxWidth), col * (boxHeight), boxWidth, boxHeight, boxWidth/4, boxHeight/4);

				}
				g.setColor(Color.black);
				g.drawRoundRect(row  * (boxWidth), col * (boxHeight), boxWidth, boxHeight, boxWidth/4, boxHeight/4);

			}

		}



		//whenever possible, please use the length's of your array as opposed to numeric literals
		//i.e. array.length instead of 5

		//to be assigned...

		//you will need to loop over all the boxes in your array, and if they are true, draw a yellow box, 
		//otherwise draw a black box
	}

	//called when the mouse is pressed
	public void mousePressed(MouseEvent e)
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
		int lightsOn = board.length * board.length;

		int panelWidth = getWidth();
		int panelHeight = getHeight();

		//to be assigned...
		int boxWidth = panelWidth / board.length; 
		int boxHeight = panelHeight / board.length;

		int locationX = mouseX / boxWidth;
		int locationY = mouseY / boxHeight;

		System.out.println("The last mouse clicked was at (" + (locationX + 1) + ", " + (locationY + 1) + ")");



		if(board [locationX][locationY] != true)
		{
			board [locationX][locationY] = true;
		}
		else
		{
			board [locationX][locationY] = false;
		}

		try 
		{
			if(board [locationX -1][locationY] != true)
			{
				board [locationX -1 ][locationY] = true;
			}
			else
			{
				board [locationX - 1][locationY] = false;
			}
		} catch (Exception ex)
		{

		}

		try {
			if(board [locationX + 1][locationY] != true)
			{
				board [locationX + 1][locationY] = true;
			}
			else
			{
				board [locationX + 1][locationY ] = false;
			}
		} catch (Exception ex)
		{

		}

		try{
			if(board [locationX][locationY + 1] != true)
			{
				board [locationX][locationY + 1] = true;
			}
			else
			{
				board [locationX][locationY + 1] = false;
			}
		} catch (Exception ex)
		{

		}

		try {
			if(board [locationX][locationY - 1] != true)
			{
				board [locationX][locationY - 1] = true;
			}
			else
			{
				board [locationX][locationY - 1] = false;
			}
		} catch (Exception ex)
		{

		}



		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) 
			{
				if(board[row][col] == true) 
				{

					lightsOn -= 1;
				} 
				else
				{

					lightsOn += 1;
				}

			}

		}
		if(lightsOn == -1 * (board.length * board.length))
		{
			System.out.print("You have " + (lightsOn - 1) + " lights toggled off at this time. ");
		}
		else
		{
			System.out.print("You have " + (lightsOn/2) + " lights toggled off at this time. ");
		}

		if(lightsOn == 10 * (board.length * board.length))
		{
			System.out.print("You Win!");
			JOptionPane.showMessageDialog(null, "Congrats! You Win!");

			for(int row = 0; row < board.length; row++) {
				for(int col = 0; col < board.length; col++) 
				{
					board[row][col] = true;
				}
			}

		}



		//whenever possible, please use the length's of your array as opposed to numeric literals
		//i.e. array.length instead of 5

		//you will need to calculate the row an column of where the user clicked
		//then toggle that box and the four boxes around it.  You will get a NASTY
		//red error message if you try to toggle a box that is out of the bounds of
		//your array!

		//execute the line of code below to tell the user that they've won!
		//JOptionPane.showMessageDialog(null, "Congrats!");

		//leave this as the last line in this method
		repaint();
	}
}