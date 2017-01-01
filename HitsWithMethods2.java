
public class HitsWithMethods2 {

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

		// get hits per page from user in an array
		int[] hits = loadArray();
		
		// print array to verify contents
		printArray(hits);

		//find page with max hits (break ties arbitrally)
		int maxIndex = findMax(hits);

		// max hits is at index maxIndex
		System.out.println("Page # "+(maxIndex+1)+" has max hits = "+hits[maxIndex]);
	}

	public static int findMax(int[] hits) {
		int maxIndex=0;
		for(int p=1; p<hits.length;p++){
			if (hits[p]>hits[maxIndex]){
				maxIndex=p;
			}
		}
		return maxIndex;
	}

	public static int[] loadArray() {
		//get # of pages
		int n=getNumberOfPages();

		// set up an array for page hits, of length n
		int[] hits = new int[n];

		for(int p=0;p<n;p++){
			System.out.print ("Enter hits for page "+(p+1)+": ");
			hits[p] = IO.readInt();
		}
		
		return hits;
	}

	public static void printArray(int[] arr){
		System.out.print("[");
		// print first value separately since it won't have a comma before it
		System.out.print(arr[0]);
		// rest of the stuff
		for (int i=1; i<arr.length;i++){
			System.out.print(","+arr[i]);
		}
		System.out.println("]");
	}
}
