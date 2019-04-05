
public class Recitation12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] inputArray = {"Elephant", "Dog","Cat", "Bigfoot","Bird","Alpaca", "Buffalo","Rhinosaurus","Dogzilla",
				"Beagle", "Termite","Hamster","Penguin"};

		String temp = "";

		for(int i = 1; i<inputArray.length;i++){
			for(int k = 0;k<inputArray.length;k++){
				if(inputArray[i].charAt(0)<inputArray[k].charAt(0)){
					temp = inputArray[i];
					inputArray[i]=inputArray[k];
					inputArray[k]=temp;
					temp ="";
				}
			}
		}

		for(int i=0;i<inputArray.length;i++){
			System.out.print(inputArray[i]+" ");
		}
		System.out.println();
		System.out.print("Enter search word: ");
		String input = IO.readString();
		
		int low =0;
		int high = inputArray.length-1;
		int indexS=-1;
		
		while(low<=high){
			int mid = (low+high)/2;
			
			if(inputArray[mid].equals(input)){
				indexS=mid;
				break;
			}else{
				if(inputArray[mid].compareTo(input)<0){
					low = mid+1;
					indexS=mid;
				}else{
					high = mid-1;
					indexS=mid;
				}
			}
		}
		
		System.out.println("Search: "+input+" found at "+ indexS);


	}

}
