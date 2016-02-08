import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;


public class Frogger {

	private Rectangle bounds;
	private static Image green = ImageLoader.loadImage("frog.png");
	private static Image blue = ImageLoader.loadImage("bluefrog.png");
	private static Image red = ImageLoader.loadImage("redfrog.png");
	private boolean couldDrown;

	private int moveDir = -1; 	//indicates the direction the Frog is moving in
	//0 -> East, 90 -> North, 180 -> West, 270 -> South
	//-1 means the Frog is not moving

	private int stepsLeftInMove;	//how many more updates it will take for the Frog to complete a move


	public Frogger(Rectangle b) {
		bounds = b;
	}

	//asks the Frog for the Rectangle that defines where the Frog is on the screen
	public Rectangle getBounds() {
		return bounds;
	}

	//moves the Frog in its current movement direction, or
	//does nothing if the Frog is not moving
	public void update() {
		if(stepsLeftInMove > 0){
			if( moveDir == 0){
				bounds.y-=10; 
			}
			else if( moveDir == 90){
				bounds.x+=10;
			}
			else if( moveDir == 180){
				bounds.y+=10;
			}
			else if( moveDir == 270){
				bounds.x-=10;
			}
		}
		stepsLeftInMove--;


	}

	//sets the move direction of the Frog
	//if the Frog is in the middle of a move, this method does nothing
	public void setMoveDirection(int d)
	{
		moveDir = d;
		stepsLeftInMove = 4;
	}

	//draws the picture of the Frog, scaling to match the bounds rectangle
	public void draw(Graphics g)
	{
		AffineTransform oldTrans = ((Graphics2D) g).getTransform();
		AffineTransform trans = new AffineTransform();
		trans.rotate(Math.toRadians(moveDir), bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
		((Graphics2D) g).setTransform(trans);
		g.drawImage(FroggerPanel.frogColor(), bounds.x, bounds.y, bounds.width, bounds.height, null);
		((Graphics2D) g).setTransform(oldTrans);
	}

	//returns true if the Frog is at least partially inside the rectangle
	public boolean isTouching(Rectangle rect) {
		return bounds.intersects(rect);
	}

	//returns true if the center of the Frog is inside the rectangle
	public boolean centerIsIn(Rectangle rect) {
		return rect.contains(new Point(bounds.x+bounds.width/2, bounds.y+bounds.height/2));
	}

	//returns true if the Frog is completely inside the rectangle
	public boolean isInside(Rectangle rect) {
		return rect.contains(bounds);
	}

	//returns if the frog is in danger of drowning (meaning its over the water)
	public boolean couldDrown() {
		return couldDrown;
	}

	//tells the Frog that it is in danger of drowning
	public void setCouldDrown(boolean drown) {
		couldDrown = drown;
	}

	//fixes the position of the Frog so that it does not leave the screen
	//width and height are the width and height of the game area
	public void keepOnScreen(int width, int height) 
	{
		if(bounds.x > width - 40)
		{
			bounds.x = width -40;
		}
		if(bounds.x < 0)
		{
			bounds.x = 0;
		}
		if(bounds.y < 0)
		{
			bounds.y = 0;
		}
		if(bounds.y > height - 40)
		{
			bounds.y = height - 40;
		}
	}
}
