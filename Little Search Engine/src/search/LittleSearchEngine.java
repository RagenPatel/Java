package search;

import java.io.*;
import java.util.*;

/**
 * This class encapsulates an occurrence of a keyword in a document. It stores the
 * document name, and the frequency of occurrence in that document. Occurrences are
 * associated with keywords in an index hash table.
 * 
 * @author Sesh Venugopal
 * 
 */
class Occurrence {
	/**
	 * Document in which a keyword occurs.
	 */
	String document;

	/**
	 * The frequency (number of times) the keyword occurs in the above document.
	 */
	int frequency;

	/**
	 * Initializes this occurrence with the given document,frequency pair.
	 * 
	 * @param doc Document name
	 * @param freq Frequency
	 */
	public Occurrence(String doc, int freq) {
		document = doc;
		frequency = freq;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + document + "," + frequency + ")";
	}
}

/**
 * This class builds an index of keywords. Each keyword maps to a set of documents in
 * which it occurs, with frequency of occurrence in each document. Once the index is built,
 * the documents can searched on for keywords.
 *
 */
public class LittleSearchEngine {

	/**
	 * This is a hash table of all keywords. The key is the actual keyword, and the associated value is
	 * an array list of all occurrences of the keyword in documents. The array list is maintained in descending
	 * order of occurrence frequencies.
	 */
	HashMap<String,ArrayList<Occurrence>> keywordsIndex;

	/**
	 * The hash table of all noise words - mapping is from word to itself.
	 */
	HashMap<String,String> noiseWords;

	/**
	 * Creates the keyWordsIndex and noiseWords hash tables.
	 */
	public LittleSearchEngine() {
		keywordsIndex = new HashMap<String,ArrayList<Occurrence>>(1000,2.0f);
		noiseWords = new HashMap<String,String>(100,2.0f);
	}

	/**
	 * This method indexes all keywords found in all the input documents. When this
	 * method is done, the keywordsIndex hash table will be filled with all keywords,
	 * each of which is associated with an array list of Occurrence objects, arranged
	 * in decreasing frequencies of occurrence.
	 * 
	 * @param docsFile Name of file that has a list of all the document file names, one name per line
	 * @param noiseWordsFile Name of file that has a list of noise words, one noise word per line
	 * @throws FileNotFoundException If there is a problem locating any of the input files on disk
	 */
	public void makeIndex(String docsFile, String noiseWordsFile) 
			throws FileNotFoundException {

		// load noise words to hash table
		Scanner sc = new Scanner(new File(noiseWordsFile));
		while (sc.hasNext()) {
			String word = sc.next();
			noiseWords.put(word,word);
		}

		//Check what is in noiseWords
		System.out.println(noiseWords.toString());


		// index all keywords
		sc = new Scanner(new File(docsFile));
		while (sc.hasNext()) {
			String docFile = sc.next();
			HashMap<String,Occurrence> kws = loadKeyWords(docFile);
			//System.out.println("kws to string: ");
			//System.out.println(kws.toString());
			mergeKeyWords(kws);
		}



		//*********************TESTING PURPOSE ONLY*******************************
		// finish loadKeyWords and mergeKeyWords to print keyWordsIndex
		//System.out.println("makeIndex out of loadKeyWordsFile: \n"+keywordsIndex.toString());

	}

