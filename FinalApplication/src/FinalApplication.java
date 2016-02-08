/**
 *
 * Purpose: Randomness Testing
 * Scoring: Half for finishing fiveRandomNums() method correctly in RandomNumberGenerator
 *          Half for finishing main method correctly
 *
 *
 * Name: Aid Idrizovic
 *
 */


public class FinalApplication
{

	public static void main(String[] args)
	{
		//creates a random number generator for numbers between 1 and 6
		RandomNumberGenerator gen = new RandomNumberGenerator(1, 6);
		//creates a random number generator for numbers between -10 and 15
		RandomNumberGenerator gen2 = new RandomNumberGenerator(-10, 15);

		//generates 1 set of random numbers
		gen.fiveRandomNums();

		//generates 12 set of random numbers
		int one = gen2.fiveRandomNums();
		int two = gen2.fiveRandomNums();
		int three = gen2.fiveRandomNums();
		int four = gen2.fiveRandomNums();
		int five = gen2.fiveRandomNums();
		int six = gen2.fiveRandomNums();
		int seven = gen2.fiveRandomNums();
		int eight = gen2.fiveRandomNums();
		int nine = gen2.fiveRandomNums();
		int ten = gen2.fiveRandomNums();
		int eleven = gen2.fiveRandomNums();
		int twelve = gen2.fiveRandomNums();

		//this was my attempt to get the biggest number. I didn't think it would be best to
		//make if statements for each one
		
		int biggest = 0;
		
		for(int i = 0; i< 12; i++)
		{
			if(one > biggest)
			{
				biggest = one;
			}
			System.out.print(biggest);
		}
	}


}
