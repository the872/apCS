import java.awt.Image;
import java.awt.Rectangle;


public class LilyPad extends FroggerObject{

	public LilyPad(Rectangle b, int s) {
		super(b, s);
		// TODO Auto-generated constructor stub
	}

	private static Image lilypad = ImageLoader.loadImage("lillypad.png");
	private boolean reached = false;


	public void update(Frogger frog) 
	{

		if(frog.isTouching(getBounds()) && reached == false)
		{
			frog.getBounds().setBounds(getBounds());

			FroggerPanel.sharedInstance.reachedGoal();

			reached = true;
		}
		else if (frog.isTouching(getBounds())){
			FroggerPanel.sharedInstance.died();
				
		}
	}


	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean frogCanRide() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return lilypad;
	}

	@Override
	public boolean frogCantTouch() {
		// TODO Auto-generated method stub
		return false;
	}


}
