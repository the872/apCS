public interface Player
{
	String getName();
	void newGame();
	boolean shouldRollAgain(int otherPlayersScore);
	void bankScore();
    
	void updateScore(int dieOneVal, int dieTwoVal);
    boolean shouldLoseTurn(int dieOneVal, int dieTwoVal);
	
	int getBankedScore();
	int getUnbankedScore();
    void printInfo();
}