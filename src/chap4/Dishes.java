package chap4;

import java.util.Arrays;
import java.util.List;

public class Dishes {
	
	private final String name;
	private final boolean vegetarian;
	private final int cal;
	private final Type type;
	
	public Dishes(String name, boolean vegetarian, int cal, Type type) {
		super();
		this.name = name;
		this.vegetarian = vegetarian;
		this.cal = cal;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCal() {
		return cal;
	}

	public Type getType() {
		return type;
	}
	
	public enum Type {MEAT, FISH, VEGETABLES}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public static final List<Dishes> menu= Arrays.asList(
			new Dishes("pulao", true,300,Dishes.Type.VEGETABLES),
			new Dishes("pork", false, 800, Dishes.Type.MEAT),
            new Dishes("beef", false, 700, Dishes.Type.MEAT),
            new Dishes("chicken", false, 400, Dishes.Type.MEAT),
            new Dishes("french fries", true, 530, Dishes.Type.VEGETABLES),
            new Dishes("rice", true, 350, Dishes.Type.VEGETABLES),
            new Dishes("season fruit", true, 120, Dishes.Type.VEGETABLES),
            new Dishes("pizza", true, 550, Dishes.Type.VEGETABLES),
            new Dishes("prawns", false, 400, Dishes.Type.FISH),
            new Dishes("salmon", false, 450, Dishes.Type.FISH));
	
	

}
