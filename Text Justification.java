public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index=0;
        int start=0; 
        int length=0; 
        ArrayList<String> result=new ArrayList<String>(); 
        if(words.length==0) return result; 
        while(index<words.length)
        {
            if((length+words[index].length())<=L)
            {
                length+=(words[index].length()+1);
                index++; 
            }else
            {
                if(index==start+1)
                {
                    int rest=L-words[start].length();
                    String lineResult=words[start];
                    while(rest>0)
                    {
                        lineResult+=" ";  rest--; 
                    }
                    result.add(lineResult);
                    start++;  
                    length=0; 
                }else
                {
                    length=length-(index-start); 
                    int gap=(L-length)/(index-start-1);
                    String empty=""; 
                    while(gap!=0)
                    {
                        empty+=" ";  gap--; 
                    }
                    int reminder=(L-length)%(index-start-1);
                    StringBuffer sb=new StringBuffer(); 
                    while(start<index)
                    {
                        sb.append(words[start]);
                        start++; 
                        if(start<index)sb.append(empty);
                        if(reminder>0)
                        {
                            sb.append(" "); reminder--; 
                        }
                 
                }
                result.add(sb.toString());
                length=0; 
                }
                
            }
        }
        if(start!=words.length)
        {
            StringBuffer sb=new StringBuffer();
            while(start<words.length)
            {
                sb.append(words[start]);
                start++;
                if(start<words.length) sb.append(" ");
            }
            String empty="";
            length--; 
            while(length<L)
            {
                sb.append(" "); length++; 
            }
            result.add(sb.toString());
        }
        return result; 
    }
}


public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> result = new ArrayList<String>();
    	int count = -1, left = 0, right = 0;
        for(int i = 0; i < words.length; i++) {
        	String word = words[i];
        	if(count+word.length()+1 <= L) {
        		count += (word.length()+1);
        		right++;
        	} else {
        		result.add(getRow(words, left, right, count, L));
        		count = word.length();
        		left = i;
        		right = i+1;
        	}
        }
        StringBuilder lastRow = new StringBuilder();
        for(int i = left; i < right; i++) {
            lastRow.append(words[i]);
            if(i != right-1) lastRow.append(' ');
        }
        for(int i = 0; i < L-count; i++) {
            lastRow.append(' ');
        }
        result.add(lastRow.toString());
        return result;
    }
    
    private String getRow(String[] words, int left, int right, int count, int L) {
    	int charLeft = L - count;
    	int spaceCount = right - left - 1;
    	StringBuilder result = new StringBuilder();
    	if(spaceCount == 0) {
    	    result.append(words[left]);
    	    for(int i = 0; i < charLeft; i++) {
    	        result.append(' ');
    	    }
    	    return result.toString();
    	}
    	int leastSpaceLen = charLeft/spaceCount + 1;
    	String leastSpace = "";
    	for(int i = 0; i < leastSpaceLen; i++) {
    		leastSpace += " ";
    	}
    	int extraSpaceCount = charLeft % spaceCount;
    	int extraSpaceIndex = 0;
    	for(int i = left; i < right; i++) {
    		result.append(words[i]);
    		if(i != right-1) {
    		    result.append(leastSpace);
    		    if(extraSpaceIndex < extraSpaceCount) {
    			    result.append(' ');
    			    extraSpaceIndex++;
    	    	}
    		}
    	}
    	return result.toString();
    }
}


public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        int count = -1, left = 0, right = 0;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(count+word.length()+1 <= L) {
                count += (word.length()+1);
                right++;
            } else {
                result.add(getRow(words, left, right, count, L));
                count = word.length();
                left = i;
                right = i+1;
            }
        }
        StringBuilder lastRow = new StringBuilder();
        for(int i = left; i < right; i++) {
            lastRow.append(words[i]);
            if(i != right-1) lastRow.append(' ');
        }
        for(int i = 0; i < L-count; i++) {
            lastRow.append(' ');
        }
        result.add(lastRow.toString());
        return result;
    }
    
    private String getRow(String[] words, int left, int right, int count, int L) {
        int charLeft = L - count;
        int spaceCount = right - left - 1;
        StringBuilder result = new StringBuilder();
        if(spaceCount == 0) {
            result.append(words[left]);
            for(int i = 0; i < charLeft; i++) {
                result.append(' ');
            }
            return result.toString();
        }
        int leastSpaceLen = charLeft/spaceCount + 1;
        String leastSpace = "";
        for(int i = 0; i < leastSpaceLen; i++) {
            leastSpace += " ";
        }
        int extraSpaceCount = charLeft % spaceCount;
        int extraSpaceIndex = 0;
        for(int i = left; i < right; i++) {
            result.append(words[i]);
            if(i != right-1) {
                result.append(leastSpace);
                if(extraSpaceIndex < extraSpaceCount) {
                    result.append(' ');
                    extraSpaceIndex++;
                }
            }
        }
        return result.toString();
    }
}