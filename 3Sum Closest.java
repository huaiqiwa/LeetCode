public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int result=num[0]+num[1]+num[num.length-1];
        for(int i=0; i<num.length; i++)
        {
            int start=i+1, end=num.length-1;
            while(start<end)
            {
                int sum=num[i]+num[start]+num[end];
                if(Math.abs(result-target)>Math.abs(sum-target))
                {
                    result=sum; 
                    if(result==target) return target; 
                }
                if(sum>target)
                {
                    end--; 
                }else
                {
                    start++; 
                }
            }
        }
        return result; 
        
    }
}


public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int len = num.length;
        int result = num[0] + num[1] + num[len-1];
        for(int i = 0; i < len-2; i++) {
        	if(i != 0 && num[i] == num[i-1]) continue;
        	int start = i+1, end = len-1;
        	while(start < end) {
        		int sum = num[i] + num[start] + num[end];
        		if(Math.abs(sum-target) < Math.abs(result-target)) result = sum; 
        		if(sum == target) return target;
        		else if(sum > target) end--;
        		else start++;
        	}
        }
        return result;
    }
}






























