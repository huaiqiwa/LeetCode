public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0) return true; 
        s=s.toLowerCase();
        int start=0, end=s.length()-1;
        while(start<end)
        {
            while(start<end && !(s.charAt(start)>='a' && s.charAt(start)<='z')&& !(s.charAt(start)>='0' && s.charAt(start)<='9'))
            {
                start++;
            }
            if(start>=end) break; 
            
            while(start<end && !(s.charAt(end)>='a' && s.charAt(end)<='z')&&!(s.charAt(end)>='0' && s.charAt(end)<='9'))
            {
                end--;
            }
            if(start>=end) break; 
            if(s.charAt(start)!=s.charAt(end)) return false; 
            start++; 
            end--; 
        }
        return true; 
    }

}


public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        s = s.toLowerCase();
        while(left < right) {
        	while(left < right && !checkChar(s, left)) left++;
        	while(left < right && !checkChar(s, right)) right--;
        	if(s.charAt(left) != s.charAt(right)) return false;
        	left++;
        	right--;
        }
        return true;
    }
    
    private boolean checkChar(String s, int i) {
    	char c = s.charAt(i);
    	return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}


public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
        	while(left < right && !checkChar(s, left)) left++;
        	while(left < right && !checkChar(s, right)) right--;
        	if(left == right) return true;
        	if(convertToLowerCase(s.charAt(left)) != convertToLowerCase(s.charAt(right))) 
        	    return false;
        	left++;
        	right--;
        }
        return true;
    }
    
    private boolean checkChar(String s, int i) {
    	char c = s.charAt(i);
    	return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    
    private char convertToLowerCase(char c) {
        if(c >= 'A' && c <= 'Z') c -= ('A'-'a');
        return c;
    }
}




























