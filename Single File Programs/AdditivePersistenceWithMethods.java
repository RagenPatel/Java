
public class AdditivePersistenceWithMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int number = getNumber();

		int count=0;
		int n=number; //saves it so it can be printed in the final output
		while(number>=10){ //has more than 1 digit
			int sum=0;
			count++;
			while(number>=10){
				sum+=number%10;
				number /=10;
			}
			sum+=number;
			number=sum;
		}
		System.out.println("Additive persistence of " + n+" = "+count+ ", digital root = "+number);
	}

	public static int getNumber() {
		int number=0;
		do{
			System.out.print("Enter a positive integer: ");
			number=IO.readInt();
		} while(number<=0);
		return number;
	}

}
