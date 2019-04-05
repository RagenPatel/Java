
public class TemperatureV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * below statement declares fahrenheit as a double and also assigns it a value
		 */
		
		// read F value
		System.out.print("Enter F value => ");
		double Fahrenheit=IO.readDouble();
		
		
		double Celsius = (Fahrenheit-32)*5/9;
		System.out.println("Celsius = " + Celsius); // + stands for concatenation
	}

}