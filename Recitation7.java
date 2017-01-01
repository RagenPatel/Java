
public class Recitation7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.print("How many bars are there? ");
		int n = IO.readInt();
		int[] number = new int[n];

		int max = -1;
		int tallest=-1;
		int i;

		for(i =0;i<n;i++){
			System.out.print("What is the height of bar "+i+"? ");
			int j = IO.readInt();
			number[i]=j;

			if (j>max){
				max = j;
				tallest=i;
			}
		}

		System.out.println(number[tallest]);

		System.out.println("Your bar graph values are:");
		for(int k=0;k<n;k++){
			System.out.print(number[k]+" ");
		}
		System.out.println();

		int count = max;
		for(;count>0;count--){
			for(int l=0;l<number.length;l++){
				if(number[l]>=count){
					System.out.print("[]");
				}else{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		 */

		int elements = getElements();
		
		int[] totElements=new int[elements];
		
		setArray(elements,totElements);

	}

	public static int getElements(){
		int n=0;
		do{
			System.out.print("Enter number of elements: ");
			n = IO.readInt();
		}while(n<0);
		return n;
	}

	public static void setArray(int elements,int totElements[]){
		for(int p = 0; p<elements;p++){
			System.out.print("Enter element "+p+": ");
			totElements[p]=IO.readInt();
		}
	}
	

}
