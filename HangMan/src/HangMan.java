import java.util.*;

public class HangMan
{
	private ArrayList<String> letters; //List of individual letters in a word to guess
	private ArrayList<Boolean> correct; //holds whether the user has guessed individual letters correctly or not
	private int strikesLeft; //how many strikes the user has left


	//creates a game of HangMan where wordToGuess holds the String that the player needs to guess
	public HangMan(String wordToGuess) 
	{

		strikesLeft = wordToGuess.length();

		letters = new ArrayList<String>();

		String word = wordToGuess;

		for(int x = 0; x < word.length(); x ++)
		{
			letters.add(word.substring(x, x +1));
		}


		correct = new ArrayList<Boolean>();

		for(int x = 0; x < word.length(); x++)
		{
			correct.add(false);
		}

		int numLetters = letters.size();

		//1. create the two ArrayList's letters and correct.
		//2. Fill the letters ArrayList with each of the one letter substrings from wordToGuess
		//3. Fill the correct ArrayList with false - the number of falses should match the length of wordToGuess


	}


	//User guesses that an individual letter is in the word
	//correct should be updated with true values for every matching letter
	//strikesLeft should be decremented if the guess does not match any letters
	//returns true if you guessed correctly, false otherwise
	//
	//Recall - to check if two String's are equal, you use .equals(), not ==
	//For example:
	//  if(a.equals(b)) {
	//  }
	//
	//Not:
	//  if(a == b) {
	//  }
	public boolean guess(String letter) 
	{

		boolean guessCorrect = false; 

		for(int x = 0; x < letters.size(); x ++)
		{
			if(letter.equals(letters.get(x)))
			{
				if(correct.get(x) != true){
					correct.set(x, true);
					guessCorrect = true;
				}
			}
		} 

		strikesLeft --;
		return guessCorrect;
	}


	//this method should return how much of the String the user has guessed so far, leaving ? marks
	//for letters the user has not yet guessed
	//
	//For example:
	// letters = {"A", "N", "G", "R", "Y"}
	// correct:{false, true, false, true, true}
	//
	//In this case, the method should return ?N?RY
	public String getWordSoFar() 
	{
		String word = "";

		for(int x = 0; x < letters.size(); x++){

			if(correct.get(x))
			{
				word += letters.get(x);
			}
			else
			{
				word += "?";
			}
		}

		return word;
	}


	//returns whether the word has been totally guessed
	public boolean didWin() 
	{
		for(int x = 0; x < correct.size(); x++){
			if(correct.get(x) == false)
			{
				return false;
			}
		}
		return true;
	}


	//returns whether the player has ran our of strikes without correctly guessing the word
	public boolean didLose() 
	{
		if(strikesLeft == 0)
		{
			return true;
		}
		return false; 
	}
}