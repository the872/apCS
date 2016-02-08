
public class Histogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] array = new int[11];
		int total = 0;
		
		for(int i = 0; i < 1000000; i++)
		{
			int rollOne = (int)(Math.random()*6+1);
			int rollTwo = (int)(Math.random()*6+1);
			
			array[rollOne + rollTwo - 2] +=1; 
			
			total += 1;
		}
		for(int x = 0; x < array.length; x++)
		{
			System.out.println("The number " + (x+2) + " was rolled " + array[x] + " times.");
		}
		
	}

}
