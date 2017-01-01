
public class BetterDateFormatterStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter date in mm/dd/yyyy format: ");
		String date = IO.readString();

		int slashPos = date.indexOf('/');
		String month = date.substring(0, slashPos);
		int pos1=slashPos;
		
		slashPos= date.indexOf('/', slashPos+1);  // search starting at previous slash position +1
		String dt=date.substring(pos1+1,slashPos);
		
		String year = date.substring(slashPos+1);
		
		String[] monthNames={"Jan","Feb","Mar","Apr", "May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

		int mon=Integer.parseInt(month);  // converts month string to int

		// start creating the output string
		String out = monthNames[mon-1]; // first part of output string is month name
		
		// convert dt to int to get rid of leading 0, if any
		int newdt = Integer.parseInt(dt);
		//append to out
		//out = out+ " "+newdt;
		
		out +=" "+newdt;
		
		// append the year
		out+=", "+year;
		
		System.out.println(out);
	}

}
