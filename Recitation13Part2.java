
public class Recitation13Part2 {

	public static String reverse(String s){
		if(s.length() ==0){
			return s;
		}
		
		return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
	}
	
	public static void main(String args[]){
		String a = "hello";
		String b = "Hah";
		String c = "racecar";
		String d = "Hellolleh";
		
		System.out.println(reverse(a));
		System.out.println(palindrome(a));
		System.out.println(reverse(b));
		System.out.println(palindrome(b));
		System.out.println(reverse(c));
		System.out.println(palindrome(c));
		System.out.println(reverse(d));
		System.out.println(palindrome(d));
		
				
	}

	
	public static boolean palindrome(String s){
		s=s.toLowerCase();
		if(s.length()==1||s.length()==0){
			return true;
		}
		
		if(s.charAt(s.length()-1)==s.charAt(0)){
			
			s=s.substring(s.length()-(s.length()-1), s.length()-1);
			palindrome(s);
			return true;
		}else{
			return false;
		}
		
		
	
	}
}
