package springLearn.com.gc.action;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LogAfter implements AfterReturningAdvice {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	@Override
	public void afterReturning(Object object, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		logger.log(Level.INFO, args[0] + " 审核数据完成。。。");
	}

}
