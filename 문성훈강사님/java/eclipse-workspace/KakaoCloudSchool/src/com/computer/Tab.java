package com.computer;

public class Tab extends Computer implements Graphic {
	Tab() {
		
	}
	
	Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}
	
	@Override
	public double rendering(int size) {
		System.out.println(size/(this.getCpu() * this.getMemory()) * 30);
		return (size/(this.getCpu() * this.getMemory()) * 30);
	}

	@Override
	public void operate(int time) {
		int btry = this.getBattery();
		System.out.println(time / 10);
		this.setBattery(btry - (time / 10));
	}
}
