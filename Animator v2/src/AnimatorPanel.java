import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;



public class AnimatorPanel extends JPanel implements ActionListener
{
	private Timer timer; //an object that generates "action" events
	private ArrayList<Sphere> spheres = new ArrayList<Sphere>();


	


	public AnimatorPanel() 
	{
		setBackground(Color.WHITE);

	}

	public void init()
	{

		Color customColor = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
		Color customColorTwo = new Color((int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100));

		spheres.add(new ExampleSphere(50,150,50,customColor, getWidth(), getHeight()));

		//spheres.add(new ExampleTwo(50,150,50,customColorTwo, getWidth(), getHeight()));



		timer = new Timer(100,this); //sets up an action event generator that will go off every 100 milliseconds (10 times every second)
		timer.start(); //start the action events!
	}

	//this method is called every 1/10th of a second by the timer
	//it should move the sphere(s)
	public void actionPerformed(ActionEvent e)
	{
		for(Sphere s: spheres)
			s.move();
		repaint();
	}

	//draws the spheres
	public void paint(Graphics g)
	{
		super.paint(g);

		for(Sphere s: spheres)
			s.draw(g);
	}
}
