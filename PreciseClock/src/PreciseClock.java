
public class PreciseClock extends Clock {

	private int seconds;

	public PreciseClock()
	{
		super();
	}

	public PreciseClock(int h, int m)
	{
		super(h,m);
		int s = seconds;
	}

	public PreciseClock(int h, int m, int s)
	{
		super(h, m);
		seconds = s;	
	}

	public void setSeconds(int s)
	{
		seconds = s;
	}

	public String toString()
	{
		String res = super.toString();
		if(seconds < 10)
		{
			return res + ".0" + seconds;
		}
		else
		{
			return getHours() + ":" + getMinutes();
		}
	}
}



