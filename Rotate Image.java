public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0) return ; 
        int n=matrix.length;
        for(int i=0; i<n/2; i++)
        {
            for(int j=0; j<(n%2==0? n/2: n/2+1); j++)
            {
                int top=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1]; 
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=top; 
            }
        }
    }
}


public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++) {
        	int first = layer;
        	int last = n-1-layer;
        	for(int i = first; i < last; i++) {
        		int offset = i-first;
        		int top = matrix[first][i];
        		matrix[first][i] = matrix[last-offset][first];
        		matrix[last-offset][first] = matrix[last][last-offset];
        		matrix[last][last-offset] = matrix[i][last];
        		matrix[i][last] = top;
        	}
        }
    }
}


public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int level = 0, last = n-1; level < last; level++, last--) {
            for(int i = level; i < last; i++) {
                int tail = n-1-i;
                int top = matrix[level][i];
                matrix[level][i] = matrix[tail][level];
                matrix[tail][level] = matrix[last][tail];
                matrix[last][tail] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}


























