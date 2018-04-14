package component;

public class Cylinder extends Circle
{
	double height;

	public Cylinder(double _radius, double _height)
	{
		super(_radius);
		height = _height;
	}

	//侧面积
	public double getSideArea() {
		return (getPerimeter() * height);
	}

	//底面积
	public double getCircleArea() {
		return super.getArea();
	}

	//表面积
	@Override
	public double getArea() {
		return (getCircleArea()*2 + getSideArea());
	}

	public double getVolume() {
		return (getCircleArea() * height);
	}

}
