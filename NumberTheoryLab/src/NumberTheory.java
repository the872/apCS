public class NumberTheory
{
	//Test your methods in here!
	public static void main(String[] args)
	{
		isPerfect(6);

		//To test the isPrime method...
		//boolean answer = isPrime(97);
		//System.out.println("97 is prime " + answer);
	}

	//Warm Up Problems
	//W1: Use a for-loop to print the integers from 1 to 1 million
	public static void printMillionNumbers()
	{
		for(int value = 1; value <= 1000; value ++)
        	System.out.print(value + " ");
        System.out.println();
	}

	//W2: Use a for-loop to print the first 10 perfect squares: 0, 1, 4, 9, ..., 81
	public static void printFirstTenPerfectSquares()
	{
		for(int num = 0; num < 10; num++)
    		System.out.print(num * num + " ");
    	System.out.println();
	}

	//W3: Use a for-loop to print all the factors of n - you may assume
	//that is is positive.  This is the same as Loops Practice, but with a for
	public static void printFactors(int n)
	{
		for(int num = 1; num <= n; num++)
			if(n % num == 0)
        		System.out.print(num + " ");
		System.out.println();

	}
	//REAL Problems
	//R1: This method determines if a number is prime
	//A number is prime if it is greater than 1 and it has no factors other than 1 and itself
	//Ex:   7 is a prime because its only factors are 1 and 7
	//      9 is not a prime because it has 3 as a factor
	//      -2 is not a prime because it is not greater than 1
	public static boolean isPrime(int n)
	{
		boolean answer = true;
    	if(n < 2);
    		answer = false;
    	for(int num = 1; num <= n; num++)
    	{
    		if(n >= 2)
			{
				if(n % num == 0)
				{
					if(num != 1)
					{
						if(num != n)
							answer = false;
					}
						
					else
						answer = true;
				}
				
			}
    	}
    	
    	return answer;
	}


	//R2: This method determines if a number is perfect
	//A number is said to be perfect if the sum of a number's proper factors
	//(factors < n) is equal to the number.  For example:
	//Proper factors of 6 are 1, 2, 3, and their sum is 6 (perfect)
	//Proper factors of 12 are 1, 2, 3, 4, 6 and their sum is 16 (not perfect)
	public static boolean isPerfect(int n)
	{
		int x = 0;
    	for(int num = 1; num < n; num ++)
    	{
    		if(n % num == 0)
    			x += num;
    		
    	}
    	
    	if(x == n)
    		return true;
    	else
    		return false;
	}


	//R3: This method finds the biggest positive integer that is both a factor of a and b
	//Some situations to worry about:
	//- what if either of them is 0?
	//- what if one or both of them is negauve?
	//
	//Ex's:     gcf(10, 12) => 2
	//          gcf(18, 9) => 9
	//          gcf(3, 0) => 3
	//          gcf(0, 0) => 2,147,483,647 (the biggest integer allowed in Java!
	//          gcf(-12, 16) => 4
	//          gcf(-5, -10) => 5
	public static int gcf(int a, int b)
	{
		int factor1 = 0;
    	int factor2 = 0;
    	int GCF = 0;
    	if(a == 0 && b == 0)
			return 2147483647;
		else if(a == 0 || b == 0)
			return Math.max(Math.abs(a), Math.abs(b));
    	for(int num = 1; num <= Math.min(Math.abs(a), Math.abs(b)); num++)
    	{
    			if(a % num == 0)
    				factor1 = num;
    			if(b % num == 0)
    				factor2 = num;
    			if(factor1 == factor2)
    				GCF = factor1;	
    	}
    	return GCF;
	}


	//CHALLENGE - prints first n primes... you might want to use the isPrime method
	public static void printNPrimes(int n)
	{

	}

	//CHALLENGE #2 - Golbach's conjecture claims that every even number greater than 2 is the sum of 2 primes
	//Ex:   4 = 2 + 2
	//      6 = 3 + 3
	//      8 = 3 + 5
	//      10 = 3 + 7 (also 5 + 5 works)
	//This method prints two primes that add up to n; should display an error if n is odd or less than 4
	public static void golbachsConjecture(int n)
	{

	}
}