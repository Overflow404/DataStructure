package queue;

public interface Queue<T> {
	void enqueue(T element);
	T dequeue();
	int length();
}
