
public class SumFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("How mang values will you sum? : ");
		int numValues=IO.readInt();
		int sum=0;

		/* Version 1:
		for(int count=0;count<numValues;count++){
			System.out.println("Count = " +count);

			System.out.print("enter number: ");
			int number=IO.readInt();

			sum += number;
		}
		 */


		//Version 2:
		/*
		for(int count=1;count <= numValues;count++){
			System.out.println("Count = " +count);

			System.out.print("enter number: ");
			int number=IO.readInt();

			sum += number;
		}
		 */

		//WHILE LOOP VERSION

		int count=1;
		while(count<=numValues){
			System.out.println("Count = " +count);

			System.out.print("enter number: ");
			int number=IO.readInt();

			sum += number;
			count++;
		}

		System.out.println("Total sum = "+sum);
	
	}

}
