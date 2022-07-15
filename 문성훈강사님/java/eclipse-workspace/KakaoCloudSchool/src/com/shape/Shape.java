package com.shape;

public abstract class Shape {
	protected Point point;
	
	Shape() {
		
	}
	
	Shape(Point point) {
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(int x, int y) {
		this.point.setX(x);
		this.point.setY(y);
	}
	
	public abstract double getArea();
	public abstract double getCircumference();
}
