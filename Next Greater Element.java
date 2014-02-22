//http://www.geeksforgeeks.org/next-greater-element/

public static void nextGreaterElement(int [] array)
  {
		if(array.length==0) return ;
		int [] nextArray=new int[array.length];
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(0);
		int index=1; 
		while(index!=array.length)
		{
			if(!stack.isEmpty())
			{
				int top=stack.peek();
				if(array[index]>array[top])
				{
					nextArray[top]=array[index];
					stack.pop();
				}else
				{
					stack.push(index);
					index++; 
				}
			}else
			{
				stack.push(index);
				index++; 
			}
		}
		while(!stack.isEmpty())
		{
			nextArray[stack.pop()]=-1; 
		}
		for(int i=0; i<array.length; i++)
		{
			System.out.println(nextArray[i]);
		}
	}
	
	
public class Solution {
	public int[] printNGE(int[] nums) {
		int n = nums.length;
		int[] nge = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < n; i++) {
			if(stack.isEmpty() || nums[stack.peek()] >= nums[i]) {
				stack.push(i);
			} else {
				int index = stack.pop();
				nge[index] = nums[index];
				i--;
			}
		}
		while(!stack.isEmpty()) {
			nge[stack.pop()] = -1;
		}
		return nge;
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
