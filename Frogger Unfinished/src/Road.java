import java.awt.Image;
import java.awt.Rectangle;


public class Road extends FroggerObject{


	public Road(Rectangle b, int s) {
		super(b, s);
		// TODO Auto-generated constructor stub
	}

	private static Image road = ImageLoader.loadImage("road.png");
	
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
		return road;
	}

	@Override
	public boolean frogCantTouch() {
		// TODO Auto-generated method stub
		return false;
	}

}
