public class LoopsPractice {

	public static void main(String[] args) {
		int store = productFinder();
		System.out.println(store);

	}

	public static void printOddIntegersUpTo(int m)
	{
		int num = 1;
		while(num <= m)
		{
			System.out.print(num + " ");
			num +=2;
		}
		System.out.println();
	}

	public static void printMultiplesOfThree(int n)
	{
		int num = 300;
		while(num <= 300 && num >= 3)
		{

			System.out.print(num + " ");
			num -=3;
		}
		System.out.println();
	}



	public static void highLow()
	{
		int low = 0;
		int num = low;
		int high = 50;
		while(num != high)
		{
			if(num % 4 == 0)
			{
				if(num % 5 != 0)
				{
					System.out.print(num + " ");
				}
			}
			num ++;
		}
		System.out.println();
	}

	public static void factors(int n)
	{
		int num = 0;
		while(num <= Math.abs(n))
		{
			num ++;
			if(n == 0)
				System.out.print("Everything!");
			else if(n % num == 0)
				System.out.print(num + " ");

		}

	}
	public static int factorSum(int n)
	{
		int num = 0;
		int sumOfFactor = 0;
		while(num <= n)
		{
			num ++;
			if(n % num == 0)
			{
				sumOfFactor += num;
			}	
		}
		System.out.println();
		return sumOfFactor;
	}

	public static int factorial(int n)
	{

		int s = 1;
		int num = 1;
		int num2 = 2;
		if(n == 0)
			return 1;
		if(n < 0)
			return -1;
		else
		{
			while(s != n)
			{
				num =num * num2;
				num2++;
				s ++;
			}
			System.out.println();
			return num;
		}
	}

	public static int productFinder()
	{
		int total = 1;

		while(true){
			int choice = Prompter.promptForInteger("Please enter some numbers.");

			if(choice == 0){
				break;
			}

			total *=choice;

			choice--;
		}
		return total;
	}
}