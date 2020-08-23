package springLearn.com.gc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceImpl implements CommandService, InitializingBean {

	@Autowired
	private List<ICommand<?, ?>> commands;
	
	private Map<Integer, ICommand<?, ?>> cmdMap = new HashMap<>();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		for (ICommand<?, ?> command : commands) {
			cmdMap.put(command.getCmdType(), command);
		}
	}


	@Override
	public <R, T> R execute(int cmdType, T t) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ICommand<T, R>  command = (ICommand<T, R>)cmdMap.get(cmdType);
		System.out.println("command:" + command.getCmdType());
		return command.execute(t);
	}
	
}
