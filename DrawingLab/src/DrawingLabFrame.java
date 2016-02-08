import java.awt.*;
import javax.swing.*;

public class DrawingLabFrame extends JFrame
{
	private DrawingLabPanel panel;

	public static void main(String[] args) {

		DrawingLabFrame frame = new DrawingLabFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Drawing Lab");
		frame.setVisible(true);
	}

	public DrawingLabFrame() 
	{
		panel = new DrawingLabPanel();

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel, BorderLayout.CENTER);
	}
}