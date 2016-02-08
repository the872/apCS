
public class PLProcessor {

	//internal method for checking if the input String is a single lower case vowel
	//y is considered a consonant for the purposes of this program
	//preconditions: input is a String of length 1
	//Ex:
	//	"i" => true
	//	"E" => false
	//	"b" => false
	//	"y" => false
	//	"aeiou" => false

	public static boolean isVowel(String input) 
	{

		if(input.equals("a") || input.equals("A")){
			return true;
		}
		else if (input.equals("e") || input.equals("E")){
			return true;
		}
		else if (input.equals("i") || input.equals("I")){
			return true;
		}
		else if (input.equals("o") || input.equals("O")){
			return true;
		}
		else if (input.equals("u") || input.equals("U")){
			return true;
		}
		return false;
	}



	//Applies the vowel rule in the Pig Latin language to the word
	//Takes word and adds "-way" to the end
	//Ex: 	apple => apple-way
	//	  	ear => ear-way
	//precondition: word begins with a lower case vowel
	public static String vowelRule(String word) {

		if(word.isEmpty()){
			return "Error";
		}

		word = word + "-way";
		return word;
	}

	//Applies the qu rule in the Pig Latin language to the word
	//Takes the qu and moves it to the end with ay added
	//Ex: 	question => estion-quay
	//	  	quiet -> iet-quay
	//precondition: word begins with "qu"
	public static String quRule(String word) {

		if(word.isEmpty()){
			return "Error";
		}

		word = word.substring(2) + "-" + word.substring(0,2) + "ay";
		return word;

	}

	//Applies the consonant rule in the Pig Latin language to the word
	//Takes the consecutive consonants at the beginning of the word and moves it to end end, followed by an "ay"
	//Ex: 	fahrenbacher => ahrenbacher-fay
	//		brick => ick-bray
	//		string => ing-stray
	//precondition: word begins with a consonant and contains at least one vowel
	//precondition: word may not have more than three consecutive consonants at the beginning
	public static String consonantRule(String word) {

		if(word.isEmpty()){
			return "Error";
		}

		boolean result = isVowel(word.substring(0,1));
		boolean resultTwo = isVowel(word.substring(1,2));
		boolean resultThree = isVowel(word.substring(2,3));



		if(result == false && resultTwo == true){
			word = word.substring(1) + "-" + word.substring(0,1) + "ay";
		}
		if(result == false && resultTwo == false && resultThree == true){
			word = word.substring(2) + "-" + word.substring(0,2) + "ay";
		}
		if(result == false && resultTwo == false && resultThree == false){
			word = word.substring(3) + "-" + word.substring(0,3) + "ay";
		}
		return word;
	}


	//Takes an input word and translates it into pig latin
	//precondition: word only contains lower case letters without any space or punctuation
	//precondition: word must have a length of at least 1
	public static String fullTranslation(String word) {

		if(word.isEmpty()){
			return "Error";
		}
		boolean vowel = isVowel(word);
		String vowelRule = vowelRule(word);
		String stringQuRule = quRule(word);
		String consonantRule = consonantRule(word);

		if(vowel == true){
			word = vowelRule(word);
		}
		else if(word.substring(0,2).equals("qu")){
			word = quRule(word);
		}
		else{
			word = consonantRule(word);
		}


		return word;
	}

}

/*EXTRAS:
 * 
 * 1) Make your program handle words with internal qu's: "squirrel" => irrel-squay
 * 2) Make your program interpret y's as vowels when appropriate:
 * 		"why" => y-whay
 * 		"yellow" => ellow-yay
 * 3) Make your program not generate red error, messages when a user:
 * 		- enters in a 0 length word (no letters)
 * 		- something without a vowel ("t", "PR", etc)
 * */


