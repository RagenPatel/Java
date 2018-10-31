
public class Intersect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//java.intersect

		System.out.print("Enter constant d (y = dx^2 + fx + g): ");
		double constD=IO.readDouble();	
		System.out.print("Enter constant f: ");
		double constF=IO.readDouble();
		System.out.print("Enter constant g: ");
		double constG=IO.readDouble();
		System.out.print("Enter constant m (y = mx + b): ");
		double constM=IO.readDouble();
		System.out.print("Enter constant b: ");
		double constB=IO.readDouble();

		double a = constD;
		double b = constF-constM;
		double c = constG-constB;
		double sqrt = b*b - 4*a*c;



		if (a==0){
			if (constF==constM){
				if (constG==constB){
					System.out.println("Lines are parallel! (intersect everywhere!)");
				} else{
					System.out.println("The lines are parallel and shifed by " + Math.abs(c)+" units! (No intersection)");
				}
			} else {
				double singlea = constM-constF;
				double singleAnswer = c/singlea;
				double singleY = (constM*singleAnswer)+constB;

				System.out.println("("+singleAnswer+", "+singleY+")");
			}
		} else if (sqrt<0){
			System.out.println("Answer not valid! Ã of a negative number.");
		} else {
			double answer1 = (-b+Math.sqrt(sqrt))/(2*a);
			double answer2 = (-b-Math.sqrt(sqrt))/(2*a);

			double y1 = answer1*constM + constB;
			double y2 = answer2*constM+constB;

			System.out.println("("+answer1+", "+y1+")");
			System.out.println("("+answer2+", "+y2+")");
		}
	}
}


