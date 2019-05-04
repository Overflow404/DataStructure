package heap.min;

import heap.EmptyHeapException;
import heap.Heap;

import java.util.Arrays;

public class ResizableIntegerMinHeap implements Heap<Integer> {

	private int capacity;
	private int current;
	private Integer[] heap;



	public ResizableIntegerMinHeap(int initialCapacity) {
		capacity = initialCapacity;
		current = 0;
		heap = new Integer[capacity];
	}


	@Override
	public Integer peek() {
		if (current <= 0) {
			throw new EmptyHeapException("Cannot peek from an empty heap!");
		}
		return heap[0];
	}

	@Override
	public Integer poll() {
		if (current <= 0) {
			throw new EmptyHeapException("Cannot poll from an empty heap!");
		}

		int element = heap[0];
		heap[0] = heap[current - 1];
		current--;
		heapifyDown();
		return element;
	}

	@Override
	public Heap<Integer> add(Integer element) {
		if (element == null) {
			throw new NullPointerException("Null elements aren't allowed!");
		}

		ensureCapacity();
		heap[current] = element;
		current++;
		heapifyUp();
		return this;
	}

	@Override
	public int size() {
		return current;
	}

	private void ensureCapacity() {
		if (current == capacity - 1) {
			capacity = capacity * 2;
			heap = Arrays.copyOf(heap, capacity);
		}
	}

	private void heapifyUp() {
		int index = current - 1;
		while (hasParent(index) && parent(index) > heap[index]) {
			swap(getIndexOfparent(index), index);
			index = getIndexOfparent(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getIndexOfLeftChild(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getIndexOfRightChild(index);
			}

			if (heap[index] < heap[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}

			index = smallerChildIndex;
		}
	}

	private int getIndexOfLeftChild(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getIndexOfRightChild(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getIndexOfparent(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getIndexOfLeftChild(index) < current;
	}

	private boolean hasRightChild(int index) {
		return getIndexOfRightChild(index) < current;
	}

	private boolean hasParent(int index) {
		return getIndexOfparent(index) >= 0;
	}

	private Integer leftChild(int index) {
		return heap[getIndexOfLeftChild(index)];
	}

	private Integer rightChild(int index) {
		return heap[getIndexOfRightChild(index)];
	}

	private Integer parent(int index) {
		return heap[getIndexOfparent(index)];
	}

	private void swap(int first, int second) {
		heap[first] = heap[first] ^ heap[second];
		heap[second] = heap[second] ^ heap[first];
		heap[first] = heap[first] ^ heap[second];
	}
}
