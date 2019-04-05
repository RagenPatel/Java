
public class DateFormatterStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter date in mm/dd/yyyy format: ");
		String date = IO.readString();

		// get the month, date and year parts of the String date
		String month = date.substring(0, 2); // gives first 2 characters of the date
		String dt = date.substring(3, 5);   // this gives characters for date (index range 3..4)
		String year = date.substring(6);   // this gives character sequence starting at 6 and going all the way to the end

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
