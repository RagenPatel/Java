
public class RectangleProfApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RectangleProf r1 = new RectangleProf();
		RectangleProf r2 = new RectangleProf(5,10);
		
		System.out.println(r1.getHeight());
		
		r2.setWidth(10);
		
		System.out.println(r1.area());
		System.out.println(r2.perimeter());

		r1.scale(3);
	
	}

}
