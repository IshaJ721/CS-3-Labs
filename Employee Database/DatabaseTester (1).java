public class DatabaseTester {

	public static void main(String[] args) {
		test00add();
		test01contains();
		test02remove();
	}

	public static void test00add() {
		/*
		 * make sure your default capacity is 11 before running this test!
		 */
		EmployeeDatabase set = new EmployeeDatabase();
		try {
			set.add(new Employee("Ron", 111111));
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(set); // should show only Ron the array

		try {
			set.add(new Employee("Charlie", 222222));
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(set); // should show Charlie and Ron in the array

		try {
			System.out.println(set.add(new Employee("Charlie", 222222)));
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} // should print false

		for (char i = 97, j = 0; j < 10; i++, j++) { // should reject two entries
			try {
				if (!set.add(new Employee("" + i, j)))
					System.out.println("false");

			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			} // as the hash table is full
		}

		System.out.println(set); // should show a completely full array
		System.out.println(set.size());
	}

	public static void test01contains() {
		EmployeeDatabase set = new EmployeeDatabase();
		try {
			set.add(new Employee("Ron", 111111));
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(set.contains(new Employee("Ron", 111111))); // should print true
		System.out.println(set.contains(new Employee("Ron", 222222))); // should print false
		System.out.println(set.contains(new Employee("R0n", 111111))); // should print false
	}

	public static void test02remove() {
		EmployeeDatabase set = new EmployeeDatabase();
		try {
			set.add(new Employee("Ron", 111111));
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(set); // should show only Ron the array

		try {
			set.add(new Employee("Charlie", 222222));
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(set); // should show Charlie and Ron in the array

		set.remove(new Employee("Ron", 111111));

		System.out.println(set); // should only show Charlie in the array

		System.out.println(set.remove(new Employee("Ron", 111111))); // should print false
	}
}
