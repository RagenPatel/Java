
public class HitsWithMethods {

	public static int getNumberOfPages() {
		int number=0;
		do{
			System.out.print("Enter number of pages in website: ");
			number=IO.readInt();
		} while(number<=0);
		return number;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//get # of pages
		int n=getNumberOfPages();


		// set up an array for page hits, of length n
		int[] hits = new int[n];
		
		
		
		loadArray(n, hits);
		

		//find page with max hits (break ties arbitrally)
		int maxIndex = findMax(n, hits);
		
		
		// max hits is at index maxIndex
		System.out.println("Page # "+(maxIndex+1)+" has max hits = "+hits[maxIndex]);
	}


	public static int findMax(int n, int[] hits) {
		int maxIndex=0;
		for(int p=1; p<n;p++){
			if (hits[p]>hits[maxIndex]){
				maxIndex=p;
			}
		}
		return maxIndex;
	}

	

	public static void loadArray(int n, int[] hits) {
		for(int p=0;p<n;p++){
			System.out.print ("Enter hits for page "+(p+1)+": ");
			hits[p] = IO.readInt();
		}
	}

}
