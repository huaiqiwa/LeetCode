public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
      if(s.length()==0 || nRows==0 || nRows==1) return s; 
      int words=2*(nRows-1); 
      int region=s.length()%words==0? s.length()/words: (s.length()/words+1);
      StringBuffer sb=new StringBuffer(); 
      for(int i=0; i<nRows; i++)
      {
          for(int j=0; j<region; j++)
          {
              if(i+j*words<s.length())
                    sb.append(s.charAt(i+j*words));
              if(i!=0 && i!=nRows-1 && (j+1)*words-i<s.length() )
                    sb.append(s.charAt((j+1)*words-i));  
          }
      }
      return sb.toString(); 
    }
}


public class Solution {
    public String convert(String s, int nRows) {
    	if(nRows == 1) return s;
    	int totalOffset = (nRows-1)*2;
    	StringBuilder result = new StringBuilder();
        for(int row = 0; row < nRows; row++) {
        	int firstOffset = (nRows-row-1)*2;
        	int secondOffset = totalOffset - firstOffset;
        	for(int i = row; i < s.length(); ) {
        		if(firstOffset != 0) {
        			result.append(s.charAt(i));
        			i += firstOffset;
        			if(i >= s.length()) break;
        		}
        		if(secondOffset != 0) {
        			result.append(s.charAt(i));
        			i += secondOffset;
        		}
        	}
        }
        return result.toString();
    }
}































