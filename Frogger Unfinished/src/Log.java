import java.awt.Image;
import java.awt.Rectangle;


public class Log extends FroggerObject{

	public Log(Rectangle b, int s) {
		super(b, s);
		// TODO Auto-generated constructor stub
	}
	
	private static Image log = ImageLoader.loadImage("log.png");

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
		return log;
	}

	@Override
	public boolean frogCantTouch() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
