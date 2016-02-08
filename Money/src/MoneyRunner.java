public class MoneyRunner
{
	public static void main(String[] args)
	{
		//create a Wallet with no money //1
		Wallet fresh = new Wallet();
		
		//make a second Wallet with $50.63 //2
		Wallet handDown = new Wallet();
		handDown.storeMoney(50, 63);
		
		//print out the info for both Wallet's
		fresh.displayMoney();
		handDown.displayMoney();
		
		//add $5 to the first Wallet //3 
		fresh.storeMoney(5, 0);
		
		//print out the info for the first Wallet
		fresh.displayMoney();
		
		//remove $7 from the first Wallet (only $5 should actually be removed...) //4 
		fresh.takeMoney(7, 0);
		
		//print out the info for the first Wallet
		fresh.displayMoney();
		
		//add 2.50 to the second Wallet //5 
		handDown.storeMoney(2, 50);
		
		//print out the info for the second Wallet
		handDown.displayMoney();
		
		//remove 3.75 from the second Wallet //6
		handDown.takeMoney(3, 75);
		
		//print out the info for the second Wallet
		handDown.displayMoney();
	}
}