package springLearn.com.gc.action;

public interface ICommand<T, R> {
	
	int getCmdType();

	R execute(T t);
}
