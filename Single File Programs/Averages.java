

public class Averages {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("How many numbers will you enter? ");
		int n = IO.readInt();

		double[] list = new double[n];

		for(int i=0;i<n;i++){
			System.out.print("Enter a number to add to the list: ");
			list[i]=IO.readDouble();	
		}


		for (int j = 0; j<list.length; j++) { 
			for (int k = 0; k < list.length; k++){ 
				if (list[j] < list[k]) { 
					double buffer = list[j]; 
					list[j] = list[k]; 
					list[k] = buffer; 
				} 
			} 
		}

		/*
		for(int i = 0;i<n;i++){
			System.out.print(list[i]+" ");
		}
		 */

		
		
		System.out.println();
		IO.outputDoubleAnswer(getMin(list));  //min
		
		IO.outputDoubleAnswer(getMax(list));  //max
		
		IO.outputDoubleAnswer(getSum(list));  //sum
		
		IO.outputDoubleAnswer(getMean(list));   //mean

		IO.outputDoubleAnswer(getMedian(list));  //median
		

		if(getMode(list)==0){
			System.out.println("RESULT: none");
		}else{
			IO.outputDoubleAnswer(getMode(list)); //mode
		}
	}

	
	public static double getSum(double[] list){
		double sum =0;

		for(int i =0; i<list.length;i++){
			sum+=list[i];
		}
		return sum;
	}

	public static double getMax(double[] list){
		double max = list[list.length-1];
		return max;
	}

	public static double getMin(double[] list){
		double min = list[0];
		return min;
	}

	public static double getMedian(double[] list){

		double median=0;

		if (list.length>1){
			if(list.length%2!=0){
				median = list[list.length/2];
			} else{
				int medianInt = list.length/2;
				median=(list[medianInt]+list[medianInt-1])/2;
			}
		}else{
			median = list[0];
		}

		return median;
	}

	public static double getMean(double[] list) {
		double sum=0;
		for(int i=0;i<list.length;i++){
			sum+=list[i];
		}

		double mean=sum/list.length;

		return mean;
	}

	public static double getMode(double[] list){
		double mode = list[0];
		double temp = 1;
		double temp2 = 1;
		for(int i=1;i<list.length;i++){
			if(list[i-1] == list[i]){
				temp++;
			}
			else {
				temp = 1;
			}
			if(temp==temp2){
				mode=0;
			}else if(temp >= temp2){
				mode = list[i];
				temp2 = temp;
			}
		}
		return mode;

	}

}