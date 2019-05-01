package queue;

public class EmptyQueueException extends RuntimeException {
	EmptyQueueException(String s) {
		super(s);
	}
}
