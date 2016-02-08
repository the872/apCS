import java.awt.Image;
import java.awt.Rectangle;


public class Grass extends FroggerObject{

	
	public Grass(Rectangle b, int s) {
		super(b, s);
		// TODO Auto-generated constructor stub
	}

	private static Image grass = ImageLoader.loadImage("grass.png");

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
		return grass;
	}

	@Override
	public boolean frogCantTouch() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
