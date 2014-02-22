import java.util.*; 
public class Solution {
public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Integer> set=new HashSet<Integer>();
        int max=0; 
        for(int i=0; i<num.length; i++)
        {
            set.add(num[i]);
        }
        for(int i=0; i<num.length;i++)
        {
            if(set.contains(num[i]))
            {
                int count1=0, count2=0; 
                while(set.contains(num[i]+1+count1))
                {
                    set.remove(num[i]+1+count1);
                    count1++; 
                }
                while(set.contains(num[i]-1-count2))
                {
                    set.remove(num[i]-1-count2);
                    count2++; 
                }
               max=Math.max(max, count1+count2+1);
               set.remove(num[i]);
            }
        }      
        return max; 
    }
}


public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> nums = new HashMap<Integer, Boolean>();
        for(int i = 0; i < num.length; i++) {
        	nums.put(num[i], false);
        }
        int maxCount = 0;
        int count = 1;
        for(int n : nums.keySet()) {
        	if(nums.get(n)) continue;
        	nums.put(n, true);
        	for(int i = n+1; nums.containsKey(i); i++) {
        		nums.put(i, true);
        		count++;
        	}
        	for(int i = n-1; nums.containsKey(i); i--) {
        		nums.put(i, true);
        		count++;
        	}
        	maxCount = Math.max(maxCount, count);
        	count = 1;
        }
        return maxCount;
    }
}































