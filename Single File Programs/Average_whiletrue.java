
public class Average_whiletrue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter termination number: ");
		int terminator = IO.readInt();
		int sum=0,count=0;


		while (true){
			System.out.print("Enter a number, or terminator: ");
			int number=IO.readInt();	

			if(number==terminator){
				break;  //jumps out of while loop
			}

			sum+= number;
			count++;
		}

		if (count==0){
			System.out.println("No input values to average!");
		} else{
			System.out.println("The average is: " + sum*1.0/count);
		}
			/*
		System.out.print("Enter a number, or terminator: ");
		int number=IO.readInt();

		while (number != terminator){
			sum+= number;
			count++;
			System.out.println("sum = "+sum+", count = "+count);

			System.out.print("Enter a number, or a terminator: ");
			number=IO.readInt();

		}

		if (count==0){
			System.out.println("No input values to average!");
		} else{
			System.out.println("The average is: " + sum*1.0/count); //*1.0 makes it a double
			// *OR* System.out.println("The average is: " + (double)sum/count);
		}
			 */

	}
}
