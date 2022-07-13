package com.computer;

public class ComputerTest {

	public static void main(String[] args) {
		Computer arrays[] = new Computer[4];
		
		arrays[0] = new Laptop("Lap01", 2, 1024, 2000);
		arrays[1] = new Laptop("Lap02", 3, 2048, 2300);
		arrays[2] = new Tab("Tab01", 2, 1024, 1200);
		arrays[3] = new Tab("Tab02", 3, 2048, 1300);
		
		System.out.println("name\t" + "cpu\t" + "memory\t" + "battery");
		System.out.println("-------------------------------");
		
		for (Computer c : arrays) {
			System.out.println(c);
			c.operate(55);
		}
		
		for (Computer c : arrays) {
			System.out.println(c.toString() + String.format("%.2f", ((Graphic)c).rendering(100)));
		}
		
	}

}
