public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
     if(x<0) return -1; 
     if(x==0) return 0; 
     int pre=1, current=1;
     while(!(current<=x/current && (current+1)>x/(current+1)))
     {
         if(current<x/current)
         {
             pre=current;
             current=current<<1; 
         }else
         {
             current=pre+(current-pre)/2;
         }
     }
     return current; 
    }
}


public class Solution {
    public int sqrt(int x) {
        if(x < 0) return -1;
        if(x < 2) return x;
        
        int low = 0, high = x;
        while(high-low >= 2) {
        	int mid = low + (high-low)/2;
        	int div = x / mid;
        	if(mid == div) return mid;
        	else if(mid < div) { 
        		low = mid;
        		high = div;
        	}
        	else {
        		low = div;
        		high = mid;
        	}
        }
        
        return low;
    }
}





















