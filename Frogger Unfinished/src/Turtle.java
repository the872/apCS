import java.awt.Image;
import java.awt.Rectangle;


public class Turtle extends FroggerObject{

	public Turtle(Rectangle b, int s) {
		super(b, s);
		// TODO Auto-generated constructor stub
	}

	
	private static Image turtle = ImageLoader.loadImage("turtle.png");
	
	private static Image newTurtle = ImageLoader.getFlippedImage(turtle);
	
	
	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean frogCanRide() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		if(getSpeed() > 0)
		{
		return turtle;
		}
		else
		{
			return newTurtle;
		}
	}

	@Override
	public boolean frogCantTouch() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
