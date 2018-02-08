package chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceuteAround {
	
	
	public static void main(String[] args) throws IOException {
		String oneLine= processFile((BufferedReader b)->b.readLine());
		//System.out.println("Count "+oneLine);
		
		String count=processFile((BufferedReader b)->{
			long c=b.lines().count();
			return String.valueOf(c);});
		System.out.println("count "+ count);
		
	}
	


	public static String processFile(BufferedReaderProcessor p) throws IOException{
		try(BufferedReader br= new BufferedReader(
		new FileReader("C:\\Users\\Admin\\Documents\\FishPredicate.txt"))){
			return p.process(br);
		}
	}
	
	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;
	}

}
