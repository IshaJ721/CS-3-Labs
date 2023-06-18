
public class MinHeap {
	Integer[] heap;
	int size;
	static final int DEFAULT_CAPACITY = 8;

	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}

	public MinHeap(int capacity) {
		this.size = 0;
		heap = new Integer[capacity + 1];
	}

	public MinHeap(Integer... nums) {
		size = nums.length;
		heap = new Integer[nums.length+1];
		buildHeap(nums);
	}

	public void buildHeap(Integer[] nums) {
		for(int i = 1; i<=nums.length; i++)
			heap[i] = nums[i-1];
		for(int i = size/2; i>0; i--)
			siftDown(i);
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int peekMinimum() {
		return heap[1];
	}

	public int getLeftChildIndex(int index) {
		return 2 * index;

	}

	public int getRightChildIndex(int index) {
		return 2 * index + 1;

	}

	public int getParentIndex(int index) {
		return index / 2;
	}

	private void doubleCapacity() {
		Integer[] temp = new Integer[(heap.length) * 2];
		for (int i = 1; i < heap.length; i++) {
			temp[i] = heap[i];
		}
		this.heap = temp;
	}

	void insert(int value) {
		if (size + 1 >= heap.length)
			doubleCapacity();
		heap[size + 1] = value;
		size++;
		bubbleUp(size);
	}

	private void bubbleUp(int index) {
		if (index == 0)
			return;
		if (size > 1 && getParentIndex(index) > 0) {
			if (heap[index] < heap[getParentIndex(index)]) {
				int temp = heap[getParentIndex(index)];
				heap[getParentIndex(index)] = heap[index];
				heap[index] = temp;

			}
			bubbleUp(getParentIndex(index));
		}
		return;
	}

	public int popMinimum() {
		int min = heap[1];
		heap[1] = heap[size];
		heap[size] = null;
		siftDown(1);
		size--;
		return min;
	}

	private void siftDown(int index) {
		if (index >= size)
			return;
		if (getLeftChildIndex(index) <= size && getRightChildIndex(index) < size) {
			int min = Math.min(heap[getLeftChildIndex(index)], heap[getRightChildIndex(index)]);
			if (heap[index] > min) {
				int newIndex = 0;
				int temp = heap[index];
				heap[index] = min;
				if (min == heap[getRightChildIndex(index)]) {
					heap[getRightChildIndex(index)] = temp;
					newIndex = getRightChildIndex(index);
				} else if (min == heap[getLeftChildIndex(index)]) {
					heap[getLeftChildIndex(index)] = temp;
					newIndex = getLeftChildIndex(index);
				}
				siftDown(newIndex);
			}
		} else
			return;
	}

	@Override
	public String toString() {
		String output = "";

		for (int i = 1; i <= getSize(); i++)
			output += heap[i] + ", ";

		return output.substring(0, output.lastIndexOf(",")); // lazily truncate last comma
	}

	/**
	 * method borrowed with minor modifications from the internet somewhere, for
	 * printing
	 */
	public void display() {
		int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
		String dots = "...............................";
		System.out.println(dots + dots);
		while (j <= this.getSize()) {
			if (column == 0)
				for (int k = 0; k < nBlanks; k++)
					System.out.print(' ');

			System.out.print((heap[j] == null) ? "" : heap[j]);

			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			} else
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');

			j++;
		}
		System.out.println("\n" + dots + dots);
	}

}