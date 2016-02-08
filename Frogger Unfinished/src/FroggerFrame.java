import java.awt.*;

import javax.swing.*;


public class FroggerFrame extends JFrame {

	private static Image green = ImageLoader.loadImage("frog.png");
	private static Image blue = ImageLoader.loadImage("bluefrog.png");
	private static Image red = ImageLoader.loadImage("redfrog.png");
	
	
	public static void main(String[] args)
	{
		new FroggerFrame();
	}
	
	public FroggerFrame()
	{
		setTitle("Frogger || Created By: Aid Idrizovic");
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		final FroggerPanel panel = FroggerPanel.sharedInstance;
		panel.setPreferredSize(new Dimension(640, 680));
		c.add(panel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		this.setIconImage(green);
		
		setVisible(true);
		pack();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				panel.initGame();
				panel.requestFocus();
			}
		});
	}
	
}
