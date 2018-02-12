package chap3;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatewithThread {
	
	
	private static SimpleDateFormat formatter= new SimpleDateFormat("MMM-dd-yyyy");
	private static String[] dates= {"Aug-29-1919", "Feb-23-2031"};
	
	public static void main(String[] args) throws ParseException{
		
		Thread t1= new Thread(new MyThread());
		t1.start();
		Thread t2= new Thread(new MyThread());
		t2.start();
		
	}
	
	public static class MyThread implements Runnable{

		@Override
		public void run() {
			
			for(String date:dates) {
				
			try {
				System.out.println(formatter.parse(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}

}
