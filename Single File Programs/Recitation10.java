
public class Recitation10 {

	public static void main(String[] args){
		Recitation10Player p1 = new Recitation10Player(0,1000);
		Recitation10Player p2 = new Recitation10Player(0,1000);
		Recitation10Player p3 = new Recitation10Player(0,1000);
		Recitation10Player p4 = new Recitation10Player(0,1000);
		
		Recitation10Square[] board = new Recitation10Square[10];
	
		int cost=50;
		
		for(int i=0;i<board.length;i++){
			board[i]=new Recitation10Square(cost);
			cost=(cost*2)%500;
		}
	
		
		
		
	}
}
