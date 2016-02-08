//represents a Die - needs to be completed

public class Die
{
    private int faceValue;
    
	//creates a Die
	public Die()
	{
        roll();
	}
	
	//rolls the Die - changes the face value to be a random
    //value between 1 and 6
	public void roll()
	{
		int roll = (int) ((Math.random()*6)+1);
		faceValue = roll;
	}
	
	//returns the face value of the Die
	public int getFaceValue()
	{
		return faceValue;
	}
}