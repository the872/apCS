public class GutsTester
{	
	public static void main(String[] args)
	{		
		//This is one of the players in the game
		AidPlayer playerOne = new AidPlayer();

		//This is the other player in the game
		AidPlayer playerTwo = new AidPlayer();

		//these are the two dice in the game
		Die one = new Die();
		Die two = new Die();

		//variable that keeps track of which player is currently in control of the game
		//when currentTurn is 1, playerOne has the dice.  when currentTUrn is 2, playerTwo has the dice
		int currentTurn = 1;


		/*BEGIN GAME LOGIC*/
		while(playerOne.getBankedScore() < 100 && playerTwo.getBankedScore() < 100)
		{
			if(currentTurn == 1)
			{
				playerOne.shouldRollAgain(currentTurn);
				playerOne.getUnbankedScore();
				sleep(1000);
				if(playerOne.shouldRollAgain(currentTurn) == true)
				{
					one.roll();
					two.roll();
					int dieOne = one.getFaceValue();
					int dieTwo = two.getFaceValue();
					playerOne.updateScore(dieOne, dieTwo);
					playerOne.shouldLoseTurn(dieOne, dieTwo);
					if(playerOne.shouldLoseTurn(dieOne, dieTwo) == true)
					{
						System.out.println("Sorry, You lost your turn.");
						sleep(1000);
						currentTurn = 2;
					}
					else
					{
						playerOne.getBankedScore();
						sleep(1000);
					}
				}
				else
				{
					playerOne.bankScore();
					currentTurn = 2;
				}
			}

			if(currentTurn == 2)
			{
				playerTwo.shouldRollAgain(currentTurn);
				playerTwo.getUnbankedScore();
				sleep(1000);
				if(playerTwo.shouldRollAgain(currentTurn) == true){
					one.roll();
					two.roll();
					int dieOne = one.getFaceValue();
					int dieTwo = two.getFaceValue();
					playerTwo.updateScore(dieOne, dieTwo);
					playerTwo.shouldLoseTurn(dieOne, dieTwo);
					if(playerTwo.shouldLoseTurn(dieOne, dieTwo) == true)
					{
						System.out.println("Sorry, You lost your turn.");
						sleep(1000);
						currentTurn = 1;
					}
					else
					{
						playerTwo.getBankedScore();
						sleep(1000);
					}
				}
				else
				{
					playerTwo.bankScore();
					currentTurn = 1;
				}
			}
			
			if(playerOne.getBankedScore() == 100 || playerTwo.getBankedScore() == 100)
					{
				if(playerOne.getBankedScore() == 100){
					System.out.println("Player One Wins!");
				}
				else
				{
					System.out.println("Player Two Wins");
				}
					}
		}
		/*END GAME LOGIC*/
	}


	//pauses the program for t milliseconds
	//can be used to make it so the program doesn't output information too fast
	public static void sleep(int t)
	{
		try
		{
			Thread.sleep(t);
		}
		catch(Exception e)
		{
		}
	}
}