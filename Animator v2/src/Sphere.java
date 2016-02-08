import java.awt.*;
import javax.swing.*;

public class Sphere {
	private int xCenter;
	private int yCenter;
	private int radius;
	private int panelWidth;
	private int panelHeight;
	private Color color;
	
	private int xMove;
	private int yMove;
	
    //constructor for the sphere class
    //@param initX - the center x coordinate of the sphere
    //@param initY - the center y coordinate of the sphere
    //@param rad - the radius of the sphere
    //@param col - the color of the sphere
    //@param pw - the width of the screen
    //@param ph - the height of the screen
	public Sphere(int initX, int initY, int rad, Color col, int pw, int ph) {
		xCenter = initX;
		yCenter = initY;
		radius = rad;
		color = col;
		
		panelWidth = pw;
		panelHeight = ph;
		
		xMove = 50;
		yMove = 0;
	}
	
    //moves the sphere
	public void move() {		
		
		xCenter += xMove;
		yCenter += yMove;
	}
	
    //draws the sphere
	public void draw(Graphics g)
	{
		g.setColor(getColor());
		g.fillOval(getXCenter() - getRadius(), 
				   getYCenter() - getRadius(), 
				   getRadius()*2, 
				   getRadius()*2);
	}
	
	//plethora of setters and getters
	public void setXCenter(int x) { xCenter = x; }
	public void setYCenter(int y) { yCenter = y; }
	public void setRadius(int rad) { radius = rad; }
	public void setColor(Color col) { color = col; }
	public void setXMove(int xm) { xMove = xm; }
	public void setYMove(int ym) { yMove = ym; }
	
	public int getXCenter() { return xCenter; }
	public int getYCenter() { return yCenter; }
	public int getRadius() { return radius; }
	public Color getColor() { return color; }
	public int getXMove() { return xMove; }
	public int getYMove() { return yMove; }
	public int getPanelWidth() { return panelWidth; }
	public int getPanelHeight() { return panelHeight; }
}
