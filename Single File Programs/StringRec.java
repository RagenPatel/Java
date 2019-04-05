public class StringRec
{
	// DO NOT DECLARE ANY VARIABLES HERE
	// (you may declare local variables inside methods)
	
	public static String decompress(String compressedText)
	{
		
		String output="";
		char text;
		int count;
		
		if(compressedText.equals("")){
			return "";
		}
		
		text = compressedText.charAt(0);
		if(Character.isDigit(text)){
			output+=compressedText.charAt(1);
			count = text-'0';
			count--;
			compressedText=compressedText.substring(1);
			if(count>1){
				compressedText =count+compressedText;
			}
		}else{
			output+= compressedText.charAt(0);
			compressedText = compressedText.substring(1);
		}
		output+= decompress(compressedText);
		return output;
		
	}
	
}