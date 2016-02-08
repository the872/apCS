//This class represents a Cartesian Coordinate Pair where both values are integers
public class Coordinate
{
	private int x, y; //(x, y)
	
	public Coordinate() {
		x = 0;
		y = 0;
	}
	
	public Coordinate(int theX, int theY)
	{
		x = theX;
		y = theY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}