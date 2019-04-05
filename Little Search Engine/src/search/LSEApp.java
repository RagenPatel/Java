package search;

import java.io.IOException;
import java.util.Scanner;

public class LSEApp {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		String input, noise = "noisewords.txt";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the name of the file => ");
		input = sc.nextLine();
		
		System.out.println("input: "+input);
		
		LittleSearchEngine l1 = new LittleSearchEngine();
		
		System.out.println("Enter word to search: ");
		String word = sc.nextLine();
		
		System.out.println("Enter another word to search for: ");
		String word2 = sc.nextLine();
		
		l1.makeIndex(input, noise);
		
		System.out.println("TO STRING: \n");
		l1.loadKeyWords(input).toString();
		
		l1.top5search(word, word2);
		
		String ans = l1.getKeyWord(word);
		
		// check if getKeyWord method is filtering out words or not
		//System.out.println("\n\n"+ans);
	
		
		
	}

}
