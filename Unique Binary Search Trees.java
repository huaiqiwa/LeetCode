public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [] arrays=new int[n+1];
        return numT(n, arrays);
    }
    int numT(int n, int [] arrays)
    {
        if(n==0 )
        {
            arrays[n]=1; 
            return arrays[n]; 
        }
        if(arrays[n]!=0) return arrays[n]; 
        int sum=0; 
        for(int i=0; i<n; i++)
        {
            sum+=numT(i, arrays)*numT(n-i-1, arrays);
        }
        arrays[n]=sum; 
        return arrays[n];
    }
}


public class Solution {
    public int numTrees(int n) {
        if(n <= 0) return 0;
        int[] count = new int[n+1];
        count[0] = 1; count[1] = 1;
        for(int i = 2; i <= n; i++) {
        	for(int j = 0; j < i; j++) {
        		count[i] += count[j]*count[i-1-j];
        	}
        }
        return count[n];
    }
}


public class Solution {
    public int numTrees(int n) {
        if(n <= 0) return 0;
        int[] count = new int[n+1];
        count[0] = 1; count[1] = 1;
        for(int i = 2; i <= n; i++) {
        	for(int j = 0; j < i/2; j++) {
        		count[i] += count[j]*count[i-1-j]*2;
        	}
        	if(i%2 == 1) count[i] += count[i/2]*count[i/2];
        }
        return count[n];
    }
}





























