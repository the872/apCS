import java.awt.Image;
import java.awt.Rectangle;

public class Water extends FroggerObject{

	public Water(Rectangle b, int s) {
		super(b, s);
		
	}
	
	public void update(Frogger frog) 
	{
		if(frog.centerIsIn(getBounds()))
		{
			frog.setCouldDrown(true);
		}
	}
	
	private static Image water = ImageLoader.loadImage("water.png");

	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean frogCanRide() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return water;
	}
	
	@Override
	public boolean frogCantTouch() {
		// TODO Auto-generated method stub
		return true;
	}
}
