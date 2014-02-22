public class Solution {
    public int evalRPN(String[] tokens) {
        int val = 0;
        Stack<Integer> nums = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
        	String token = tokens[i];
        	if(token.equals("+")) {
        		nums.push(nums.pop()+nums.pop());
        	} else if(token.equals("-")) {
        		int second = nums.pop();
        		int first = nums.pop();
        		nums.push(first-second);
        	} else if(token.equals("*")) {
        		nums.push(nums.pop()*nums.pop());
        	} else if(token.equals("/")) {
        		int second = nums.pop();
        		int first = nums.pop();
        		nums.push(first/second);
        	} else {
        		nums.push(Integer.parseInt(token));
        	}
        }
        return nums.pop();
    }
}