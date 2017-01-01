
public class TemperatureV4doWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double Fahrenheit=0;
		
		do{
			System.out.print("Enter F value, Value must be ³ -459.67¼F : ");
			Fahrenheit=IO.readDouble();	
		} while (Fahrenheit <-456.67);

		double celsius = (Fahrenheit-32)*5/9;
		System.out.println("celsius="+celsius);
	}

}
