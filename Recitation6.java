
public class Recitation6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		int a = a();
		int b = b();
		int min;

		min = min(a, b);

		GCF(a, b, min);



	}

	public static int min(int a, int b) {
		int min;
		if (a>b){
			min=b;
		} else{
			min=a;
		}
		return min;
	}

	public static int b() {
		System.out.print("Enter second integer: ");
		int b = IO.readInt();
		return b;
	}

	public static int a() {
		System.out.print("Enter first integer: ");
		int a = IO.readInt();
		return a;
	}

	public static void GCF(int a, int b, int min) {
		for(int factor=min; ; factor--){
			if(a%factor==0 && b%factor==0){
				System.out.println("The GCF is: " + factor);
				break;
			}
		}
		 */


		System.out.print("Enter decimal: ");
		double a = IO.readDouble();
		double aMult=a;
		int i=0;

		for(;aMult<1;i++){
			aMult*=10;
		}
		System.out.print(aMult+" x 10^-"+i);


	}

}
