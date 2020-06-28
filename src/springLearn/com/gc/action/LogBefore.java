package springLearn.com.gc.action;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogBefore implements MethodBeforeAdvice {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		logger.log(Level.INFO, args[0] + " 开始审核数据。。。");
	}

}
