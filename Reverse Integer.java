public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean negative=x<0? true: false; 
        if(negative)x=-x;
        int num=0; 
        while(x!=0)
        {
            if((Integer.MAX_VALUE-x%10)/10<num) return negative? Integer.MIN_VALUE: Integer.MAX_VALUE; 
            num=10*num+x%10; 
            x=x/10; 
        }
        return negative? -num: num; 
    }
}


public class Solution {
    public int reverse(int x) {
    	if(x == 0) return 0;
        boolean negative = x < 0 ? true : false;
        if(negative) x = -x;
        while(x % 10 == 0) {
        	x /= 10;
        }
        int result = 0;
        while(x != 0) {
        	int lowDigit = x % 10;
        	result = result*10 + lowDigit;
        	x /= 10;
        }
        return negative ? -result : result;
    }
}


public class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;
        boolean negative = (x < 0 ? true : false);
        if(negative) x = -x;
        while(x % 10 == 0) {
            x /= 10;
        }
        int result = 0;
        while(x != 0) {
            int lowDigit = x % 10;
            if((Integer.MAX_VALUE-lowDigit)/10 < result) 
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result*10 + lowDigit;
            x /= 10;
        }
        return negative ? -result : result;
    }
}




















