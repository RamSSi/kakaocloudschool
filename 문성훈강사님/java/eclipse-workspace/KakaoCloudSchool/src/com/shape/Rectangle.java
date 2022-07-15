package com.shape;

public class Rectangle extends Shape implements Movable {
	private int width;
	
	Rectangle() {
		
	}
	
	Rectangle(int width, int x, int y) {
		super(new Point(x, y));
		this.width = width;
	}

	@Override
	public void move(int x, int y) {
		setPoint(this.point.getX() + x + 2, this.point.getY() + y + 2);
	}

	@Override
	public double getArea() {
		return Math.round(width * width);
	}

	@Override
	public double getCircumference() {
		return Math.round(4 * width);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public String toString() {
		return "Rectangle" + "\t" + this.width + "\t" + point.getX() + "\t" + point.getY();
	}
}
