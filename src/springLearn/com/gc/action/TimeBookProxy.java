package springLearn.com.gc.action;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import springLearn.com.gc.impl.TimeBookInterface;

public class TimeBookProxy {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private TimeBookInterface timeBookInterface;
	
	public TimeBookProxy(TimeBookInterface timeBookInterface) {
		this.timeBookInterface = timeBookInterface;
	}
	
	public void doAuditing(String name) {
		logger.log(Level.INFO, name + " ��ʼ�������...");
		timeBookInterface.doAuditing(name);
		logger.log(Level.INFO,  name + " ������ݽ���������");
	}
}
