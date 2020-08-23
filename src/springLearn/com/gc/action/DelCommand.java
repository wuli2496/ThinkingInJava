package springLearn.com.gc.action;

import org.springframework.stereotype.Component;

@Component
public class DelCommand implements ICommand<Integer, Integer>{

	@Override
	public Integer execute(Integer reqeust) {
		// TODO Auto-generated method stub
		System.out.println("delCommand");
		return reqeust;
	}

	@Override
	public int getCmdType() {
		// TODO Auto-generated method stub
		return 1;
	}

}
