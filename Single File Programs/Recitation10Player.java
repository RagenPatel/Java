
public class Recitation10Player {
	static int gameboardSize = 10;
	int playerNum;
	int position;
	int balance;

	public Recitation10Player(int playerNum, int balance){
		this.position=0;
		this.playerNum=playerNum;
		this.balance=balance;
	}
	
	public int roll(){
		double n = Math.random();
		if(n<1/3){
			return 1;
		}else if(n<2/3){
			return 2;
		}else{
			return 3;
		}
	}
	
	public void subtract(int cost){
		balance-= cost;
	}
	public void move(int squares){
		this.position =(this.position+squares)%gameboardSize;
	}
}
