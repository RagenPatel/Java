
public class Compress {
	public static void main(String[] args){
		/*
		 * Run-length encoding (RLE) is a simple "compression algorithm" (an algorithm which takes
		 *  a block of data and reduces its size, producing a block that contains the same information
		 *   in less space). It works by replacing repetitive sequences of identical data items with 
		 *   short "tokens" that represent entire sequences. Applying RLE to a string involves finding 
		 *   sequences in the string where the same character repeats. Each such sequence should be 
		 *   replaced by a "token" consisting of:
		 *   1. the number of characters in the sequence 
		 *   2. the repeating character
		 *   
		 *   Write a program that takes a string as input, compresses it using RLE, and outputs the 
		 *   compressed string. Case matters - uppercase and lowercase characters should be considered 
		 *   distinct. You may assume that there are no digit characters in the input string. There 
		 *   are no other restrictions on the input - it may contain spaces or punctuation. There is no
		 *    need to treat non-letter characters any differently from letters.
		 */

		System.out.print("Enter a string to compress: ");
		String input = IO.readString();
		
		
		IO.outputStringAnswer(output(input));

	
	}

	public static String output(String input){
		String output="";
		char ch, chTemp;
		int count=1;

		if(input.length()==1){
			output = input;
			return output;
		}
		
		for(int k=0;k<1;k++){
			for(int i =1; i<input.length();i++){
				ch =input.charAt(i);
				chTemp = input.charAt(i-1);
				if(ch==chTemp){
					count++;
				}else{
					if(count==1){
						output+=chTemp;
					}else{
						output+=count;
						output+=chTemp;
					}

					count=1;
				}
				if(i==input.length()-1){
					if(count==1){
						output+=ch;
					}else{
						output+=count;
						output+=ch;
					}
				}
			}

		}
		
		return output;
	}
	
}

