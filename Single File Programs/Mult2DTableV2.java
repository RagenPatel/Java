
public class Mult2DTableV2 {

	public static int[] getRowsAndColumns(){
		//set up an array of length 2 to hold # rows and columns
		int[]rAndc=new int[2];   //
		
		do{
			System.out.print("Enter number of rows must be > 0: ");
			rAndc[0] = IO.readInt();
		} while (rAndc[0]<=0);

		do{
			System.out.print("Enter number of columns must be > 0: ");
			rAndc[1] = IO.readInt();
		} while (rAndc[1]<=0);
		
		
		return rAndc;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printArray(makeMultTable(getRowsAndColumns()));


	}

	public static int[][] makeMultTable(int []RC) {
		int[][] multTable=new int[RC[0]][RC[1]];

		for(int i=0; i<multTable.length;i++){
			for (int j=0; j<multTable[0].length; j++){
				multTable[i][j]=(i+1)*(j+1);
			}
		}
		return multTable;
	}

	public static void printArray(int[][] arr){

		for (int r=0;r<arr.length;r++){ // print each row
			System.out.print("[");
			// print first value separately since it won't have a comma before it
			System.out.print(arr[r][0]);
			// rest of the stuff
			for (int c=1; c<arr[0].length;c++){
				System.out.print(","+arr[r][c]);
			}
			System.out.println("]");
		}
	}
}
