public class PhoneNumber {
	int number;

	public PhoneNumber(int num) {
		number = num;
	}
	public String toString()
	{
		return "" + number;
	}
	public int hashCode()
	{
		return number;
	}

}
