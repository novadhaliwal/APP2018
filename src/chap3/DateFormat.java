package chap3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// use lambda function to print the date on your console. 

public class DateFormat {
	public static void main(String[] args) {
		
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd MMM uuuu");
		LocalDate date= LocalDate.now();
		System.out.println(formatter.format(date));
		
	}

}
