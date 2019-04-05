public class Fraction {

	//instance fields
	private int num;
	private int denom;

	//most general constructor
	public Fraction(int num, int denom){
		this.num = num;		//"this" means this object, i.e. the object on which the constructor is being executed

		if (denom == 0){
			denom = 1;
		}

		this.denom = denom;
	}

	// another constructor, which accepts only numerator
	//(denominator will be set to 1)
	public Fraction(int num){
		/* CAN DO IT THIS WAY
		this.num = num;
		denom = 1;
		OR, MORE OFTE, WE WILL CALL THE GENERAL CONSTRUCTOR TO DO THE WORK */

		this(num,1);	// call the general constructor
	}

	// another constructor, to set fraction to 1/1 (i.e. the integer 1)
	public Fraction() {
		/* can do it this way
		num = 1;
		denom = 1;
		 */
		//OR MORE OFTEN WE WILL CALL THE GENERAL CONSTRUCTOR
		this(1,1);
	}

	// getter methods
	public int getNum(){
		return num;
	}

	//getter method
	public int getDenom(){
		return denom;
	}

	// NO SETTER METHODS, want Fraction objects to be immutable

	public String toString(){
		return num + "/" + denom;
	}

	// adds this fraction and f, and returns the result in a new Fraction object
	public Fraction add(Fraction f){
		int n = num*f.denom + denom*f.num;  // cross multiply
		int d = denom*f.denom;
		return new Fraction(n,d);
	}
	
	
	// static method here means that there is no object on which this method is called
	// the fraction class simply happens to be a good place to implement a method that adds two fractions
	public static Fraction add(Fraction f1, Fraction f2){
	
//		int n = num*f1.denom;	Wont work because num is an "instance" field that can only be referred on an
//								object, but this method is not called on any fraction object.
		
		int n = f1.num*f2.denom + f2.denom*f1.num;  //cross multiply
		int d = f1.denom*f2.denom;
		return new Fraction(n,d);
		
		// static method is called using name of the class
		//****System.out.println(Fraction.add(f3,f5));		
	}
	
	public boolean equals(Fraction other){
		return num == other.num && denom == other.denom;
	}
}