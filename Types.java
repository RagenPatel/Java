
public class Types {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 5;
		// float y=3.2; doesn't work. 3.2 considered a double (doubles can't be stored in float)
		// fix by adding a "f" after 3.2
		float y=3.2f;
		
		// double y = 3.2; can't redeclare same variable
		double z=3.2;
		System.out.println(z);
		z=y; // left hand side is double, right hand side is float. So, float can be stored in double
		
		//y=z; can't do this since can't store double to float
		
		int i=3;
		
		
		// float result=x/i; both x and i are integers computation so result is an integer
		
		//FIX 1
		float result=x*1f/i;
		System.out.println(result);
		
		//FIX 2
		result=(float)x/i;
		System.out.println(result);
		
		int a=(int)3.2f;  //Forces 3.2 to become int with (int)
		System.out.println("a = " + a);
		
		int big= 23406743;
		short small=(short)big;
		System.out.println("short = " + small);
		
		// character type
		char ch='x';
		System.out.println("ch= "+ch);
		
		// ch=x; withouht quites, x is an int type variable so type mismatch
		
		// ch="x";  " " for string, ' ' for char (char is primitive type)
				//coding scheme ASCII and UTF
		
	}

}
