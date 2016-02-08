import java.awt.Color;
import java.awt.Graphics;


public class ExampleSphere extends Sphere 
{

	public ExampleSphere(int initX, int initY, int rad, Color col, int pw, int ph) 
	{
		super(initX, initY, rad, col, pw, ph);
		
		setYMove((int)(Math.random()*100));
		
		setXMove((int)(Math.random()*100));
	}

	public void move() 
	{
		super.move();	

		if(getXCenter() + getRadius() > getPanelWidth())
		{
			setXMove(-getXMove());
		}

		if(getXCenter() - getRadius() < 0)
		{
			setXMove(-getXMove());
		}

		if(getYCenter() + getRadius() > getPanelHeight())
		{
			setYMove(-getYMove());
		}
		
		if(getYCenter() - getRadius() < 0)
		{
			setYMove(-getYMove());
		}

	}

	public void draw(Graphics g)
	{
		super.draw(g);
		
		Color customColor = new Color((int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100));
		g.setColor(customColor);
		
		g.fillOval(getXCenter() - getRadius(), 
				   getYCenter() - getRadius(), 
				   getRadius()*2, 
				   getRadius()*2);

		
		g.setColor(Color.BLACK);
		g.drawOval(getXCenter()  - getRadius(),
				getYCenter() - getRadius(),
				getRadius()*2,
				getRadius()*2);
	}
}
