package chap3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTodate {
	
	public static void main(String[] args) throws ParseException {
		
		 SimpleDateFormat formatter= new SimpleDateFormat("dd-MMM-yyyy");
		 
		 Date date=formatter.parse("10-May-1910");
		 System.out.println("Date is : "+date);
		
	}

}
