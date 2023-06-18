import java.util.Stack;


public class StackProbs {
	public Stack<Integer> doubleUp(Stack<Integer> nums)
	{
		Stack<Integer> helper = new Stack<Integer>();
		while(!nums.isEmpty())
		{
			int pushed = helper.push(nums.pop());
			helper.push(pushed);
		}
		while(!helper.isEmpty())
		{
			nums.push(helper.pop());
		}
		return nums;
	}
	public Stack<Integer> posAndNeg(Stack<Integer> nums)
	{
		Stack<Integer> helper1 = new Stack<Integer>();
		Stack<Integer> helper2 = new Stack<Integer>();
		while(!nums.isEmpty())
        {
        	if(nums.peek()>=0)
        		helper1.push(nums.pop());
        	if(nums.peek()<0)
        		helper2.push(nums.pop());
        }
		while(!helper2.isEmpty())
		{
			nums.push(helper2.pop());
		}
		while(!helper1.isEmpty())
		{
			nums.push(helper1.pop());
		}
		return nums;
	}
	public Stack<Integer> shiftByN(Stack<Integer> nums, int n)
	{
		Stack<Integer> helper1 = new Stack<Integer>();
		Stack<Integer> helper2 = new Stack<Integer>();
		for(int i = 0; i<nums.size();i++)
		{
			if(i<(nums.size()-n))
				helper1.push(nums.pop());
		}
		while(!nums.isEmpty())
		{
			helper2.push(nums.pop());
		}
		while(!helper1.isEmpty())
		{
			nums.push(helper1.pop());
		}
		while(!helper2.isEmpty())
		{
			nums.push(helper2.pop());
		}
		return nums;
	}
	public String reverseVowels(String str)
	{
		Stack<Character> vowels = new Stack<Character>();
		for(int i = 0; i<str.length(); i++)
		{
			if(str.charAt(i)==('a')||str.charAt(i)==('e')||str.charAt(i)==('i')||str.charAt(i)==('o')||str.charAt(i)==('u'))
				vowels.push(str.charAt(i));
		}
		for(int i = 0; i<str.length(); i++)
		{
			if(str.charAt(i)==('a')||str.charAt(i)==('e')||str.charAt(i)==('i')||str.charAt(i)==('o')||str.charAt(i)==('u'))
				str.replace(str.charAt(i),vowels.pop());
		}
		return str;
	}	
	public boolean bracketBalance(String s)
	{
		boolean balanced = true;
		Stack<Character> chars = new Stack<Character>();
		for(int i = 0; i<(s.length()/2); i++)
		{
			chars.push(s.charAt(i));
		}
		for(int i = (s.length()/2); i<(s.length()); i++)
		{
			balanced = (chars.pop()==s.charAt(i));
			if(balanced==false)
				break;
		}
		return balanced;
	}

}
