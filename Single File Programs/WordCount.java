
public class WordCount {
	public static void main(String[] args){
		/*Write your code in the file WordCount.java. Write your test cases in assign4-testcases.txt.

			Write a program that takes a string containing a sentence or a set of sentences, and counts the number of 
			words in the sentence that meet or exceed a specified minimum length (in letters). For example, if the minimum 
			length entered is 4, your program should only count words that are at least 4 letters long.

			Input the string and the minimum word length (integer), in that order, and output the word count (integer). 
			Words will be separated by one or more spaces. Non-letter characters (spaces, punctuation, digits, etc.) 
			may be present, but should not count towards the length of words.

			Hint: write a method that counts the number of letters (and ignores punctuation) in a string that holds a 
			single word without spaces. In your main program, break the input string up into words and send each one 
			to your method.
		 */

		System.out.print("Enter a sentence: ");
		String input = IO.readString();

		System.out.print("Enter minimum word length: ");
		int length = IO.readInt();	


		if(count(input,length)==-1){
			System.out.println("ERROR! Length is ² 0!");
			IO.reportBadInput();
		}else{
			IO.outputIntAnswer(count(input,length));
		}
	}

	public static int count(String input, int length){
		int count =0, tempCount;
		char ch1, ch2;

		if(length<=0){
			return count = -1;
		}

		tempCount=0;
		for(int j = 0; j<input.length();j++){
			ch1=input.charAt(j);
			if(Character.isLetter(ch1)){
				tempCount++;
			}

			if(ch1==' '){
				if(tempCount>=length){
					count=1;
				}
				break;
			}else if(tempCount>=length){
				count=1;
			}
		}


		for(int i = 0; i<input.length();i++){
			tempCount=0;
			ch1=input.charAt(i);

			if(ch1==' '){
				for(int k = i+1;k<input.length();k++){
					ch2=input.charAt(k);
					if(ch2 ==' '){
						break;
					}else if(Character.isLetter(ch2)){
						tempCount++;
					}
				}
			}

			if(tempCount>=length){
				count++;
			}

		}

		return count;
	}

}
