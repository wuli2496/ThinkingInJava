package rule.pattern.factory;

public class ShapeFactoryImplementation implements ShapeFactory
{
	public Shape makeSquare()
	{
		return new Square();
	}	
	
	public Shape makeCircle()
	{
		return new Square();
	}
}
