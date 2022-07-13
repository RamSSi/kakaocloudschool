package com.computer;

public class Laptop extends Computer implements Graphic {
	Laptop() {
		
	}
	
	Laptop(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}
	
	@Override
	public void operate(int time) {
		int btry = this.getBattery();
		System.out.println(time / 10);
		this.setBattery(btry - (time / 10));
	}
	
	@Override
	public double rendering(int size) {
		return size/(this.getCpu() * this.getMemory()) * 20;
	}
}