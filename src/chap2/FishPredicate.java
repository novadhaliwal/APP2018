package chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FishPredicate {

	public static void main(String[] args) {
		
		List<Fish> inventory=Arrays.asList(new Fish("Salmon", "pink", 100),
				new Fish("Catfish", "white", 400), new Fish("Tuna", "brown", 150), 
				new Fish("Sardine", "black", 100), new Fish("Stingray", "black", 500),
				new Fish("Dogfish", "white", 400), new Fish("Whale", "white", 1000),
				new Fish("Dolphin", "white", 500));
		// u can use predicate two ways: first method
		
		List<Fish> whiteFish= filterfish(inventory, (Fish fish)->fish.color.equals("white"));
		System.out.println(whiteFish);

		//or second method
		
		List<Fish> longFish=filterfish(inventory, FishPredicate::isLong);
		System.out.println(longFish);
		
		//PrettyFishExample(task 3)
		prettyfishfilter(inventory, new OneParameterfish());
		prettyfishfilter(inventory, new MultipleParameterfish());
	}
	
	
	public static List<Fish> filterfish(List<Fish> inventory,Predicate<Fish> p){
		
		List<Fish> collectfish= new ArrayList<>();
		for(Fish fish:inventory) {
			if(p.test(fish)) {
				collectfish.add(fish);
			}
		}
		return collectfish;
		
		
	}
	public static void prettyfishfilter(List<Fish> inventory, FishFormat f) {
	
		for(Fish fish:inventory) {
			String result=f.accept(fish);
			System.out.println(result);
		}
	}
	
	public static  class MultipleParameterfish implements FishFormat{

		@Override
		public String accept(Fish fish) {
			String filter=fish.len>300?"Long":"short";
			return fish.getName()+" fish is "+ filter+ " and its color is "+fish.getColor();
		}
		
	}
	public static class OneParameterfish implements FishFormat{

		@Override
		public String accept(Fish fish) {
			
			return "Name of fish: "+ fish.getName();
		}
		
	}
	

	
	public static boolean isWhite(Fish fish) {
		return fish.color.equals("white");
		//return "green".equals(fish.getColor());
	}
	
	public static boolean isLong(Fish fish) {
		return fish.len>300;
		
	}
	
	public static class Fish {
		String name="";
		String color="";
		int len;
		
		public Fish(String name, String color, int len) {
			//super();
			this.name= name;
			this.color = color;
			this.len = len;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getLen() {
			return len;
		}

		public void setLen(int len) {
			this.len = len;
		}
		
		public String toString() {
			return "Fish: [Name= "+name+", Color= "+color+", Length= "+len+"]";
		}
	}

	public interface FishFormat{
		String accept(Fish fish);
	}
}
