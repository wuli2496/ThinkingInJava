package springLearn.com.gc.action;

public interface CommandService {
	<R, T> R execute(int cmdType, T t);
}
