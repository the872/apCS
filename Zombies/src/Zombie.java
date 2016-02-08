
public class Zombie {
	private int numHoursUndead;
	private int numBrainsEaten;

	public Zombie()
	{
		numHoursUndead = 0;
		numBrainsEaten = 0;
	}

	public void eatBrains(int brains)
	{
		numBrainsEaten += brains;
	}

	public void growl()
	{
		System.out.println("GRRRRRRRRR");
	}

	public int getNumberOfBrainsEaten()
	{
		return numBrainsEaten;
	}

	public int getNumberOfHoursUndead()
	{
		return numHoursUndead;
	}

	public void hoursPassed(int h)
	{
		numHoursUndead += h;
	}

	public boolean willDie()
	{
		if(numBrainsEaten < numHoursUndead)
			return true;
		else
			return false;
	}
}
