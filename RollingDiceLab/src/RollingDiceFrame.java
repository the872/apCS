import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RollingDiceFrame extends JFrame implements ActionListener
{
	
	private RollingDicePanel panel;
	private JButton roll;
	
	private Timer timer;
	private int counter = -1;
	
	public static void main(String[] args) {
		RollingDiceFrame frame = new RollingDiceFrame();
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public RollingDiceFrame() {
		
		Container c = getContentPane();
		setLayout(new BorderLayout());
		
		panel = new RollingDicePanel();
		c.add(panel, BorderLayout.CENTER);
		
		roll = new JButton("Roll");
		roll.addActionListener(this);
		
		JPanel south = new JPanel();
		south.add(roll);
		
		c.add(south, BorderLayout.SOUTH);
		
		timer = new Timer(10, this);
		timer.setRepeats(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(counter == -1) {
			counter = 100;
			timer.start();
			roll.setEnabled(false);
		}
		else {
			counter--;
			panel.roll();
			if(counter == -1)
			{
				roll.setEnabled(true);
				panel.finishedRolling();
				timer.stop();
			}
		}
		
		repaint();

	}
}