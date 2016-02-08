import java.awt.Image;
import java.awt.Rectangle;


public  class Car extends FroggerObject{

	

	public Car(Rectangle b, int s) {
		super(b, s);
		// TODO Auto-generated constructor stub
	}

	private static Image car = ImageLoader.loadImage("car.png");
	private static Image newCar = ImageLoader.getFlippedImage(car);
	
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
		return car;
		}
		else
		{
			return newCar;
		}
	}

	@Override
	public boolean frogCantTouch() {
		// TODO Auto-generated method stub
		return true;
	}

}
