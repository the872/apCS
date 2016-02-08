import java.awt.*;
import javax.swing.*;

public class Sphere {
	private int xCoord, yCoord, radius;
	private Color color;
	
	public Sphere(int initX, int initY, int rad, Color col)
    {
		xCoord = initX;
		yCoord = initY;
		color = col;
		radius = rad;
	}
	
	public void setCenterX(int x)
    {
        xCoord = x;
    }
	
	public void setCenterY(int y)
    {
        yCoord = y;
    }
	
	public void setRadius(int rad)
    {
        radius = rad;
    }
	
	public void setColor(Color col)
    {
        color = col;
    }
	
	public int getCenterX()
    {
        return xCoord;
    }
	
	public int getCenterY()
    {
        return yCoord;
    }
	
	public int getRadius()
    {
        return radius;
    }
	
	public Color getColor()
    {
        return color;
    }
	
	public void drawSphere(Graphics g)
	{
		g.setColor(color);
		g.fillOval(	 getCenterX() - getRadius(), 
	 	 	 	 	 getCenterY() - getRadius(), 
	 	 	 	 	 getRadius()*2, 
	 	 	 	 	 getRadius()*2);
	}
}
