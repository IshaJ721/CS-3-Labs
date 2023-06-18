public class MyLinkedList {
	private ListNode head, tail;
	private int size;

	private class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}

		@Override
		public String toString() {
			return " " + this.val;
		}
	}

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public MyLinkedList(int val) {
		head = new ListNode(val);
		size = 1;
		tail = head;
	}

	public void add(int newVal) {
		if (head == null) {
			head = new ListNode(newVal);
			tail = head;
		} else {
			tail.next = new ListNode(newVal);
			tail = tail.next;
		}
		size++;
	}

	public boolean contains(int target) {
		ListNode current = head;
		boolean contains = false;
		while (contains == false && current != null) {
			if (current.val == target) {
				contains = true;
				break;
			} else
				current = current.next;
		}
		return contains;
	}

	public int get(int index) {
		int element = 0;
		int x = 0;
		if (index < size && index > -1) {
			ListNode current = head;
			while (current != null) {
				if (index == x) {
					element = current.val;
					break;
				}
				current = current.next;
				x++;
			}
		} else
			throw new IndexOutOfBoundsException();
		return element;
	}

	public int indexOf(int target) {
		ListNode current = head;
		int index = 0;
		boolean found = false;
		while (current != null) {
			if (current.val == target) {
				found = true;
				break;
			}
			index++;
			current = current.next;
		}
		if (found)
			return index;
		else
			return -1;
	}

	public void set(int newVal, int index) {
		if (index < size && index > -1) {
			ListNode current = head;
			int x = 0;
			while (current != null) {
				if (x == index) {
					current.val = newVal;
					break;
				}
				current = current.next;
				x++;
			}
		} else
			throw new IndexOutOfBoundsException();
	}

	public int size() {
		return size;
	}

	public int sizeRecursive() {
		return sizeRecursive(head);
	}

	private int sizeRecursive(ListNode current) {
		if (isEmpty())
			return 0;
		else {
			current = head;
			if (current.next == null)
				return 1;
			else
				return 1 + sizeRecursive(current.next);
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int remove(int index) {
		if (index < size && index > -1) {
			int x = 0;
			ListNode current;
			if(index == 0)
			{
				current = head;
				head = head.next;
			}
			else
			{
				ListNode prev = head;
				current = head.next;
			while (current != null) {
				if (x == (index-1)) {
					prev.next = current.next;
					break;
				}
				prev = current;
				current = current.next;
				x++;
			}
			if(index == size-1)
			{
				 tail = prev;
			}
			}
			size--;
			return current.val;
		} else
			throw new IndexOutOfBoundsException();
	}

	public void add(int newVal, int index) {
		if (index <= size && index > -1) {
			ListNode current = head.next;
			int x = 0;
			if (index == size) {
				add(newVal);
			} else if (index == 0) {
				ListNode insert = new ListNode(newVal);
				insert.next = head;
				head = insert;
				size++;
			} else {
				while (current != null) {
					if (x == index-2) {
						ListNode insert = new ListNode(newVal);
						insert.next = current.next;
						current.next = insert;
						break;
					}
					current = current.next;
					x++;
				}
				size++;
			}
		} else
			throw new IndexOutOfBoundsException();

	}

	@Override
	public String toString() {
		String list = "[";
		if (isEmpty())
			list += "]";
		else {
			list += head.val;
			ListNode current = head.next;
			while (current != null) {
				list += ", " + current.val;
				current = current.next;
			}
			list += "]";
		}
		return list;
	}

}
