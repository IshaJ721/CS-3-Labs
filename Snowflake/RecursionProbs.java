import java.util.*;

public class RecursionProbs {

	public double sumReciprocals(double n) {
		if (n == 1)
			return 1;
		else
			return (1 / n) + sumReciprocals(n - 1);
	}

	public int productOfEvens(int n) {
		if (n == 1)
			return 2;
		else {
			return (2 * n) * productOfEvens(n - 1);
		}

	}

	public String conversion(int num, int base) {
		if (num/base==0)
			return num%base + "";
		else {

			return "" + conversion(num/base, base) + (num % base);
		}
	}

	public int matchingDigits(int a, int b) {
			if (a % 10 == b % 10 && a==0 || b==0)
				return 1;
			else if(a % 10 == b % 10)
			{
				return 1 + matchingDigits(a / 10, b / 10);
			}
			return 0;
		
	}

	public void doubleUp(Stack<Integer> nums) {
		if (!nums.isEmpty()) {
			int x = nums.pop();
			doubleUp(nums);
			nums.push(x);
			nums.push(x);
		}
		System.out.println(nums);

	}

	public void printThis(int n) {
		if (n == 1)
			System.out.print("*");
		else if (n == 2)
			System.out.print("**");
		else {
			System.out.print("<");
			printThis(n - 2);
			System.out.print(">");
		}

	}

	public void printNums2(int n) {
		if (n == 1)
			System.out.print("1");
		else if (n == 2)
			System.out.print("11");
		else {
			if (n % 2 == 0) {
				System.out.print(n / 2);
				printNums2(n - 2);
				System.out.print(n / 2);
			} else {
				System.out.print(n / 2 + 1);
				printNums2(n - 2);
				System.out.print(n / 2 + 1);
			}
		}
	}

}
