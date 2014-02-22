public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return Integer.MIN_VALUE;
        int sum=A[0], max=A[0];
        for(int i=1; i<A.length; i++)
        {
            sum=Math.max(A[i], sum+A[i]);
            max=Math.max(max, sum);
        }
        return max; 
    }
}


public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int preSum = 0;
        for(int i = 0; i < A.length; i++) {
        	int curSum = A[i];
        	if(preSum > 0) curSum += preSum;
        	max = Math.max(max, curSum);
        	preSum = curSum;
        }
        return max;
    }
}
