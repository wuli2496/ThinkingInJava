package rule.pattern.test;

import java.lang.reflect.Constructor;

import junit.framework.TestCase;
import rule.pattern.Singleton;

public class TestSimpleSingleton extends TestCase 
{
	public TestSimpleSingleton(String name)
	{
		super(name);
	}
	
	public void testCreateSingleton()
	{
		Singleton s = Singleton.Instance();
		Singleton s2 = Singleton.Instance();
		
		assertSame(s, s2);
	}
	
	public void testNoPublicConstructors() throws Exception
	{
		Class singleton = Class.forName("Singleton");
		Constructor[] constructors = singleton.getConstructors();
		
		assertEquals("Singleton has public constructors.", 0, constructors.length);
	}
}
