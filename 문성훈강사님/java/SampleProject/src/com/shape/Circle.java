package com.shape;

public class Circle extends Shape implements Movable {
	private int radius;
	
	Circle() {
		
	}
	
	Circle(int radius, int x, int y) {
		super(new Point(x, y));
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.round(radius * radius * Math.PI);
	}

	@Override
	public double getCircumference() {
		return Math.round(2 * radius * Math.PI);
	}

	@Override
	public void move(int x, int y) {
		setPoint(this.point.getX() + x + 1, this.point.getY() + y + 1);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "Circle" + "\t\t" + this.radius + "\t" + point.getX() + "\t" + point.getY();
	}
}
