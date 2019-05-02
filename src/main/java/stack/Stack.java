package stack;

public interface Stack<T> {
	void push(T element);
	T pop();
	int length();
}
