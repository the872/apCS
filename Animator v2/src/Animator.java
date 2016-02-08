import java.awt.*;
import javax.swing.*;

public class Animator extends JFrame 
{
	private AnimatorPanel panel;

	public static void main(String[] args) 
	{
		Animator ani = new Animator();
		ani.setSize(500,600);
        ani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ani.setTitle("Animator");
		ani.setVisible(true);
		
		ani.getAnimatorPanel().init();
	}

    public Animator() 
	{
		panel = new AnimatorPanel();
		getContentPane().add(panel);
	}
	
	public AnimatorPanel getAnimatorPanel()
	{
		return panel;
	}
}