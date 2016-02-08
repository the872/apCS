import java.awt.*;
import javax.swing.*;

public class LoopedDrawingFrame extends JFrame
{
	private LoopedDrawingPanel panel;
	
	public static void main(String[] args)
	{
		LoopedDrawingFrame frame = new LoopedDrawingFrame();
		frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Looped Drawing");
		frame.setVisible(true);
	}
	
	public LoopedDrawingFrame()
	{
		Container c = getContentPane();
		
		panel = new LoopedDrawingPanel();
		
		c.add(panel);
	}
}