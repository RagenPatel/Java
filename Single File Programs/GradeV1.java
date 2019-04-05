
public class GradeV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter grade: ");
		double grade = IO.readDouble();
		if (grade<0 || grade>100){
			System.out.println("invalid: Grade not in range 0..100");
		} else if (grade<=49){
			System.out.println("F");
		} else if (grade <= 59){
			System.out.println("C");
		} else if (grade <= 69){
			System.out.println("C+");
		} else if (grade <= 79){
			System.out.println("B");
		} else if (grade <= 89){
			System.out.println("B+");
		} else if (grade <= 100){
			System.out.println("A");
		}
	}

}
