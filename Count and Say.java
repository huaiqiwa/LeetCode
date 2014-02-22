public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String result=""; 
        if(n==0) return result; 
        result="1"; 
        if(n==1) return result;
        int count=1; 
        for(int i=1; i<n; i++)
        {
            StringBuffer sb=new StringBuffer(); 
            for(int j=0; j<result.length(); j++)
            {
                while(j<result.length()-1 && result.charAt(j)==result.charAt(j+1))
                {
                    count++; 
                    j++; 
                }
                sb.append(Integer.toString(count)+result.charAt(j));
                count=1; 
            }
            result=sb.toString(); 
        }
        return result; 
    }
}


public class Solution {
    public String countAndSay(int n) {
    	if(n == 0) return "";
        StringBuilder result = new StringBuilder();
        StringBuilder nextResult = new StringBuilder();
        result.append(1);
        for(int i = 1; i < n; i++) {
        	for(int j = 0; j < result.length(); ) {
        		char c = result.charAt(j);
        		int count = 1;
        		j++;
        		while(j < result.length() && result.charAt(j) == c) {
        			count++;
        			j++;
        		}
        		nextResult.append(count);
        		nextResult.append(c);
        	}
        	StringBuilder temp = result;
        	result = nextResult;
        	nextResult = temp;
        	nextResult.delete(0, nextResult.length());
        }
        return result.toString();
    }
}































