public class NumberCubeRunner
{
	public static void main(String[] args)
	{
		int[] result = getCubeTosses(new NumberCube(), 10);
		int run = getLongestRun(result);

		System.out.print("The array of tosses was: ");
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");

		System.out.println("\nAnd the longest run began at index " + run);
	}



	/* #1

	 Write the method getCubeTosses that takes a number cube and a number of tosses as parameters. 
	 The method should return an array of the values produced by tossing the number cube the given number of times.
	 */

	/** Returns an array of the values obtained by tossing a number cube numTosses times. 
	 * @param cube a NumberCube 
	 * @param numTosses the number of tosses to be recorded 
	 *		Precondition: numTosses > 0
	 * @return an array of numTosses values
	 */
	public static int[] getCubeTosses(NumberCube cube, int numTosses)
	{

		int[] array = new int[numTosses];
		for(int x = 0;x < numTosses; x++)
		{
			array [x] = cube.toss(); 
		}
		return array;
	}




	/* #2

	 Write the method getLongestRun that takes as its parameter an array of integer values representing a series of number cube tosses. 
	 The method returns the starting index in the array of a run of maximum size. 
	 A run is defined as the repeated occurrence of the same value in two or more consecutive positions in the array.
	 For example, the following array contains two runs of length 4, one starting at index 6 and another starting at index 14. 
	 The method may return either of those starting indexes.

	 Indexes:	 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17
	 Values:	[1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5]

	 If there are no runs of any value, the method returns -1.
	 */


	/** Returns the starting index of a longest run of two or more consecutive repeated values
	 * in the array values.
	 * @param values an array of integer values representing a series of number cube tosses
	 *		Precondition: values.length > 0
	 * @return the starting index of a run of maximum size;
	 *		-1 if there is no run
	 */

	public static int getLongestRun(int[] values)
	{
		int currRunLenght = 1;
		int maxRun = 1;
		int posOfMaxRun = 0;
		int currPos = 0;

		for(currPos = 0; currPos < values.length - 1; currPos++)
		{
			if(values[currPos + 1] == values[currPos])
			{
				currRunLenght++;
			}
			if( currRunLenght > maxRun)
			{
				maxRun = currRunLenght;
				posOfMaxRun = currPos;
			}
		}
		if(maxRun == 1)
		{
			return -1;
		}
		return posOfMaxRun;
	}
}