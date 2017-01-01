
public class Recitation8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.print("How many rows do you want? ");
		int rows = IO.readInt();

		System.out.print("How many columns? ");
		int columns = IO.readInt();

		int[][] Array = new int[rows][columns];

		for(int i=0;i<Array.length;i++){
			for(int k = 0;k<Array[0].length;k++){
				System.out.print("Enter values for row "+i+" column "+k+" : " );
				Array[i][k]=IO.readInt();
			}
		}

		System.out.println();
		System.out.println("Your 2d array is: ");
		for(int i=0;i<Array.length;i++){
			for(int k=0;k<Array[0].length;k++){
				System.out.print(Array[i][k]+" ");
			}
		System.out.println();
		}

		System.out.println();

		double sum = 0, avg=0, avg1=0, rowAvg=0;

		for(int i=0;i<Array.length;i++){
			sum = 0;
			for(int k=0;k<Array[0].length;k++){
				sum += Array[i][k];
			}
			avg = sum/Array[0].length;
			if(avg>avg1){
				avg1=avg;
				rowAvg = i;
			}
		}

		System.out.println("row "+rowAvg+" has the highest average. (index for arrays start at 0)");
		System.out.println("The average is: "+avg1);
		 */

		System.out.print("Enter a string to reverse: ");
		String input = IO.readString();
		String newString = "";
		
		for(int i=input.length()-1;i>=0;i--){
			newString += input.charAt(i);
		}
		System.out.println(newString);
	}

}
