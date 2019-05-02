package heap.min;

import heap.EmptyHeapException;
import org.junit.Assert;
import org.junit.Test;

public class ResizableIntegerMinHeapTest {

	@Test
	public void emptyHeapSizeTest() {
		ResizableIntegerMinHeap heap = new ResizableIntegerMinHeap(4);
		Assert.assertEquals(0, heap.size());
	}

	@Test
	public void addWithoutResizeTest() {
		ResizableIntegerMinHeap heap = new ResizableIntegerMinHeap(4);
		heap.add(1).add(2).add(3);

		Assert.assertEquals(3, heap.size());
	}

	@Test
	public void addWithResizeTest() {
		ResizableIntegerMinHeap heap = new ResizableIntegerMinHeap(4);
		heap.add(6).add(12).add(5).add(14).add(0).add(17);
		Assert.assertEquals(6, heap.size());
	}

	@Test (expected = NullPointerException.class)
	public void addNullElements() {
		ResizableIntegerMinHeap heap = new ResizableIntegerMinHeap(4);
		heap.add(1).add(null);
	}

	@Test (expected = EmptyHeapException.class)
	public void peekOnEmptyHeapTest() {
		ResizableIntegerMinHeap heap = new ResizableIntegerMinHeap(4);
		heap.peek();
	}

	@Test
	public void peekTest() {
		ResizableIntegerMinHeap heap = new ResizableIntegerMinHeap(4);
		heap.add(6).add(5).add(4).add(3).add(2).add(1);

		Assert.assertEquals(6, heap.size());

		Integer peeked = heap.peek();

		Assert.assertEquals(6, heap.size());
		Assert.assertEquals(1, (int) peeked);
	}

	@Test (expected = EmptyHeapException.class)
	public void pollOnEmptyHeapTest() {
		ResizableIntegerMinHeap heap = new ResizableIntegerMinHeap(4);
		Assert.assertEquals(0, heap.size());
		heap.poll();
	}

	@Test
	public void pollTest() {
		ResizableIntegerMinHeap heap = new ResizableIntegerMinHeap(4);
		heap.add(6).add(4).add(23).add(3).add(2).add(5).add(13).add(3);

		int initialSize = 8;

		Assert.assertEquals(initialSize, heap.size());

		Integer polled = heap.poll();
		initialSize--;
		Assert.assertEquals(initialSize, heap.size());
		Assert.assertEquals(2, (int) polled);

		polled = heap.poll();
		initialSize--;
		Assert.assertEquals(initialSize, heap.size());
		Assert.assertEquals(3, (int) polled);

		polled = heap.poll();
		initialSize--;
		Assert.assertEquals(initialSize, heap.size());
		Assert.assertEquals(3, (int) polled);
	}
}
