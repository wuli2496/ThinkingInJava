package springLearn.com.gc.action;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogProxy implements InvocationHandler {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Object delegate;
	
	public Object bind(Object delegate) {
		this.delegate = delegate;
		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
		Object result = null;
		try {
			logger.log(Level.INFO, args[0] + " 开始审核数据...");
			result = method.invoke(delegate, args);
			logger.log(Level.INFO, args[0] + " 审核数据结束...");
		} catch (Exception e) {
			logger.log(Level.INFO, e.toString());
		}
		
		return result;
    }
}
