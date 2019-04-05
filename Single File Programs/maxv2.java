
public class maxv2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter termination number: ");
		int terminator = IO.readInt();
		
		System.out.print("Enter a number, or terminator: ");
		int number=IO.readInt();
		int max=0; //declare max outside the if or else it wont be visible outside of the if statement
		if (number != terminator){
			max=number;
		} else{
			System.out.println("No input values");
			System.exit(0);
		}
		
		System.out.print("Enter a number, or terminator: ");
		number=IO.readInt();
		while (number != terminator){
			max = Math.max(number, max);

			System.out.print("Enter a number, or a terminator: ");
			number=IO.readInt();
		}
			System.out.println(max);
	}

}
