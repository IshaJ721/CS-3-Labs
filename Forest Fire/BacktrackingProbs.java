import java.util.Arrays;
import java.util.List;

public class BacktrackingProbs {

	public void printBinary(int digits) {
		printBinaryHelper(digits, "");
	}
	private void printBinaryHelper(int digits, String soFar)
	{
		if(soFar.length()==digits)
			System.out.print(soFar + " ");
		else
		{
			printBinaryHelper(digits, soFar + 0);
			printBinaryHelper(digits, soFar + 1);
		}
	}
	public void climbStairs(int steps)
	{
		climbStairs(steps, 0, "");
	}
	private void climbStairs(int steps, int eachStair, String string)
	{
		if(eachStair==steps)
			System.out.println(string);
		else
		{
			if(eachStair<3)
			{
				climbStairs(steps, eachStair + 1, string + "1, ");
				if(eachStair<2)
				climbStairs(steps, eachStair + 2, string + "2, ");
				else
				climbStairs(steps, eachStair + 2, string + "2 ");
			}
			else if(eachStair<=3)
			{
				climbStairs(steps, eachStair + 1, string + "1 ");
				climbStairs(steps, eachStair + 2, string + "2 ");
			}
		}
	}
	public void campsite(int x, int y)
	{
		campsite(x, y, 0, 0, "");
	}
	private void campsite(int x, int y, int xNow, int yNow, String soFar)
	{
		if(x==xNow && y==yNow)
			System.out.println(soFar);
		else
		{
			if(xNow<x&&yNow<y)
				campsite(x, y, xNow+1, yNow+1, soFar + " NE");
			if(xNow<x)
				campsite(x, y, xNow+1, yNow, soFar + " E");
			if(yNow<y)
				campsite(x, y, xNow, yNow+1, soFar + " N");
		}
	}
	private static int getMax(List<Integer> nums, int size, int limit, int maxSum) {
        if (size == 0) {
            return 0;
        }
        int yes = nums.get(size - 1) + getMax(nums, size - 1, limit, maxSum + nums.get(size - 1));
        int no = getMax(nums, size - 1, limit, maxSum);
        if (yes <= limit && (limit - yes) < limit - no) {
            return yes;
        } else {
            return no;
        }
    }

    public static int getMax(List<Integer> nums, int limit) {
        return getMax(nums, nums.size(), limit, 0);
    }

}
