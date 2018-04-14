package component;

public class Stool
{
	Cylinder top, middle, bottom;

	public Stool(double _topRadius, double _topHeight,
				double _midRadius, double _midHeight,
				double _botRadius, double _botHeight)
	{
		top = new Cylinder(_topRadius, _topHeight);
		middle = new Cylinder(_midRadius, _midHeight);
		bottom = new Cylinder(_botRadius, _botHeight);
	}

	public double getArea()
	{
		double surface_area;
		surface_area = top.getArea() - middle.getCircleArea()
					 + middle.getSideArea()
					 + bottom.getArea()	- middle.getCircleArea();
		return surface_area;
	}

	public double getVolume() {
		return (top.getVolume() + middle.getVolume() + bottom.getVolume());
	}
	
}
