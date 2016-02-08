public class AidPlayer implements Player
{
	private int bankedScore; //how many score the player has saved
	private int unBankedScore; //how many score the player has earned in the current round

	//creats a GutsPlater with no score
	public AidPlayer()
	{
		unBankedScore = 0;

	}

	//returns the name of the player - you should change this!
	public String getName()
	{
		return "AidPlayer";
	}

	//called to tell the player that a new game has just begun - should zero out the score
	public void newGame()
	{
		bankedScore=0;
		unBankedScore=0;
	}

	//tells the player to bank their unbanked score (essentially relinquishing their turn)
	//
	//For example, if before this method the player has 10 banked score and 20 unbanked score,
	//then after this method the player will have 30 banked score and 0 unbanked score
	public void bankScore()
	{
		bankedScore+= unBankedScore;
	}

	//updates the players score based on the values in dieOneVal and dieTwoVal
	//When both values are a 6, then the player loses all banked and unbanked score
	//When only one of the values is a 6, then the player only loses the unbanked score
	//When neither of the values is a 6, then the player's unbanked score is increased by the sum of the two values
	public void updateScore(int dieOneVal, int dieTwoVal)
	{
		if(dieOneVal == 6 && dieTwoVal == 6)
		{
			bankedScore=0;
			unBankedScore=0;
		}
		else if(dieOneVal == 6 || dieTwoVal == 6)
		{
			unBankedScore=0;
		}
		else
		{
			unBankedScore = dieOneVal + dieTwoVal;
		}
	}

	//determines if a player should lose their turn - this occurs if either value is a 6
	public boolean shouldLoseTurn(int dieOneVal, int dieTwoVal)
	{
		if(dieOneVal == 6 || dieTwoVal == 6)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	//returns the player's current banked score
	public int getBankedScore() {
		return bankedScore;
	}

	//returns the player's current unbanked score
	public int getUnbankedScore() {
		return unBankedScore;
	}

	//prints info about the player, including banked and unbanked score
	public void printInfo() 
	{
		System.out.println("Your banked score is " + bankedScore + " and your unbanked score is " + unBankedScore + ".");
	}

	//asks the player if they want to play again or not
	//should NOT change bankedScore or unBankedScore
	public boolean shouldRollAgain(int otherPlayersscore)
	{
		if(unBankedScore < 7){
			if(otherPlayersscore + 7 < (bankedScore))
			{
				return false;	
			}
			else if(otherPlayersscore + 7 < (unBankedScore + bankedScore))
			{
				return false;	
			}
		}
		return true;
	}
}