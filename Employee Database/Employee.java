import java.util.Random;

public class Employee {
	String name;
	int ID;

	public Employee(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}

	@Override
	public int hashCode() {
		return ID;
	}

	public boolean equals(Employee o) {
		return this.ID == o.ID&&this.name == o.name;
	}

	public String toString() {
		return this.name;
	}
}
