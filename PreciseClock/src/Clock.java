public class Clock
{
	private int hours;
	private int minutes;
	
	public Clock() {
		hours = 0;
		minutes = 0;
	}
	
	public Clock(int h, int m) {
		hours = h;
		minutes = m;
	}
	
	public void setHours(int h) {
		hours = h;
	}
	
	public void setMinutes(int m) {
		minutes = m;
	}
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public String toString() {
		if(minutes < 10)
			return hours + ":0" + minutes;
		else 
			return hours + ":" + minutes;

	}
}