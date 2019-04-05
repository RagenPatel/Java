
public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter # to calculate factorial: ");
		int n=IO.readInt();

		/* VERSION 1 ( Standard )
		int factorial=1;
		for(int i =2; i<=n;i++){
			factorial*=i;
		}
		 */

		/* VERSION 2: i initialized outside of For

		int factorial=1,i=2;
		for(; i<=n;i++){
			factorial*=i;		
		}
		 */


		/* Version : Omit the condition (Equivalent to true)
		int factorial=1,i=2;
		for(; ;i++){
			if (i>n){
				break;
			}
			factorial*=i;		
		}
		 */

		
		/* Version 4: Extreme case, Nothing in the For */
		int factorial=1,i=2;
		for(; ;){
			if (i>n){
				break;
			}
			factorial*=i;		
			i++;
		}


		System.out.println("Factorial("+n+") = "+ factorial);

	}

}
