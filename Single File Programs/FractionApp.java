
public class FractionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction(3);
		Fraction f3 = new Fraction(2,3);
		
		//System.out.print(f3.num);		Does not work becaues num is a private field
	
		System.out.println("f3 = "+f3);  //no need to type num + "/" + denom. already done in fraction.java file
		System.out.println("f1 = "+f1);
		System.out.println("f2 = "+f2);
		
		Fraction f4 = new Fraction(3,5);
		Fraction f5 = f3.add(f4);
		
		System.out.println("f5 = "+f5);
		
		Fraction f6 = new Fraction(2,3);
		
		//is f3 equal to f6?
		System.out.println(f3.equals(f6));
	
	}

}
