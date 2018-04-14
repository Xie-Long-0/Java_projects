package component;

public class Circle
{
	final public static double PI = 3.14159265;
	double radius;

	public Circle(double _radius) {
		radius = _radius;
	}

	public double getArea() {
		return (radius * radius * PI);
	}

	public double getPerimeter() {
		return (2 * radius * PI);
	}
}