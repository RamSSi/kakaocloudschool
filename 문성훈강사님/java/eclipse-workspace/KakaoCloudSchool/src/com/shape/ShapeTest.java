package com.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<>();
		list.add(new Rectangle(4, 7, 5));
		list.add(new Rectangle(5, 4, 6));
		list.add(new Circle(6, 6, 7));
		list.add(new Circle(7, 8, 3));
		
		System.out.println("구분\t\t" + "길이\t" + "X좌표\t" + "Y좌표\t" + "Area\t" + "Circumference");
		for (Shape s : list) {
			System.out.println(s + "\t" + ((int)s.getArea()) + "\t" + ((int)s.getCircumference()) + "\t");
		}
		
		System.out.println("이동 후...");
		for (Shape s : list) {
			((Movable)s).move(10, 10);
			System.out.println(s + "\t");
		}
	}

}
