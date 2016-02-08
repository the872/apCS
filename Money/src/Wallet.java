/*Finish the design of a Wallet class.  
 * A Wallet has two properties - an amount 
 * of dollars and an amount of cents (these 
 * should be stored separately).  There are 
 * two ways to make a Wallet - you can buy a 
 * new one from the store that has no money 
 * it, or you can get a hand-me-down that 
 * already has a specified amount of money 
 * that the previous owner forgot to take 
 * out.  You should be able to put money 
 * into the Wallet and remove money as well 
 * (beware of special cases! cents should always 
 * be between 0 and 99). If you attempt to remove 
 * more money than is available in the Wallet, 
 * then all the money is removed.  A Wallet can 
 * be asked for how much total money in cents is 
 * in the Wallet ($1.23 -> 123).  A Wallet can 
 * also be told to print out its pertinent information.
 */

public class Wallet
{
	private int dollars;
	private int cents;

	public Wallet()
	{
		dollars = 0;
		cents = 0;	
	}

	public void storeMoney(int storeDollars, int storeCents)
	{
		dollars += storeDollars;
		if(storeCents > 99)
		{
			cents += storeCents % 100;
			dollars += storeCents / 100;
		}
		else
			cents += storeCents;
	}

	public void takeMoney(int takeDollars, int takeCents)
	{
		if(dollars <= takeDollars)
		{
			dollars = 0;
			cents = 0;
		}
		else if(cents < takeCents)
		{
			dollars--;
			cents = takeCents - cents;
		}
		else
		{
			dollars -= takeDollars;
			cents -= takeCents;
		
		}
	}

	public void displayMoney()
	{
		if(cents > 10){
			System.out.println("$" + dollars + "." + cents);
		}
		else{
			System.out.println("$" + dollars + "." + cents + "0");
		}
	}

}