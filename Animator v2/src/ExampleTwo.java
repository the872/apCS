import java.awt.Color;
import java.awt.Graphics;

public class ExampleTwo extends Sphere 
{

	public ExampleTwo(int initX, int initY, int rad, Color col, int pw, int ph) 
	{
		super(initX, initY, rad, col, pw, ph);
		
		setYMove((int)(Math.random()*50));
		
		setXMove((int)(Math.random()*50));
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
		//super.draw(g);
		
		if(getXCenter() + getRadius() > getPanelWidth())
		{
			
		}

		if(getYCenter() + getRadius() > getPanelHeight())
		{
			
		}
		
		
		Color customColor = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
		g.setColor(customColor);
		
		g.fillOval(getXCenter() - getRadius(), 
				   getYCenter() - getRadius(), 
				   getRadius()*2, 
				   getRadius()*2);

		
		g.setColor(customColor);
		g.drawOval(getXCenter()  - getRadius(),
				getYCenter() - getRadius(),
				getRadius()*2,
				getRadius()*2);
	}
}
