public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=s1.length(); 
        int n=s2.length(); 
        if((m+n)!=s3.length()) return false; 
        boolean [][] checker=new boolean [m+1][n+1];
        checker[0][0]=true; 
        for(int i=0; i<m; i++)
        {
            if(s1.charAt(i)==s3.charAt(i))
            {
                checker[i+1][0]=true; 
            }else break; 
        }
        for(int i=0; i<n; i++)
        {
            if(s2.charAt(i)==s3.charAt(i))
            {
                checker[0][i+1]=true; 
            }else break; 
        }
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
              if(checker[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1)) checker[i][j]=true; 
              else if (checker[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1)) checker[i][j]=true;;
            }
        }
        return checker[m][n];
    }
}


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);
       	if(s1.charAt(0) == s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1))) return true;
       	if(s2.charAt(0) == s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1))) return true;
       	return false;
    }
}


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length()+s2.length() != s3.length()) return false;
        if(s1.length() < s2.length()) {
        	String temp = s1;
        	s1 = s2;
        	s2 = temp;
        }
        int l1 = s1.length(), l2 = s2.length();
        if(l2 == 0) return s1.equals(s3);
        boolean[] inter = new boolean[l2+1];
        inter[0] = true;
        for(int j = 1; j <= l2; j++) {
        	inter[j] = inter[j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        	if(!inter[j]) break;
        }
        for(int i = 1; i <= l1; i++) {
        	inter[0] = inter[0] && s1.charAt(i-1) == s3.charAt(i-1);
        	for(int j = 1; j <= l2; j++) {
        		inter[j] = (inter[j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || 
        				   (inter[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
        	}
        }
        return inter[l2];
    }
}




























