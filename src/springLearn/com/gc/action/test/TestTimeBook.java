package springLearn.com.gc.action.test;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springLearn.com.gc.action.CommandService;
import springLearn.com.gc.action.LogProxy;
import springLearn.com.gc.action.TimeBook;
import springLearn.com.gc.action.TimeBookProxy;
import springLearn.com.gc.impl.TimeBookInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring.xml"})
public class TestTimeBook {
	
	@Autowired
	private CommandService commandService;
	
	@Test
	public void testTimeBook()
	{
		TimeBookProxy timeBookProxy = new TimeBookProxy(new TimeBook());
		timeBookProxy.doAuditing("����");
	}
	
	@Test
	public void testDynamicProxy()
	{
		LogProxy logProxy = new LogProxy();
		TimeBookInterface timeBookInterface = (TimeBookInterface)logProxy.bind(new TimeBook());
		timeBookInterface.doAuditing("����");
	}
	
	@Test
	public void testProxyFactoryBean()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		TimeBookInterface timeBookInterface = (TimeBookInterface)applicationContext.getBean("logProxy");
		timeBookInterface.doAuditing("����");
	}
	
	@Test
	public void testBeforeAdvisorProxyFactoryBean()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		TimeBookInterface timeBookInterface = (TimeBookInterface)applicationContext.getBean("logProxy2");
		timeBookInterface.doAuditing("����");
	}
	
	@Test
	public void testAfterAdvisorProxyFactoryBean()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		TimeBookInterface timeBookInterface = (TimeBookInterface)applicationContext.getBean("logProxy3");
		timeBookInterface.doAuditing("����");
	}
	
	@Test
	public void testThrowAdvisorProxyFactoryBean()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		TimeBookInterface timeBookInterface = (TimeBookInterface)applicationContext.getBean("logProxy4");
		timeBookInterface.doAuditing("����");
	}
	
	@Test
	public void testCommandService()
	{
		commandService.execute(1, 1);
	}
}
