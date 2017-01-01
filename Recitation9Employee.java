public class Recitation9Employee {

	double money;
	double balance;
	double rate;
	String name;
	int hours;

	public Recitation9Employee(String name, double rate){
		this(name,rate,0);
	}	
	
	public Recitation9Employee(String name, double rate, double balance){
		this.name = name;
		this.rate = rate;
		this.balance= balance;
	}
	
	public void Spend(double money){
		balance-=money;
	}
	
	public void work(int hours){
		this.balance = hours*rate;
	}
	
	public void printInfo(){
		System.out.println("Name: "+this.name);
		System.out.println("Rate: "+this.rate);
		System.out.println("Balance: "+this.balance);
	}
}
