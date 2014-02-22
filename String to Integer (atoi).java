public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length=str.length();
        if(length==0) return 0; 
        int index=0; 
        while(index<length && str.charAt(index)==' ')
        {
            index++; 
        }
        boolean negative=false; 
        if(str.charAt(index)=='-'||str.charAt(index)=='+' )
        {
            negative=str.charAt(index)=='-'? true: false;
            index++; 
        }
        int num=0; 
        for(int i=index; i<length; i++)
        {
            if(!(str.charAt(i)<='9'&&str.charAt(i)>='0')) break; 
            if((Integer.MAX_VALUE-(str.charAt(i)-'0'))/10<num) return negative? Integer.MIN_VALUE: Integer.MAX_VALUE;
            num=num*10+(str.charAt(i)-'0');
        }
        return negative? -num: num; 
    }
}


public class Solution {
    public int atoi(String str) {
        int len = str.length();
        int index = 0;
        while(index < len && str.charAt(index) == ' ') {
        	index++;
        }
        if(index == len) return 0;
        
        boolean negative = false;
        if(str.charAt(index) == '-' || str.charAt(index) == '+') {
        	if(str.charAt(index) == '-') negative = true;
        	index++;
        }
        
        int result = 0;
        for(int i = index; i < len; i++) {
        	char c = str.charAt(i);
        	if(c < '0' || c > '9') break;
        	if((Integer.MAX_VALUE - (c-'0')) / 10 < result)
        		return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	result = result*10 + (c-'0');
        }
        
        return negative ? -result : result;
    }
}


public class Solution {
    public int atoi(String str) {
        int len = str.length();
        int index = 0;
        while(index < len && str.charAt(index) == ' ') {
            index++;
        }
        if(index == len) return 0;
        boolean neg = false;
        if(str.charAt(index) == '-' || str.charAt(index) == '+') {
            if(str.charAt(index) == '-') neg = true;
            index++;
        }
        int result = 0;
        while(index < len) {
            int d = str.charAt(index)-'0';
            if(d < 0 || d > 9) break;
            if((Integer.MAX_VALUE-d)/10 < result)
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result*10 + d;
            index++;
        }
        return neg ? -result : result;
    }
}


//Program "atof", which means convert a string float (e.g. "345.44E-10") to an actual float 
//without using any existing Parse Float functions. This is not hard but gets messy.
//Implement atof function. eg., +3.5e-2, .03e1, 1e1, 0.0
public class Solution {
    public double atof(String str) {
        int len = str.length();
        int dotPos = -1;
        int ePos = len;
        for(int i = 0; i < len; i--) {
        	char c = str.charAt(i);
        	if(c == '.') dotPos = i;
        	if(c == 'e' || c == 'E') ePos = i;
        }
        
        double first = 0.0;
        if(dotPos == -1) first = atoi(str.substring(0, ePos));
        else {
        	first = atoi(str.substring(0, dotPos));
        	double sec = atoi(str.substring(dotPos+1, ePos));
        	first += sec * Math.pow(10, -(ePos-1-dotPos));
        }
        
        if(ePos == len) return first;
        else {
        	int second = atoi(str.substring(ePos+1, len));
        	first *= Math.pow(10, second);
        }
        return first;
    }
    
    private int atoi(String str) {
    	int len = str.length();
    	int index = 0;
    	while(index < len && (str.charAt(index) == '0' || str.charAt(index) == ' ')) {
    		index++;
    	}
    	if(index == len) return 0;
    	
    	boolean negative = false;
    	if(str.charAt(index) == '-' || str.charAt(index) == '+') {
    		if(str.charAt(index) == '-') negative = true;
    		index++;
    	}
    	
    	int result = 0;
    	while(index < len) {
    		int d = str.charAt(index) - '0';
    		if(d < 0 || d > 9) break;
    		if((Integer.MAX_VALUE-d)/10 < result) 
    			return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    		result = result*10 + d;
    		index++;
    	}
    	
    	return negative ? -result : result;
    }
}

























