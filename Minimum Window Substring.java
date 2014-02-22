public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(T.length()==0) return T;
        if(S.length()==0) return S; 
        String result="";
        int minWindowSize=Integer.MAX_VALUE;
        int [] needToFind=new int[256];
        for(int i=0; i<T.length(); i++)
        {
            needToFind[T.charAt(i)]++;
        }
        int [] found=new int[256];
        int count=0;
        int start=0;
        for(int i=0; i<S.length(); i++)
        {
            if(needToFind[S.charAt(i)]==0) continue;
            found[S.charAt(i)]++;
            if(found[S.charAt(i)]<=needToFind[S.charAt(i)])
            count++; 
            if(count==T.length())
            {
                while(needToFind[S.charAt(start)]==0||needToFind[S.charAt(start)]<found[S.charAt(start)])
                {
                    if(needToFind[S.charAt(start)]<found[S.charAt(start)])
                    {
                        found[S.charAt(start)]--; 
                    }
                    start++;
                }
                if(i+1-start<minWindowSize)
                {
                    minWindowSize=i+1-start; 
                    result=S.substring(start,i+1);
                }
            }
        }
        return result;
    }
}



public class Solution {
    public String minWindow(String S, String T) {
        int sLength = S.length();
        int tLength = T.length();
        HashMap<Character, Integer> t = new HashMap<Character, Integer>();
        for(int i = 0; i < tLength; i++) {
        	char c = T.charAt(i);
        	if(!t.containsKey(c)) t.put(c, 1);
        	else t.put(c, t.get(c)+1);
        }
        
        int minLeft = 0, minRight = -1, min = Integer.MAX_VALUE, left = 0, count = 0;
        for(int i = 0; i < sLength; i++) {
        	char c = S.charAt(i);
        	if(!t.containsKey(c)) continue;
        	if(t.get(c) > 0) count++;
        	t.put(c, t.get(c)-1);
        	if(count == tLength) {
        		char lc = S.charAt(left);
        		while(!t.containsKey(lc) || t.get(lc) < 0) {
        			if(t.containsKey(lc)) t.put(lc, t.get(lc)+1);    			
        			left++;
        			lc = S.charAt(left);
        		}
        		if(i-left+1 < min) {
        			minLeft = left;
        			minRight = i;
        			min = i-left+1;
        		}	
        	}
        }
        return S.substring(minLeft, minRight+1);       
    }
}


public class Solution {
    public String minWindow(String S, String T) {
        int slen = S.length(), tlen = T.length();
        if(slen == 0 || tlen == 0) return "";
        //assume ACSII string
        int[] tchars = new int[256];
        for(int i = 0; i < tlen; i++) {
            tchars[T.charAt(i)]++;
        }
        int[] found = new int[256];
        int minLeft = 0, minRight = -1, minLen = Integer.MAX_VALUE, left = 0, count = 0;
        for(int i = 0; i < slen; i++) {
            char c = S.charAt(i);
            if(tchars[c] == 0) continue;
            found[c]++;
            if(found[c] <= tchars[c]) count++;
            if(count == tlen) {
                char lc = S.charAt(left);
                while(tchars[lc] == 0 || found[lc] > tchars[lc]) {
                    if(tchars[lc] != 0) found[lc]--;
                    left++;
                    lc = S.charAt(left);
                }
                if(i-left+1 < minLen) {
                    minLeft = left;
                    minRight = i;
                    minLen = i-left+1;
                }
            }
        }
        return S.substring(minLeft, minRight+1);
    }
}

















