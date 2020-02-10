package algo;

public interface InputPolicy<T>
{
	boolean hasNext();
	T next();
}
