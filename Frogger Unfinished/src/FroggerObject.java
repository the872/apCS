import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;


public abstract class FroggerObject 
{	
	private int speed; //how far the FroggerObject moves every update
	private Rectangle bounds; //the Rectangle that specifies where the Object appears on the screen

	public FroggerObject(Rectangle b, int s) {
		bounds = b;
		speed = s;
	}

	//updates the FroggerObject - the Frog is passed as a parameter in case
	//the Object needs to manipulate the Frog in some way
	public void update(Frogger frog) 
	{
		if(canMove() == true)
		{
			bounds.x+=speed;
		}
		
		if(frogCanRide() == true && frog.centerIsIn(getBounds()))
		{
			frog.getBounds().x+=speed;
			frog.setCouldDrown(false);
		}
		
		if(frogCantTouch() == true && frog.centerIsIn(getBounds()))
		{
			FroggerPanel.sharedInstance.died();
		}
	}

	//wraps Objects around the screen, based on the direction of movement
	public void handleWrapping(int screenWidth) 
	{
		if(speed < 0)
		{
			if(bounds.x < 0 - bounds.width)
			{
				bounds.x = screenWidth + bounds.width;
			}
		}
		else
		{
			if(bounds.x > screenWidth + bounds.width)
			{
				bounds.x = 0 - bounds.width;
			}
		}
	}

	//returns the speed of the Object
	public int getSpeed() {
		return speed;
	}

	//returns the position and dimensions of the Object on the screen
	public Rectangle getBounds() {
		return bounds;
	}
	
	//draws the Object
	public void draw(Graphics g) {
		g.drawImage(getImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
	}

	//returns whether the Object is allowed to move
	public abstract boolean canMove();

	//returns whether the Frog can ride this object
	public abstract boolean frogCanRide();

	//returns the image that represents this Object
	public abstract Image getImage();

	//returns whether the frog is not allowed to touch this Object
	public abstract boolean frogCantTouch();
}