package queue;

public class QueueOverflowException extends RuntimeException {
	QueueOverflowException(String s) {
		super(s);
	}
}
