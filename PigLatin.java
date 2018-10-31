
public class PigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Write your code in the file PigLatin.java. Write your test cases in assign4-testcases.txt.

		"Pig Latin" is a fake language used as a children's game. A word in English is "translated" into Pig Latin using the 
		following rules:
		
		If the English word begins with a consonant, move the consonant to the end of the word and add "ay". The letter Y 
		should be considered a consonant.
		If the English word begins with a vowel (A, E, I, O, or U), simply add "way" to the end of the word.
		(This is a simplified dialect of Pig Latin, of course.)
		
		Ask the user for a word (one string) and output its Pig Latin translation (one string). You may assume that the 
		input does not contain digits, punctuation, or spaces. The input may be in any combination of uppercase or lowercase. 
		The case of your output does not matter. Use IO.outputStringAnswer() to output.

		 */

		System.out.print("Enter a string to convert: ");
		String input = IO.readString();
		String output = "";
		
		char ch = input.charAt(0);
		ch=Character.toLowerCase(ch);
		
		//System.out.println(ch);
		
		for(int i = 0; i<input.length();i++){
			if(!Character.isLetter(input.charAt(i))){
				IO.reportBadInput();
				System.out.println("Not a valid input.");
				System.exit(0);
			}
		}
	
		if(ch =='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
			output = input+"way";
			
			//System.out.println(output);
			
			IO.outputStringAnswer(output);
		} else{
			output=input.substring(1)+ch+"ay";
			
			//System.out.println(output);
			
			IO.outputStringAnswer(output);
		}
		

	}

}
