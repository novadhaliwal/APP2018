package appLabWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;



public class Chap1Work {
	
	static Logger logger = Logger.getLogger(Chap1Work.class);
	public static void main(String[] args) {
		BasicConfigurator.configure();
        logger.info("Hello World");
        
		List<Apple> inventory= Arrays.asList(new Apple(80,"green"),
						new Apple(150, "red"), new Apple(120, "green"), new Apple(155, "red"),
						new Apple(80, "red"), new Apple(120, "red"), new Apple(150, "green"));
		
		List<Apple> greenApples=filterApple(inventory, (Apple a)->"green".equals(a.getColor()));
		System.out.println(greenApples);
		
		List<Apple> lightApples=filterApple(inventory, Chap1Work::isLightApple);
		List<Apple> lightApple = filterApple(inventory,(Apple a)->a.getWeight()<=80);
		System.out.println(lightApples);
		System.out.println(lightApple);
	}
	
	public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

	public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> p){
		List<Apple> result= new ArrayList<>();
		for(Apple apple:inventory) {
			if(p.test(apple)) {
				result.add(apple);
				
			}
		}
		return result;
	}
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	public static boolean isRedApple(Apple apple) {
		return "red".equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight()>=150;
	}
	public static boolean isLightApple(Apple apple) {
		return apple.getWeight()<=80;
	}

	
	 public static class Apple {
		
		public int weight;
		public String color="";
		
		public Apple(int weight, String color) {
			//super();
			this.weight=weight;
			this.color= color;
		}
		public  int getWeight() {
			return weight;
		}
		public  void setWeight(int weight) {
               this.weight=weight; 
		}
		public  String getColor() {
			return color;
		}
		public  void setColor(String color) {
			this.color = color;
		}
		public String toString() {
			
			return "Apple{"+" color='"+color+'\''+", weight="+weight+'}';
		}
		@Override
		public int hashCode() {
			
			return 2;
		}
		@Override
		public boolean equals(Object obj) {

			if(((Apple) obj).getColor().equals("green") && ((Apple)obj).getWeight()>0)
					{return true;}
			if(((Apple)obj).getWeight()>150)
				{return true;}
			else {
			return false;}
			
		}
		
		
	}

}