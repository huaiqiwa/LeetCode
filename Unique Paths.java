public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][]P=new int [m][n];
        P[0][0]=1; 
        return find(P, m-1, n-1);
    }
    int find(int [][]P, int m, int n)
    {
        if(m==0 && n==0) return 1; 
        if(P[m][n]!=0) return P[m][n] ;
        int c1=0; 
        if(m>0) c1=find(P, m-1, n);
        int c2=0; 
        if(n>0) c2=find(P, m, n-1);
        P[m][n]=c1+c2;
        return P[m][n];
    }
}


public class Solution {
    public int uniquePaths(int m, int n) {
        int min = Math.min(m, n), max = Math.max(m, n);
        double totalPaths = 1;
        for(int i = 1; i < min; i++) {
        	totalPaths *= max-1+i;
        	totalPaths /= i;
        }
        return (int)totalPaths;
    }
}

public class Solution {
    public int uniquePaths(int m, int n) {
        int min = Math.min(m, n), max = Math.max(m, n);
        min--; max--;
        double paths = 1.0;
        for(int i = 1; i <= min; i++) {
            paths *= (max+i);
            paths /= i;
        }
        return (int)paths;
    }
}
















