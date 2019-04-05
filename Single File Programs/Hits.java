
public class Hits {

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

		/*
		// get hits per page from user and fill in the array
		int p=0;
		while(p<n){
			System.out.print ("Enter hits for page "+(p+1)+": ");
			//assign value read in from user to hits [p]
			hits[p++] = IO.readInt();
		}*/
		
		//For loop version
		for(int p=0;p<n;p++){
			System.out.print ("Enter hits for page "+(p+1)+": ");
			hits[p] = IO.readInt();
		}

		//find page with max hits (break ties arbitrally)
		int maxIndex=0;
		for(int p=1; p<n;p++){
			if (hits[p]>hits[maxIndex]){
				maxIndex=p;
			}
		}
		// max hits is at index maxIndex
		System.out.println("Page # "+(maxIndex+1)+" has max hits = "+hits[maxIndex]);
	}

}
