public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
         int length = s.length();
         int []dp=new int[length+1];
         boolean [][]palin=new boolean[length][length];
         //dp[i] stores the minimum number of cut
         for(int i = 0; i <= length; i++)
                dp[i] = length-i;

      for(int i = length-1; i >= 0; i--)
      {
        for(int j = i; j < length; j++)
        {
          if(s.charAt(i) == s.charAt(j) && (j-i<2 || palin[i+1][j-1]))
          {
            palin[i][j] = true;
            dp[i] = Math.min(dp[i],dp[j+1]+1);
          }
        }
      }
      return dp[0]-1;
    }
}


public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        int[] minCut = new int[n+1];
        minCut[0] = -1;
        for(int j = 0; j < n; j++) {
        	minCut[j+1] = Integer.MAX_VALUE;
        	for(int i = 0; i <= j; i++) {
        		if(j-i == 0) isPalin[i][j] = true;
        		else if(j-i == 1) isPalin[i][j] = (s.charAt(i) == s.charAt(j));
        		else isPalin[i][j] = isPalin[i+1][j-1] && (s.charAt(i) == s.charAt(j));
        		if(isPalin[i][j]) minCut[j+1] = Math.min(minCut[j+1], minCut[i]+1);
        	}
        }
        return minCut[n];
    }
}


































