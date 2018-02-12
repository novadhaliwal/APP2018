package chap3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

public class ThreadLocal1  {
	
	private static final ThreadLocal<SimpleDateFormat> dateFormat=
			ThreadLocal.withInitial(()-> {return new SimpleDateFormat("dd-MMM-yyyy");});
	
	  			     public static void main(String[] args) throws InterruptedException {
	  			    	 
			    	 SimpleDateFormat simpleDateFormat = dateFormat.get();
			    	 System.out.println(simpleDateFormat.toPattern());
			    	 
		             new Thread(() -> IntStream.range(0, 1).forEach(val -> {  
			        	   System.out.println("1.Formatted date is " + dateFormat.get().format(new Date()));
			          })).start();
		             
			         new Thread(() -> IntStream.range(0, 3).forEach(val -> {
			        	   System.out.println("2.Formatted date is " + dateFormat.get().format(new Date()));
			          })).start();
			         
			          new Thread(() -> IntStream.range(0, 1).forEach(val -> {
			          System.out.println(Thread.currentThread().getName() + " > " + dateFormat.get().toPattern());
			          })).start();
			     }
                          }
