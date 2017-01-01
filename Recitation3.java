
public class Recitation3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * EXERCISE 1
		 *

		System.out.print("Enter an integer: ");
		int number = IO.readInt();

		int x;

		for(x=1;x<number;x*=10){
		}
		x/=10;
		while(x>0){
			System.out.println(number/x);
			number%=x;
			x/=10;
		}
		 */

		/* Exercise 2:

		System.out.print("Enter height of the pyramid: ");
		int height = IO.readInt();



		for(int line=0;line<height;line++){

			for(int numSpaces= height-1-line;numSpaces>0;numSpaces--){
				System.out.print(' ');
			}
			for(int numAsterisks= 2*line+1;numAsterisks>0;numAsterisks--){
				System.out.print('*');
			}
			System.out.println();
			}
		 */
		

		//Find GCF of 2 numbers
		/*
		System.out.print("Enter a number: ");
		int num1 = IO.readInt();
		System.out.print("Enter a number: ");	
		int num2=IO.readInt();
		int factor1;
		int factor2;

		for (int count = 1;;count++){
			factor1=num1*count;
			factor2=num2*count;
			if (factor1==factor2){
				System.out.print(count);
				break;
			}
		}*/

		System.out.print("Enter first integer: ");
		int a = IO.readInt();
		System.out.print("Enter second integer: ");
		int b = IO.readInt();
		int min;

		if (a>b){
			min=b;
		} else{
			min=a;
		}

		for(int factor=min; ; factor--){
			if(a%factor==0 && b%factor==0){
				System.out.println("The GCF is: " + factor);
				break;
			}
		}

	}

}

