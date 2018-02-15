package chap4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streamsin8 {
	
	
	public static void main(String[] args) {
	//	getVegDishesNamein7(Dishes.menu).forEach(System.out::println);
	//	System.out.println("------------------------");
		getVegDishesNamesin8(Dishes.menu).forEach(System.out::println);
		System.out.println("---------------------");
		getFirstThreeMeatDishes(Dishes.menu).forEach(System.out::println);
		
		//System.out.println(getHighestCaloryDish(Dishes.menu).get());
	}
/*
	public static List<String> getVegDishesNamein7(
			List<Dishes> names){
		List<Dishes> vegDishes= new ArrayList<>();
		for(Dishes d:names) {
			if(d.isVegetarian()==true) {
				vegDishes.add(d);
			}
		}
		List<String> vegDishNames= new ArrayList<>();
		for(Dishes d:vegDishes) {
			vegDishNames.add(d.getName());
		}
		
		return vegDishNames;
		
	}
	*/
	public static List<String> getFirstThreeMeatDishes(
			List<Dishes> mdish){
		return mdish.stream()
				.filter(d->d.isVegetarian()==false)
				.limit(3)
				.map(Dishes::getName)
				.sorted()
				.collect(Collectors.toList());
	}
	
	//public static Optional<Integer> hcal=Dishes.menu.stream().map(t->t.getCal()).max(Comparator.comparing(Dishes::getcal));
		
	
	
	public static List<String> getVegDishesNamesin8(
			List<Dishes> names){
		
		return names.stream()
				.filter(d->d.isVegetarian()==true)
				.map(Dishes::getName)
				.sorted()
				.collect(Collectors.toList());
	}
}
