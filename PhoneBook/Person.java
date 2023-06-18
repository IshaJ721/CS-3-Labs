public class Person {
	public String name;

	public Person(String name) {
		this.name = name;
	}

	/*
	 * public int hashCode() { int sum = 0; for(int i = 0; i<name.length(); i++)
	 * sum+=name.charAt(i); return sum; }
	 */
	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Person o) {
		return this.name.equals(o.name);
	}
}
