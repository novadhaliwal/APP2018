package chap3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

public class DatewithLambda {
	
	private static final ThreadLocal<SimpleDateFormat> local= ThreadLocal.withInitial(()->{return new SimpleDateFormat("yyyy-dd-MMM");});
	
	public static void main(String[] args) {
		SimpleDateFormat formatter=local.get();
		System.out.println(formatter.toPattern());
		
	new Thread(()-> IntStream.range(0, 1).forEach(value-> {System.out.println("1. "+local.get().format(new Date()));}), " T1").start();
		
	new Thread(()-> IntStream.range(0, 2).forEach(value-> {System.out.println("2. "+local.get().format(new Date()));}),"T2").start();
	
	new Thread(()-> IntStream.range(0, 1).forEach(value-> {System.out.println(Thread.currentThread().getName()+"- "+local.get().format(new Date()));}), "T3").start();
	
	}

}
