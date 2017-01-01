
public class VandC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//vowel and consonants
		
		System.out.print("Enter sentence: ");
		String str=IO.readString();
		
		int numVowels=0,numConsonants=0;
		
		for(int i=0;i<str.length();i++){ //scan characters of string
			char ch=str.charAt(i);
			
			if(!Character.isLetter(ch)){
				continue;  // skip over rest of the stuff in the loop, and go to the next iteration
			}
			
			ch=Character.toLowerCase(ch);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
				numVowels++;
			}else{
				numConsonants++;
			}
		}
		
		System.out.println("number of vowels is = "+numVowels);
		System.out.println("Number of consonanats is = "+numConsonants);
		
	}

}
