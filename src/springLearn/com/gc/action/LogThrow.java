package springLearn.com.gc.action;


import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class LogThrow implements ThrowsAdvice {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public void afterThrowing(Method method, Object[] args, Object target, Throwable subclass) throws Throwable
	{
		logger.log(Level.INFO, args[0] + "审核数据有异常抛出。。。");
	}
}
