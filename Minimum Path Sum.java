public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
     int [][] path=new int[grid.length][grid[0].length];
     return sumPath( grid,  path, grid.length-1, grid[0].length-1); 
    }
    int sumPath(int [][] grid, int [][] path, int i, int j)
    {
        if(path[i][j]!=0) return path[i][j];
        if(i==0 && j==0)
        {
            path[i][j]=grid[i][j]; return path[i][j];
        }
        int c1=Integer.MAX_VALUE, c2=Integer.MAX_VALUE; 
        if(i>0) c1= sumPath(grid, path, i-1,  j); 
        if(j>0) c2= sumPath(grid, path, i, j-1); 
        path[i][j]=Math.min(c1, c2)+ grid[i][j];
        return path[i][j];
    }
}


public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        int[] col = new int[n];
        col[0] = grid[0][0]; 
        for(int i = 1; i < n; i++) {
            col[i] = col[i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(j == 0) col[j] += grid[i][j];
        		else col[j] = Math.min(col[j-1], col[j]) + grid[i][j];
        	}
        }
        return col[n-1];
    }
}































