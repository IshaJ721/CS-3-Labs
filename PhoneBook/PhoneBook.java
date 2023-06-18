import java.util.Hashtable;


public class PhoneBook implements IMap {
	int size = 0;
	private Entry[] array;

	public class Entry {
		public Entry next;
		public Person name;
		public PhoneNumber num;

		public Entry(Person key, PhoneNumber value, Entry next) {
			name = key;
			num = value;
			this.next = next;
		}

		public boolean equals(Entry o) {
			return this.num == o.num && this.name == o.name;
		}
	}

	public PhoneBook(int capacity) {
		array = new Entry[capacity];
	}

	@Override
	public PhoneNumber put(Person key, PhoneNumber value) {
		if (key == null) {
			return null;
		}
		if (array[hash(key)] == null) {
			array[hash(key)] = new Entry(key, value, null);
			size++;
		}

		else {
			Entry current = array[hash(key)];
			while (current != null) {
				if (key.equals(current.name)) {
					PhoneNumber val = current.num;
					current.num = value;
					return val;
				}
				current = current.next;
			}

			current = array[hash(key)];
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Entry(key, value, null);
			size++;
		}
		return null;
	}

	@Override
	public PhoneNumber get(Person key) {
		int hash = hash(key);
		if (array[hash] == null) {
			return null;
		} else {
			Entry temp = array[hash];
			while (temp != null) {
				if (temp.name.equals(key))
					return temp.num;
				temp = temp.next;
			}
			return null;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public PhoneNumber remove(Person key) {
		if (key == null) {
			return null;
		}
		if (array[hash(key)] == null) {
			return null;
		}

		if (array[hash(key)].name.equals(key)) {
			PhoneNumber val = array[hash(key)].num;
			size--;
			array[hash(key)] = array[hash(key)].next;
			return (PhoneNumber) val;
		}

		else {
			Entry current = array[hash(key)];
			while (current.next != null) {
				if (key.equals(current.next.name)) {
					PhoneNumber val = current.next.num;
					current.next = current.next.next;
					size--;
					return val;
				}
				current = current.next;
			}
		}
		return null;
	}

	public int hash(Person key) {
		return Math.abs(key.hashCode() % array.length);
	}

}
