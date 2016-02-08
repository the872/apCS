import java.awt.Image;
import java.awt.Rectangle;


public class Truck extends FroggerObject{

	public Truck(Rectangle b, int s) {
		super(b, s);
		// TODO Auto-generated constructor stub
	}
	
	private static Image truck = ImageLoader.loadImage("truck.png");
	private static Image newTruck = ImageLoader.getFlippedImage(truck);

	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean frogCanRide() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		if(getSpeed() < 0)
		{
		return truck;
		}
		else
		{
			return newTruck;
		}
	}

	@Override
	public boolean frogCantTouch() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
