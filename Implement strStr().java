public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack.length() < needle.length()) return null;
        if(needle.length() == 0) return haystack;
         
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            String temp = haystack.substring(i, i+needle.length());
            if(temp.equals(needle)) return haystack.substring(i);
        }
        return null; 
    }
}


public class Solution {
    public String strStr(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        for(int i = 0; i <= h - n; i++) {
        	if(isValid(haystack, needle, i)) return haystack.substring(i);	
        }
        return null;
    }
    
    private boolean isValid(String haystack, String needle, int index) {
    	for(int i = 0; i < needle.length(); i++) {
    		if(haystack.charAt(index+i) != needle.charAt(i)) return false;
    	}
    	return true;
    }
}