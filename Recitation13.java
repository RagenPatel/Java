
public class Recitation13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Make a class that sorts/merges in a recursive way

		int[] arr= {5,3,7,8,1,2,6,4};

		SeparateSort(arr);

		for(int i=0; i<arr.length;i++){
			if(i==arr.length-1){
				System.out.print(arr[i]);
			}else{
				System.out.print(arr[i]+", ");
			}
		}
		

	}

	public static int[] SeparateSort(int[] arr){
		int temp=0;

		for(int i=0; i<arr.length;){
			if(arr[i]>arr[i+1]){
				temp = arr[i+1];
				arr[i+1]=arr[i];
				arr[i] = temp;
			}
			i+=2;
		}
		return arr;
	}

	public static int[] mergeArr(int[] arr){
		int temp = 0;

		for(int i=0; i< arr.length;){


		}

		return arr;
	}

}
