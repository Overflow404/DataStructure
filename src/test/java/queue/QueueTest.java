package queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

	@Test (expected = NullPointerException.class)
	public void pushNullElement() {
		Queue queue = new Queue();
		queue.enqueue(null);
	}

	@Test (expected = QueueOverflowException.class)
	public void stackOverflowTest() {
		Queue queue = new Queue();

		for (int i = 0; i < 1024; i++) {
			queue.enqueue(i);
		}

		int extra = 0;
		queue.enqueue(extra);
	}

	@Test (expected = EmptyQueueException.class)
	public void popOnEmptyStackTest() {
		Queue queue = new Queue();
		queue.dequeue();
	}

	@Test
	public void lengthOfEmptyStackTest() {
		Queue queue = new Queue();
		Assert.assertEquals(0, queue.length());
	}

	@Test
	public void lengthTest() {
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		Assert.assertEquals(queue.length(), 3);
	}

	@Test
	public void popTest() {
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		Assert.assertEquals((int) queue.dequeue(), 1);
		Assert.assertEquals(queue.length(), 2);

		Assert.assertEquals((int) queue.dequeue(), 2);
		Assert.assertEquals(queue.length(), 1);

		Assert.assertEquals((int) queue.dequeue(), 3);
		Assert.assertEquals(queue.length(), 0);
	}
}
