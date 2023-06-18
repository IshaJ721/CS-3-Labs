import java.util.Hashtable;

public class MyHashTable<K, V> {
	int size = 0;
	private Object[] array;

	public class Entry {
		public Entry next;
		public K name;
		public V num;

		public Entry(K key, V value, Entry next) {
			name = key;
			num = value;
			this.next = next;
		}

		public boolean equals(Entry o) {
			return this.num == o.num && this.name == o.name;
		}

		public V getNum() {
			return num;
		}

		public K getName() {
			return name;
		}

		public Entry getNext() {
			return next;
		}
	}

	public MyHashTable() {
		array = new Object[100];
	}

	public V put(K key, V value) {
		if (key == null) {
			return null;
		}
		if (array[hash(key)] == null) {
			array[hash(key)] = new Entry(key, value, null);
			size++;
		}

		else {
			Entry current = (MyHashTable<K, V>.Entry) array[hash(key)];
			while (current != null) {
				if (key.equals(current.name)) {
					V val = current.num;
					current.num = value;
					return val;
				}
				current = current.next;
			}

			current = (MyHashTable<K, V>.Entry) array[hash(key)];
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Entry(key, value, null);
			size++;
		}
		return null;
	}

	public V get(K key) {
		int hash = hash(key);
		if (array[hash] == null) {
			return null;
		} else {
			Entry temp = (MyHashTable<K, V>.Entry) array[hash];
			while (temp != null) {
				if (temp.name.equals(key))
					return temp.num;
				temp = temp.next;
			}
			return null;
		}
	}

	public int size() {
		return this.size;
	}

	public V remove(K key) {
		if (key == null) {
			return null;
		}
		if (((MyHashTable<K, V>.Entry) array[hash(key)] == null)) {
			return null;
		}

		if (((MyHashTable<K, V>.Entry) array[hash(key)]).name.equals(key)) {
			V val = ((MyHashTable<K, V>.Entry) array[hash(key)]).num;
			size--;
			array[hash(key)] = ((MyHashTable<K, V>.Entry) array[hash(key)]).next;
			return (V) val;
		}

		else {
			Entry current = (MyHashTable<K, V>.Entry) array[hash(key)];
			while (current.next != null) {
				if (key.equals(current.next.name)) {
					V val = current.next.num;
					current.next = current.next.next;
					size--;
					return (V) val;
				}
				current = current.next;
			}
		}
		return null;
	}

	public int hash(K key) {
		return Math.abs(key.hashCode()) % array.length;
	}

}