
public class TemperatureV4Whike {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter F value => ");
		double Fahrenheit=IO.readDouble();


		//Version 2
		
		while (Fahrenheit <-456.67){
			System.out.println("Value must be ³ -459.67¼F");
			System.out.print("Enter F value => ");
			
			Fahrenheit=IO.readDouble();
		}
		double celsius = (Fahrenheit-32)*5/9;
		System.out.println("celsius="+celsius);
	}
}