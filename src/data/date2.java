package data;

public class date2 {
	private int month; // 1-12
	private int day; // 1-31 based on month
	private int year; // any year

	private static final int[] daysPerMonth = // days in each month
	{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// constructor: call checkMonth to confirm proper value for month;
	// call checkDay to confirm proper value for day
	public date2(int theYear, int theMonth, int theDay) {
		month = checkMonth(theMonth); // validate month
		year = checkYear(theYear); // validate year
		day = checkDay(theDay); // validate day
	} // end Date constructor

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	private int checkYear(int theYear) {
		if (theYear >= 1900 && theYear <= 9999)
			return theYear;
		else
			throw new IllegalArgumentException("Year must be 1900-9999");
	}

	// utility method to confirm proper month value
	private int checkMonth(int testMonth) {
		if (testMonth > 0 && testMonth <= 12) // validate month
			return testMonth;
		else // month is invalid
			throw new IllegalArgumentException("month must be 1-12");
	} // end method checkMonth

	// utility method to confirm proper day value based on month and year
	private int checkDay(int testDay) {
		// check if day in range for month
		if (testDay > 0 && testDay <= daysPerMonth[month])
			return testDay;

		// check for leap year
		if (month == 2 && testDay == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
			return testDay;

		throw new IllegalArgumentException("day out-of-range for the specified month and year");
	} // end method checkDay

	// return a String of the form month/day/year
	public String toString() {
		return String.format("%d/%d/%d", year, month, day);
	} // end method toString

	public void nextDay() {
		int tempDay = day + 1;
		if (tempDay > daysPerMonth[month]) {
			if (month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
				day = tempDay;
			} else {
				int tempMonth = month + 1;
				day = 1;
				if (tempMonth > 12) {
					year += 1;
					month = 1;
				} else
					month = tempMonth;
			}

		} else
			day = tempDay;
	}

	public void next31Day() {
		for (int i = 1; i <= 31; i++) {
			nextDay();
		}
	}

	public static boolean NcheckYear(int theYear) {
		boolean flag;
		if (theYear >= 1900 && theYear <= 9999)
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static boolean NcheckMonth(int testMonth) {
		boolean flag;
		if (testMonth > 0 && testMonth <= 12)
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static boolean NcheckDay(int theYear, int testMonth, int testDay) {
		boolean flag = false;
		if (testDay > 0 && testDay <= daysPerMonth[testMonth])
			flag = true;
		else
			flag = false;
		if (testMonth == 2 && testDay == 29 && (theYear % 400 == 0 || (theYear % 4 == 0 && theYear % 100 != 0))) {
			flag = true;
		}
		return flag;
	}

}
