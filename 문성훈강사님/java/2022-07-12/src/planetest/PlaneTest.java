package planetest;

abstract class Plane {

	private String planeName;
	private int fuelSize;

	Plane() {

	}

	Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
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
		this.setPlaneName(planeName);
		this.setFuelSize(fuelSize);
	}

	@Override
	public int getFuelSize() {
		// TODO Auto-generated method stub
		return super.getFuelSize();
	}
	@Override
	public String getPlaneName() {
		// TODO Auto-generated method stub
		return super.getPlaneName();
	}
	@Override
	public void setFuelSize(int fuelSize) {
		// TODO Auto-generated method stub
		super.setFuelSize(fuelSize);
	}
	@Override
	public void setPlaneName(String planeName) {
		// TODO Auto-generated method stub
		super.setPlaneName(planeName);
	}
	public void flight(int distance) {
		int n = (distance / 10) * 30;
		this.setFuelSize(this.getFuelSize() - n);
	}
}

class Cargoplane extends Plane {
	Cargoplane() {

	}

	Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public int getFuelSize() {
		// TODO Auto-generated method stub
		return super.getFuelSize();
	}
	@Override
	public String getPlaneName() {
		// TODO Auto-generated method stub
		return super.getPlaneName();
	}
	@Override
	public void setFuelSize(int fuelSize) {
		// TODO Auto-generated method stub
		super.setFuelSize(fuelSize);
	}
	@Override
	public void setPlaneName(String planeName) {
		// TODO Auto-generated method stub
		super.setPlaneName(planeName);
	}

	public void flight(int distance) {
		int n = (distance / 10) * 50;
		this.setFuelSize(this.getFuelSize() - n);
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
