
public class NestedLoops {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
{
	for(int column10 = 1; column10 <= 4; column10++)
	{
		System.out.println();
		for(int number10 = column10; number10 <= 8 - column10; number10++)
			System.out.print(number10 + "\t");
	}
}
}