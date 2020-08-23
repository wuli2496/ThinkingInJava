package springLearn.com.gc.action;

import org.springframework.stereotype.Component;

@Component
public class AddCommand implements ICommand<Integer, Integer> {


	@Override
	public int getCmdType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer execute(Integer t) {
		// TODO Auto-generated method stub
		System.out.println("addCommand");
		return t;
	}


}
