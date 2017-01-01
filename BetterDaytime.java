
public class BetterDaytime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// read sunrise hour
		int sunriseHour = getSunriseHour();

		//sunrise minute
		int sunriseMinute = getSunriseMinute();

		//sunset hour
		int sunsetHour = getSunsetHour();

		//sunset minute
		int sunsetMinute = getSunsetMinute();



		int sunriseMinsAfterMidnight = sunriseHour*60 + sunriseMinute;
		int sunsetMinsAfterMidnight = sunsetHour*60 + sunsetMinute;

		int daylightMins = sunsetMinsAfterMidnight - sunriseMinsAfterMidnight;

		if (daylightMins<0){
			System.out.println("Sunset cannot be before sunrise.");
			System.exit(1);
		}

		int daylightHours = daylightMins / 60;   // integer division, gives quotient
		int daylightMinutes = daylightMins % 60;  // % is for remainder

		System.out.println("Daylight time: "+daylightHours+" hours " +daylightMinutes+" minutes.");

	}










	public static int getSunsetMinute() {
		System.out.print("Enter sunset minute, 0..59 : ");
		int sunsetMinute = IO.readInt();
		if (sunsetMinute < 0 || sunsetMinute >59){
			System.out.println("Sunset minute must be in range 0..11");
			System.exit(1); //stops the program
		}
		return sunsetMinute;
	}

	public static int getSunsetHour() {
		System.out.print("Sunset AM (enter yes) or PM (enter no): ");
		boolean sunsetIsAM = IO.readBoolean();
		if (sunsetIsAM) {    // same as doing: if (sunriseIsAM == true)
			System.out.print("Enter sunset hour, 0..11: ");
		} else {
			System.out.print("Enter sunset hour, 1..12: ");
		}
		int sunsetHour = IO.readInt();
		if (sunsetIsAM && (sunsetHour < 0 || sunsetHour >11)){
			System.out.println("Sunset hour must be in range 0..11");
			System.exit(1); //stops the program
		} else if (!sunsetIsAM && (sunsetHour<1 || sunsetHour>12)){
			System.out.println("Sunset must be in range 1..12");
			System.exit(1);
		}
		if (!sunsetIsAM && sunsetHour<12){
			sunsetHour +=12;
		}
		return sunsetHour;
	}

	public static int getSunriseMinute() {
		System.out.print("Enter sunrise minute, 0..59 : ");
		int sunriseMinute = IO.readInt();
		if (sunriseMinute < 0 || sunriseMinute >59){
			System.out.println("Sunrise minute must be in range 0..11");
			System.exit(1); //stops the program
		}
		return sunriseMinute;
	}

	public static int getSunriseHour() {
		System.out.print("Sunrise AM (enter yes) or PM (enter no): ");
		boolean sunriseIsAM = IO.readBoolean();
		if (sunriseIsAM) {    // same as doing: if (sunriseIsAM == true)
			System.out.print("Enter sunrise hour, 0..11: ");
		} else {
			System.out.print("Enter sunrise hour, 1..12: ");
		}
		int sunriseHour = IO.readInt();
		if (sunriseIsAM && (sunriseHour < 0 || sunriseHour >11)){
			System.out.println("Sunrise hour must be in range 0..11");
			System.exit(1); //stops the program
		} else if (!sunriseIsAM && (sunriseHour<1 || sunriseHour>12)){
			System.out.println("Sunrise must be in range 1..12");
			System.exit(1);
		}

		// add 12 hours if AM and hour is < 12
		if (!sunriseIsAM && sunriseHour <12){
			sunriseHour += 12;
		}
		return sunriseHour;
	}

}
