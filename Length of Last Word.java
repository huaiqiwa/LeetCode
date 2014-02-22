public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0) return 0; 
        String [] arrays=s.split(" ");
        int length=arrays.length; 
        if(length==0) return 0; 
        return arrays[length-1].length(); 
    }
}


public class Solution {
    public int lengthOfLastWord(String s) {
    	int count = 0;
    	boolean found = false;
        for(int i = s.length()-1; i >= 0; i--) {
        	char c = s.charAt(i);
        	if(!found) {
        		if(c == ' ') continue;
        		found = true;
        		count++;
        	} else {
        		if(c == ' ') break;
        		count++;
        	}
        }
        return count;
    }
}