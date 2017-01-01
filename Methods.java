
public class Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = add(5,6);  // calls the add(int,int) method
		
		float y = add(5.2f,6.8f); // calls the float(float, float) method
		System.out.println(x+y);
		
		int n=5;
		stuff(n);
		System.out.println("n = " + n);  // what is printed?
		
	}
	
	public static void stuff(int n){
		n=10;
	}

	// different methods with same name but different parameters
	// this is called method OVERLOADING
	// the following two methods overload the name "add"
	public static int add(int x, int y) {
		return x+y;
	}

	public static float add(float x, float y) {
		return x+y;
	}

	/*  THIS DOESN'T WORK: because it has the same name AND same parameter types as the first add
	 * return type is irrelevant
	public static void add(int a, int b){
		return;
	}
	 */
}
