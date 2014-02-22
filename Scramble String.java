/*
scrambled[i][j][n] s1 starts from i, s2 starts from j and the length is n
scrambled[i][j][m] &&  scrambled[i+m][j+m][n-m]
scrambled[i][j+n-m][m] && scrambled[i+m][j][n-m]  1<m<n
*/
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length()!=s2.length()) return false; 
        if(s1.equals(s2)) return true; 
        /*
        scramble string 3D scrambled
        the first parameter is the starting point of s1, 
        the second parameter is the starting point of s2, 
        the third parameter is the length of the string
        */
        boolean [][][]scrambled=new boolean [s1.length()][s2.length()][s1.length()+1];
        for(int i=s1.length()-1; i>=0; i--)
        {
            for(int j=s2.length()-1; j>=0; j--)
            {
                scrambled[i][j][0]=true; 
                scrambled[i][j][1]=s1.charAt(i)==s2.charAt(j);
            }
        }
        
        for(int i=s1.length()-2; i>=0; i--)
        {
            for(int j=s2.length()-2; j>=0; j--)
            {
                for(int n=2; n<=Math.min(s1.length()-i, s2.length()-j); n++)
                {
                    for(int m=1; m<n; m++)
                    {
                        scrambled[i][j][n]|=(scrambled[i][j][m]&&scrambled[i+m][j+m][n-m])||(scrambled[i][j+n-m][m]&&scrambled[i+m][j][n-m]);
                        if(scrambled[i][j][n]) break;
                    }
                }
            }
        }
        return scrambled[0][0][s1.length()];   
    }
}


public class Solution {
    public boolean isScramble(String s1, String s2) {
    	int len = s1.length();
        if(len != s2.length()) return false; 
        if(s1.equals(s2)) return true; 
        /*
        scramble string 3D scrambled
        the first parameter is the starting point of s1, 
        the second parameter is the starting point of s2, 
        the third parameter is the length of the string
        */
        boolean[][][] scrambled = new boolean[len][len][len+1];
        for(int i = len-1; i >= 0; i--) {
            for(int j = len-1; j >= 0; j--) { 
                scrambled[i][j][1] = s1.charAt(i)==s2.charAt(j);
            }
        }
        for(int i = len-2; i >= 0; i--) {
            for(int j = len-2; j >= 0; j--) {
                for(int l = 2; i+l <= len && j+l <= len; l++) {
                    for(int k = 1; k < l; k++) {
                        if((scrambled[i][j][k]&&scrambled[i+k][j+k][l-k]) || 
                           (scrambled[i][j+l-k][k]&&scrambled[i+k][j][l-k])) {
                        	scrambled[i][j][l] = true;
                        	break;	
                        }
                    }
                }
            }
        }
        return scrambled[0][0][len];   
    }
}


























