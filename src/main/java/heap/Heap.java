package heap;

public interface Heap<T> {
	T peek();
	T poll();
	Heap<T> add(T element);
	int size();
}