	/**
	 * Scans a document, and loads all keywords found into a hash table of keyword occurrences
	 * in the document. Uses the getKeyWord method to separate keywords from other words.
	 * 
	 * @param docFile Name of the document file to be scanned and loaded
	 * @return Hash table of keywords in the given document, each associated with an Occurrence object
	 * @throws FileNotFoundException If the document file is not found on disk
	 */
	public HashMap<String,Occurrence> loadKeyWords(String docFile) 
			throws FileNotFoundException {

		//Create frequency int val
		int occ = 1;

		//Create hashmap var
		HashMap<String,Occurrence> keywordsMap = new HashMap<String, Occurrence>();


		try{
			Scanner sc = new Scanner(new File(docFile));
		}catch(FileNotFoundException e){
			return keywordsMap;
		}

		Scanner sc = new Scanner(new File(docFile));

		while(sc.hasNext()){

			String keyWord = sc.next();
			
			keyWord = getKeyWord(keyWord);
			
			//System.out.println("KeyWord: "+keyWord);

			if(keyWord != null){
			
				if(keywordsMap.containsKey(keyWord)){
					
					keywordsMap.get(keyWord).frequency++;
				
				}else{
					
					//Create occurrence from docfile with the frequency 'occ'
					Occurrence occurrence = new Occurrence(docFile, occ);

					//add the token with the occurrence into the hashmap a
					keywordsMap.put(keyWord, occurrence);
				}

				//System.out.println("a.tostring inside while loop");
				//keywordsMap.toString();
			}

		}

		// RETURN NULL TO MAKE COMPILER HAPPY
		System.out.println("keywordsMap: "+keywordsMap.toString());
		return keywordsMap;
	}

	/**
	 * Merges the keywords for a single document into the master keywordsIndex
	 * hash table. For each keyword, its Occurrence in the current document
	 * must be inserted in the correct place (according to descending order of
	 * frequency) in the same keyword's Occurrence list in the master hash table. 
	 * This is done by calling the insertLastOccurrence method.
	 * 
	 * @param kws Keywords hash table for a document
	 */
	public void mergeKeyWords(HashMap<String,Occurrence> kws) {
		// COMPLETE THIS METHOD
		
		ArrayList<Occurrence> occList = new ArrayList<Occurrence>();
		
		for(String key: kws.keySet()){
			
			Occurrence occ = kws.get(key);
			
			if(keywordsIndex.containsKey(key)){
				
				occList = keywordsIndex.get(key);
				occList.add(occ);
				insertLastOccurrence(occList);
				
				//add occ
				keywordsIndex.put(key, occList);
				
			}else{	//create new node to add into keywordsIndex
				ArrayList<Occurrence> ocList = new ArrayList<Occurrence>();
				ocList.add(occ);
				keywordsIndex.put(key, occList);
			}
		
		}

	}

	/**
	 * Given a word, returns it as a keyword if it passes the keyword test,
	 * otherwise returns null. A keyword is any word that, after being stripped of any
	 * TRAILING punctuation, consists only of alphabetic letters, and is not
	 * a noise word. All words are treated in a case-INsensitive manner.
	 * 
	 * Punctuation characters are the following: '.', ',', '?', ':', ';' and '!'
	 * 
	 * @param word Candidate word
	 * @return Keyword (word without trailing punctuation, LOWER CASE)
	 */
	public String getKeyWord(String word) {
		// COMPLETE THIS METHOD

		//METHOD DONE ------------------------------------------------------------------------------------------------
		// NOT DONE NEED TO FILTER OUT NOISE WORDS

		String temp ="";
		boolean check = false;

		word = word.toLowerCase();
		for(int i = 0; i < word.length();i++){
			if(Character.isLetter(word.charAt(i))){
				temp+=word.charAt(i);
			}else{
				for(int k = i; k<word.length();k++){
					if(Character.isLetter(word.charAt(k))){
						check = true;
						return null; //found a letter after a punctuation. Return null
					}
				}
				if(check){
					//System.out.println("Break from if(check) line");
					break;
					//return null
				}else{
					if(Character.isLetter(word.charAt(i))){
						temp+=word.charAt(i);
					}
				}
			}
		}

		if(check == true){
			return null;
		}


		//check if temp is noise word
		if(noiseWords.containsKey(temp)){
			//System.out.println(temp+ " noise word!");
			return null;
		}

		//System.out.println("return temp word from get keyword: "+ temp +"\n"+noiseWords.toString());
		return temp;

	}

