package chap3;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThreadSafeProblem {
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private static String[] stringDates = { "21/12/2012", "10/10/2013", "23/02/2014" };
	public static void main(String[] args) throws ParseException {
     
		Thread t1 = new Thread(new MyThread(),"ok");
		Thread t2 = new Thread(new MyThread(),"ok2");
		Thread t3 = new Thread(new MyThread(),"ok3");
		t1.start();
		t2.start();
		t3.start();
	}

	private static class MyThread implements Runnable {

		@Override
		public void run() {
		
			for (String strDate : stringDates) {
				try {
					System.out.println(sdf1.parse(strDate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
			}
			
		}

	}
	 
    
}
