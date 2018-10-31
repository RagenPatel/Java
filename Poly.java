
public class Poly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter first root: ");
		int root1 = IO.readInt();
		System.out.print("Enter second root: ");
		int root2 = IO.readInt();
		System.out.print("Enter third root: ");
		int root3 = IO.readInt();
		
		root1 = -root1;
		root2 = -root2;
		root3 = -root3;
		
		int end = root1*root2*root3;
		
		int a1 = root1 + root2; //x^2 + *__x* + c
		int c1 = root1*root2; // last number for x^2 + bx + *c*
		
		int finalx2 = root3+a1;
		
		int finalx = a1*root3+c1;
		
		// (x-5) (x+3) (x-2)   (x^2-2x -15) (x-2)    =   x^3 - 4x^2 - 11x + 30 
		// System.out.println("x^3 + "+finalx2+ "x^2 + " + finalx+ "x + " + end);
	
		System.out.print("x^3");
		
		if (finalx2>0){
			System.out.print(" + " + finalx2+"x^2");
		} else if (finalx2<0){
			System.out.print(" - "+ -finalx2 + "x^2");
		} else{
			System.out.print(" ");
		}
		
		if (finalx>0){
			System.out.print(" + "+finalx+"x");
		} else if (finalx<0){
			System.out.print(" - "+ -finalx+"x");
		}else{
			System.out.print(" ");
		}
		
		if (end>0){
			System.out.print(" + "+end);
		} else if (end<0){
			System.out.print(" - "+ -end);
		}else{
			System.out.print(" ");
		}
		
	}

}
