public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0) return 0; 
        int []P=new int[s.length()+1];
        P[0]=1; 
        for(int i=1; i<=s.length(); i++)
        {
            int c1=0; 
            if(s.charAt(i-1)!='0') c1=P[i-1]; //1 digit if i-1 is 0, then it cannot meet the criterion.
            int c2=0; 
            if(i-2>=0 && (s.charAt(i-2)=='1'|| (s.charAt(i-2)=='2' &&s.charAt(i-1)<='6'))) //2 digits
            c2=P[i-2];
            P[i]=c1+c2;
        }
        return P[s.length()];
    }
}


public class Solution {
    public int numDecodings(String s) {
    	if(s.length() == 0 || s.charAt(0) == '0') return 0;
    	if(s.length() == 1) return 1;
        int first = 1, second = 1, third = 0;
        for(int i = 1; i < s.length(); i++) {
        	if((s.charAt(i-1) < '1' || s.charAt(i-1) > '2') && s.charAt(i) == '0') return 0;
        	third = 0;
        	if(s.charAt(i) != '0') third += second; 
        	if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) third += first;    	
        	first = second;
        	second = third;
        }
        return third;
    }
}

