	/**
	 * Inserts the last occurrence in the parameter list in the correct position in the
	 * same list, based on ordering occurrences on descending frequencies. The elements
	 * 0..n-2 in the list are already in the correct order. Insertion of the last element
	 * (the one at index n-1) is done by first finding the correct spot using binary search, 
	 * then inserting at that spot.
	 * 
	 * @param occs List of Occurrences
	 * @return Sequence of mid point indexes in the input list checked by the binary search process,
	 *         null if the size of the input list is 1. This returned array list is only used to test
	 *         your code - it is not used elsewhere in the program.
	 */
	public ArrayList<Integer> insertLastOccurrence(ArrayList<Occurrence> occs) {
		// COMPLETE THIS METHOD
		
		if(occs.size()==1){
			return null;
		}
		
		int lastOcc = occs.get(occs.size()-1).frequency;
		
		//Set up for binary search
		int lo = 0, hi = occs.size()-1, mid;

		ArrayList<Integer> midList = new ArrayList<Integer>();
		
		//binary search and add
		while(lo<=hi){
			mid = (hi+lo)/2;
			midList.add(mid);
			
			if(lastOcc > occs.get(mid).frequency){
				hi = mid-1;
			}else if(lastOcc < occs.get(mid).frequency){
				lo = mid+1;
			}else{
				break;
			}
		}
		
		Occurrence temp = occs.get(occs.size()-1);
		
		if(midList.get(midList.size()-1) == 0){
			
			//if temp < occs
			if(temp.frequency<occs.get(0).frequency){
				occs.add(1,temp);
				occs.remove(occs.size()-1);
				
				return midList;
			}
			
		}
		
		occs.add(midList.get(midList.size()-1), temp);
		//decrement by 1
		occs.remove(occs.size()-1);
		
		// THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
		return midList;
	}

	/**
	 * Search result for "kw1 or kw2". A document is in the result set if kw1 or kw2 occurs in that
	 * document. Result set is arranged in descending order of occurrence frequencies. (Note that a
	 * matching document will only appear once in the result.) Ties in frequency values are broken
	 * in favor of the first keyword. (That is, if kw1 is in doc1 with frequency f1, and kw2 is in doc2
	 * also with the same frequency f1, then doc1 will appear before doc2 in the result. 
	 * The result set is limited to 5 entries. If there are no matching documents, the result is null.
	 * 
	 * @param kw1 First keyword
	 * @param kw1 Second keyword
	 * @return List of NAMES of documents in which either kw1 or kw2 occurs, arranged in descending order of
	 *         frequencies. The result size is limited to 5 documents. If there are no matching documents,
	 *         the result is null.
	 */
	public ArrayList<String> top5search(String kw1, String kw2) {
		// COMPLETE THIS METHOD
		ArrayList<Occurrence> occList1 = new ArrayList<Occurrence>();
		ArrayList<Occurrence> occList2 = new ArrayList<Occurrence>();
		ArrayList<String> result = new ArrayList<String>();
		
		// check if kw1 is in our hash map. if it is, add it to occ list 1
		if(keywordsIndex.get(kw1.toLowerCase())!=null){
			occList1 = keywordsIndex.get(kw1);
		}
		
		// check if kw2 is our hashmap. if it is, add it to occ list 2
		if(keywordsIndex.get(kw2.toLowerCase())!=null){
			occList2 = keywordsIndex.get(kw2);
		}
		
		for(int i = 0; i<occList1.size();i++){
			
			// only 5 max docs allowed
			if(result.size()<5){
				
				//doc1
				int temp1 = occList1.get(i).frequency;
				String doc1 = occList1.get(i).document;
				
				// for doc2
				for(int j = 0; j<occList2.size();j++){
					
					int temp2 = occList2.get(j).frequency;
					String doc2 = occList2.get(j).document;
					
					// if frequency from 2nd doc is > than first, add the higher freq first
					if(temp2>temp1){
						if(!result.contains(doc2) && result.size()<=4){
							result.add(doc2);
						}
					}else if(temp2<=temp1){
						if(!result.contains(doc1) && result.size()<=4){
							result.add(doc1);
						}
					}
					
				}
				
			}
			
		}
		
		// print result list in descending order
		for(int i =0; i<result.size();i++){
			if(result.size()==i+1){
				//System.out.println("result = i+1");
				System.out.println(result.get(i));
			}else{
				//System.out.println("result size < result.size: ");
				System.out.print(result.get(i)+", ");
			}
		}
		
		// THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE METHOD COMPILE
		if(result.size()==0){
			return null;
		}
		
		return result;
	}
}
