public class EmployeeDatabase {
	int size;
	Employee[] hashset;

	public EmployeeDatabase() {
		size = 0;
		hashset = new Employee[11];
	}

	public EmployeeDatabase(int capacity) {
		size = 0;
		hashset = new Employee[capacity];
	}

	public boolean add(Employee key) throws Exception {
		if (size == hashset.length || key == null)
			return false;
		if (this.contains(key))
			return false;
		int index = key.hashCode() % hashset.length;
		for (int i = 0; i <= hashset.length; i++) {
			if (hashset[index] == null) {
				hashset[index] = key;
				size++;
				break;
			}
			// index++;
			index += Math.pow(i, 2);
			if (index >= hashset.length)
				index = 0;
		}
		return true;
	}

	public boolean contains(Employee key) {
		if (hashset[key.hashCode()%hashset.length] == null||key==null)
			return false;
		int index = key.hashCode() % hashset.length;
		if(hashset[index] != null && hashset[index].equals(key))
			return true;
		for(int i = 0; i <= hashset.length; i++)
		{
			//index++;
			index += Math.pow(i, 2);
			if(i == hashset.length)
				return false;
			if(index >= hashset.length)
				index = 0;
			if(hashset[index] != null && hashset[index].equals(key))
				return true;
		}
		return false;
	}

	public boolean remove(Employee key) {
		if (key==null||!contains(key))
			return false;
		int index = key.hashCode() % hashset.length;
		for(int i = 0; i <= hashset.length; i++)
		{
			if(hashset[index].equals(key))
			{
				hashset[index] = null;
				break;
			}
			//index++;
			index += Math.pow(i, 2);
			if(index >= hashset.length)
				index = 0;
		}
		Employee[] x = hashset;
		hashset = new Employee[hashset.length];
		size = 0;
		for(int i = 0; i < hashset.length; i++)
		{
			if(x[i] != null)
				try {
					add(x[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return true;
	}

	public int size() {
		return size;
	}

	public String toString() {
		String s = "";
		for (Employee e : hashset) {
			s += e + " ";
		}
		return s;
	}

}
