package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import appLabWork.Chap1Work;
import appLabWork.Chap1Work.Apple;


public class Chap1WorkTest {
	
	@Test
	void testisGreenApple() {
		boolean exp=true;
		boolean act;
		Apple apple=new Apple(80,"green");
		act=Chap1Work.isGreenApple(apple);
		assertEquals(exp, act);
	}
	
	@Test
	void testisLightApple() {
		boolean exp=true;
		boolean act;
		Apple apple=new Apple(80, "green");
		act= Chap1Work.isLightApple(apple);
		assertEquals(exp, act);
	}
	
	 @Test
	 void testgreenApples() {
		 Chap1Work ch= new Chap1Work();
		 List<Apple> inventory= Arrays.asList(new Apple(80,"green"),
					new Apple(150, "red"), new Apple(120, "green"), new Apple(155, "red"),
					new Apple(80, "red"), new Apple(120, "red"), new Apple(150, "green"));
		 assertEquals(Arrays.asList(new Apple(80, "green"),
				 new Apple(120, "green"),new Apple(150, "green")),ch.filterGreenApples(inventory));
	 
		 
	 }

	

}


