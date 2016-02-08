import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AnimatorPanel extends JPanel implements ActionListener
{
	private Timer timer; //an object that generates "action" events
	private Sphere sphereA;
	private Sphere sphereB;
	private Sphere sphereC;

	public AnimatorPanel() 
	{
		setBackground(Color.white);
	}

	public void init()
	{
		int width = getWidth(); //width of the panel, in case you need it
		int height = getHeight(); //height of the panel, in case you need it

		sphereA = new Sphere(50,50,50,Color.blue);
		sphereB = new Sphere(50,height / 2,50,Color.red);
		sphereC = new Sphere(50, height - 50, 50,Color.green);

		timer = new Timer(25,this); //sets up an action event generator that will go off every 100 milliseconds (10 times every second)
		timer.start(); //start the action events!
	}

	//this method is called every 1/10th of a second by the timer
	//it should move the sphere(s)
	public void actionPerformed(ActionEvent e)
	{

		int sphereY = sphereA.getCenterY();
		int sphereX = sphereA.getCenterX();
		int sphereRadius = sphereA.getRadius();

		if(sphereX >= getWidth() - sphereRadius)
			timer.stop();
		else
			sphereA.setCenterX(sphereX + (int)(Math.random() *9));
		repaint();
		JOptionPane.showMessageDialog(null, "The blue ball wins!");
		
		int sphereY2 = sphereB.getCenterY();
		int sphereX2 = sphereB.getCenterX();
		int sphereRadius2 = sphereB.getRadius();

		if(sphereX2 >= getWidth() - sphereRadius2)
			timer.stop();
		else
			sphereB.setCenterX(sphereX2 + (int)(Math.random() *9));
		repaint();
		
		int sphereY3 = sphereC.getCenterY();
		int sphereX3 = sphereC.getCenterX();
		int sphereRadius3 = sphereC.getRadius();

		if(sphereX3 >= getWidth() - sphereRadius3)
			timer.stop();
		else
			sphereC.setCenterX(sphereX3 + (int)(Math.random() *9));
		repaint();
	}


	//draws the spheres
	public void paint(Graphics g)
	{
		super.paint(g);

		if(sphereA != null)
			sphereA.drawSphere(g);
		
		if(sphereB != null)
			sphereB.drawSphere(g);
		
		if(sphereC != null)
			sphereC.drawSphere(g);

		//draws the center lines for the screen
		g.setColor(Color.black);
		g.drawLine(getWidth()/2,0,getWidth()/2,getHeight());
		g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
	}
}
