public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length==0) return 0; 
        int i=0; 
        int max=0; 
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(0);
        while(i<height.length || !stack.isEmpty())
        {
            if(i<height.length &&( stack.isEmpty() || height[i]>=height[stack.peek()]))
            {
                stack.push(i); i++;
            }else
            {
                int top=stack.pop();
                max=Math.max(max, height[top]*(stack.isEmpty()? i: i-stack.peek()-1));
            }
        }
        return max; 
    }
}


public class Solution {
    public int largestRectangleArea(int[] height) {
    	int n = height.length;
        if(n == 0) return 0;
        Stack<Integer> indexStack = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
        	if(indexStack.isEmpty() || height[indexStack.peek()] < height[i]) {
        		indexStack.push(i);
        		continue;
        	}
        	if(height[indexStack.peek()] >= height[i]) {
        		int curHeight = height[indexStack.pop()];
        		int leftIndex = 0; 
        		if(!indexStack.isEmpty()) leftIndex = indexStack.peek()+1;
        		maxArea = Math.max(maxArea, (i-leftIndex)*curHeight);
        		i--;
        	}
        }
        while(!indexStack.isEmpty()) {
        	int curHeight = height[indexStack.pop()];
        	int leftIndex = 0;
        	if(!indexStack.isEmpty()) leftIndex = indexStack.peek()+1;
        	maxArea = Math.max(maxArea, (n-leftIndex)*curHeight);
        }
        return maxArea;
    }
}
































