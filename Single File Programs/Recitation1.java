
public class Recitation1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter #1: ");
		double number1 = IO.readDouble();
		System.out.println();
		System.out.print("Enter #2: ");
		double number2 = IO.readDouble();
		System.out.println();
		System.out.print("Enter #3: ");
		double number3 = IO.readDouble();
		
		System.out.println();
		System.out.print("Enter your name: ");
		String name = IO.readString();
		System.out.println();
		
		double average = (number1+number2+number3)/3;
		
		System.out.println(name + ", your average is " + average);
	}

}
