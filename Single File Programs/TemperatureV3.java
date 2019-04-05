
public class TemperatureV3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * below statement declares fahrenheit as a double and also assigns it a value
		 */
		
		// read F value
		System.out.print("Enter F value => ");
		double Fahrenheit=IO.readDouble();
		
		//accept only values that are ³ -459.67¼F (Absolute zero)
		/* Version 1
		if (Fahrenheit < -459.67) { 
			System.out.println("Value less than absolute zero. Enter value that is ³ -459.67");
			return; //terminates the program
		}
		
		double Celsius = (Fahrenheit-32)*5/9;
		System.out.println("Celsius = " + Celsius); // + stands for concatenation
	}	*/
		
		//Version 2
		if (Fahrenheit >= -456.67) {
			double celsius = (Fahrenheit-32)*5/9;
			System.out.println("celsius="+celsius);
		} else {
			System.out.println("Value must be ³ -459.67¼F");
		}
		
		System.out.println("Value must be ³ -459.67¼F");

	}
}