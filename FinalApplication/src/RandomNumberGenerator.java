//Name: Aid Idrizovic

public class RandomNumberGenerator
{
	private int low, high;

	public RandomNumberGenerator(int l, int h)
	{
		low = l;
		high = h;
	}

	//Generates 5 random numbers between low and high (inclusively)
	//Prints out the 5 numbers, separated by commas, on the SAME line
	//Also prints the sum of the 5 numbers
	//Returns the sum of the 5 numbers as well
	//
	//For example, if low was 5 and high was 16, then the output could be
	//  10, 11, 6, 16, 12, 55
	//And the method would return 55
	public int fiveRandomNums()
	{
		int difference = high - low;
		int answer = 0;
		int total = 0; 
		int num = 0;

		while(num < 5){
			answer = (int)(Math.random() *difference)+low;
			System.out.print(answer + ", ");
			total += answer;
			num++;	
		}
		System.out.println(total);
		
		return total;

	}
	
	
}