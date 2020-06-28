package springLearn.com.gc.action.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springLearn.com.gc.action.LogProxy;
import springLearn.com.gc.action.TimeBook;
import springLearn.com.gc.action.TimeBookProxy;
import springLearn.com.gc.impl.TimeBookInterface;

public class TestTimeBook {
	
	@Test
	public void testTimeBook()
	{
		TimeBookProxy timeBookProxy = new TimeBookProxy(new TimeBook());
		timeBookProxy.doAuditing("张三");
	}
	
	@Test
	public void testDynamicProxy()
	{
		LogProxy logProxy = new LogProxy();
		TimeBookInterface timeBookInterface = (TimeBookInterface)logProxy.bind(new TimeBook());
		timeBookInterface.doAuditing("张三");
	}
	
	@Test
	public void testProxyFactoryBean()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		TimeBookInterface timeBookInterface = (TimeBookInterface)applicationContext.getBean("logProxy");
		timeBookInterface.doAuditing("张三");
	}
	
	@Test
	public void testBeforeAdvisorProxyFactoryBean()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		TimeBookInterface timeBookInterface = (TimeBookInterface)applicationContext.getBean("logProxy2");
		timeBookInterface.doAuditing("张三");
	}
	
	@Test
	public void testAfterAdvisorProxyFactoryBean()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		TimeBookInterface timeBookInterface = (TimeBookInterface)applicationContext.getBean("logProxy3");
		timeBookInterface.doAuditing("张三");
	}
	
	@Test
	public void testThrowAdvisorProxyFactoryBean()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		TimeBookInterface timeBookInterface = (TimeBookInterface)applicationContext.getBean("logProxy4");
		timeBookInterface.doAuditing("张三");
	}
}
