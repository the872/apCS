public class Locker
{
	private int id;
	private boolean open;
	private int toggles;

	public Locker(int i)
	{
		id = i;
		open = false;
		toggles = 0;
	}

	public int getID() 
	{
		return id;
	}

	public boolean isOpen() 
	{
		return open;
	}

	public int numberTimesToggled() 
	{
		return toggles;
	}

	public void toggle()
	{
		open = !open;
		toggles ++;
	}


}



