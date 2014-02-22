public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=word1.length()+1;
        int n=word2.length()+1;
        int array[][]=new int[m][n];
        //initilize the boundary cases
        for(int i=word1.length(); i>=0; i--)
        {
            array[i][word2.length()]=word1.length()-i;
        }
        for(int j=word2.length(); j>=0; j--)
        {
            array[word1.length()][j]=word2.length()-j;
        }
        for(int i=m-2; i>=0; i--)
        {
            for(int j=n-2; j>=0; j--)
            {
                if(word1.charAt(i)==word2.charAt(j))
                {
                    array[i][j]=array[i+1][j+1];
                }else
                {
                    array[i][j]=1+Math.min(array[i+1][j], Math.min(array[i][j+1], array[i+1][j+1]));
                }
            }
        }
        return array[0][0];
    }
}


public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() > word2.length()) {
        	String temp = word1;
        	word1 = word2;
        	word2 = temp;
        }
        int word1Len = word1.length(), word2Len = word2.length();
        if(word1Len == 0) return word2Len;
        int[] dist = new int[word1Len];
        dist[0] = word2.charAt(0) == word1.charAt(0) ? 0 : 1;
        for (int j=1; j<word1Len; ++j) {  
            dist[j] = Math.min(dist[j-1]+1, (word1.charAt(j) == word2.charAt(0)) ? j : j+1);  
        }
        int lastpre;
        for(int i = 1; i < word2Len; i++) {
            lastpre = dist[0];
            dist[0] = Math.min(dist[0]+1, (word1.charAt(0) == word2.charAt(i)) ? i : i+1);
        	for(int j = 1; j < word1Len; j++) {      		
				int pre = dist[j];
				dist[j] += 1;
				dist[j] = Math.min(dist[j], dist[j-1]+1);
				dist[j] = Math.min(dist[j], lastpre+(word2.charAt(i) == word1.charAt(j) ? 0 : 1));
				lastpre = pre;       		
        	}
        }
        return dist[word1Len-1];
    }
}


public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() > word2.length()) {
        	String temp = word1;
        	word1 = word2;
        	word2 = temp;
        }
        int word1Len = word1.length(), word2Len = word2.length();
        if(word1Len == 0) return word2Len;
        int[] dist = new int[word1Len];
        int lastpre = 0;
        for(int i = 0; i < word2Len; i++) {
        	for(int j = 0; j < word1Len; j++) {
        		if(j == 0 && i == 0) {
        			dist[j] = word2.charAt(i) == word1.charAt(j) ? 0 : 1;
        			lastpre = dist[j];
        		} else if(j == 0) {
        		    lastpre = dist[j];
        			dist[j] = Math.min(dist[j]+1, word2.charAt(i) == word1.charAt(j) ? i : i+1);
        		} else if(i == 0) {
        			dist[j] = Math.min(dist[j-1]+1, word2.charAt(i) == word1.charAt(j) ? j : j+1);
        		} else {
        		    int pre = dist[j];
        			dist[j] += 1;
        			dist[j] = Math.min(dist[j], dist[j-1]+1);
        			dist[j] = Math.min(dist[j], lastpre+(word2.charAt(i) == word1.charAt(j) ? 0 : 1));
        			lastpre = pre;
        		}
        	}
        }
        return dist[word1Len-1];
    }
}




































