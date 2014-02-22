public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        /*using long type is because Math.abs(Integer.MIN_VALUE) is still Integer.MIN_VALUE;
        Integer.MIN_VALUE: -2147483648
        Integer.MAX_VALUE:  2147483647
        */
        long a=Math.abs((long )dividend);
        long b=Math.abs((long )divisor);
        boolean negative=false; 
        if(dividend<0) negative=!negative; 
        if(divisor<0) negative=!negative; 
        int result=0;
        while(a>=b)
        {
            long c=b; 
            for(int i=0; a>=c ; i++, c<<=1 )
            {
                a-=c; 
                result+=1<<i;
            }
        }
        return negative? -result: result; 
    }
}


public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) 
        	throw new IllegalArgumentException();
        if(dividend == 0 || divisor == 1) return dividend;
        if(divisor == -1) return -dividend;
        
        long divd = Math.abs((long)dividend), divs = Math.abs((long)divisor);
        ArrayList<Long> divisors = new ArrayList<Long>();
        while(divs <= divd) {
        	divisors.add(divs);
        	divs = divs << 1;
        }
        
        int result = 0;
        for(int i = divisors.size()-1; i >= 0 && divd > 0; i--) {
        	long curDivs = divisors.get(i);
        	while(divd >= curDivs) {
        		divd -= curDivs;
        		result += 1<<i;
        	}
        }
        
        return (dividend>0)^(divisor>0) ? -result : result;
    }
}






















