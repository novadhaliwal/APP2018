package chap2;

public class LambdaProg {
		
		public final int num=2;
		
		public void lambda()
		{
			 int num=3;
			 Runnable r= new Runnable() {
				 
		//1. using anonymous class
				  int num=4;
				  public void run() {
					  int num=5;
					  System.out.println(this.num);
				  } 
			 };
			 r.run();
		
		
	/*	//2. direct lambda
		 Runnable d= ()->System.out.println("hello");
		 
		 //3. lambda passed directly
		 
		 public static void process(Runnable t) {
			 t.run();
		 } 
		 */
		} 
		public static void main(String[] args) {
			
			LambdaProg l= new LambdaProg();
			l.lambda();
			
		}
		
		

}
