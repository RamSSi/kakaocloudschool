package planetest;

abstract class Plane {
	
	String planeName;
	int fuelSize;
	
	Plane() {
		
	}
	
	Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	public void refuel(int fuel) {
		fuelSize += fuel;
	}
	
	public abstract void flight(int distance);
	public void printInfo() {
		System.out.printf("%-5s  %8d\n", this.planeName, this.fuelSize);
	}
}

class Airplane extends Plane {
	Airplane() {
		
	}
	
	Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	public void flight(int distance) {
		int n = (distance / 10) * 30;
		fuelSize -= n;
	}
}

class Cargoplane extends Plane {
	Cargoplane() {
		
	}
	
	Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	public void flight(int distance) {
		fuelSize -= (distance / 10) * 50;
	}
}

public class PlaneTest {
	public static void main(String[] args) {
		Airplane a = new Airplane("L747", 1000);
		Cargoplane c = new Cargoplane("C40", 1000);
		
		a.flight(100);
		c.flight(100);
		System.out.println("\n100 운항\nPlane    fuelSize\n" + "-----------------");
		a.printInfo();
		c.printInfo();
		
		a.refuel(200);
		c.refuel(200);
		System.out.println("\n200 주유\nPlane    fuelSize\n" + "-----------------");
		a.printInfo();
		c.printInfo();
		
	}

}
