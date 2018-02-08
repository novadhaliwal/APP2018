package chap2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class Sorting {
	
		public static void main(String[] args) {
			
			List<Fish> inventory=Arrays.asList(new Fish("Salmon", "pink", 100),
					new Fish("Catfish", "white", 400), new Fish("Tuna", "brown", 150), 
					new Fish("Sardine", "black", 100), new Fish("Stingray", "black", 500),
					new Fish("Dogfish", "white", 400), new Fish("Whale", "white", 1000),
					new Fish("Dolphin", "white", 500));
			
		//task 4
			
			//Comparator<Fish> c= (Fish f1, Fish f2)-> f1.getLen().compareTo(f2.getLen());
			
			Comparator<Fish> c=(Fish f1, Fish f2)-> f1.getName().compareTo(f2.getName());
			inventory.sort(c);
			System.out.println("sorted inventory--");
			for(Fish f:inventory) {
				
			System.out.println(f.getName()+" ");
			//System.out.println(f.getLen());
			
			}
			
			inventory.set(3, new Fish("ArcticFish", "pink", 100));
			// here set will set this value at first position
			System.out.println("sorted inventory after altering the list--");
			for(Fish f:inventory) {
				
			System.out.println(f.getName()+" ");
			//System.out.println(f.getLen());
			
			}
		//1
			inventory.sort(new FishComparator());
			System.out.println(inventory);
			//2
			inventory.sort(new Comparator<Fish>() {

				@Override
				public int compare(Fish o1, Fish o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}	
			});
			System.out.println(inventory);
			//3
			inventory.sort((o1,o2)->o1.getLen().compareTo(o2.getLen()));
			System.out.println(inventory);
		
		//4
			inventory.sort(Comparator.comparing(Fish::getColor));
			System.out.println(inventory);
		
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

			public Integer getLen() {
				return len;
			}

			public void setLen(int len) {
				this.len = len;
			}
			
			public String toString() {
				return "Fish: [Name= "+name+", Color= "+color+", Length= "+len+"]";
			}
		}

		static class FishComparator implements Comparator<Fish>{

			@Override
			public int compare(Fish o1, Fish o2) {
				return o1.getLen().compareTo(o2.getLen());
			}
			
		}
	}
