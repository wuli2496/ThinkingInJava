package java8.streams;

public class Trader {
	private final String name;
	private final String city;
	
	public Trader(String n, String c)
	{
		this.name = n;
		this.city = c;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String toString()
	{
		return "Trader:" + name + " in " + city;
	}
}
