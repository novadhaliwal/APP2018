package chap2;

public class LambdaProg {
		
		public final int num=2;
		
		public void lambda()
		{
			 int num=3;
			 
			 Runnable r= new Runnable() {
				  int num=4;
				  public void run() {
					  int num=5;
					  System.out.println(num);
				  }
				 
			 };
			 
			 
			 r.run();
		}

		public static void main(String[] args) {
			
			LambdaProg l= new LambdaProg();
			l.lambda();
			
		}

}
