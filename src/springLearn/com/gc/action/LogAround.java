package springLearn.com.gc.action;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogAround implements MethodInterceptor{
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		logger.log(Level.INFO, invocation.getArguments()[0] + " 开始审核数据...");
		try {
			Object rval = invocation.proceed();
			return rval;
		} finally {
			logger.log(Level.INFO, invocation.getArguments()[0] + " 审核数据结束...");
		}
	}
}
