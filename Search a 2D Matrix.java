public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
     if(matrix.length==0) return false;
     int m=matrix.length;
     int n=matrix[0].length;
     int i=0, j=matrix[0].length-1;
     while(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length)
     {
         if(matrix[i][j]==target) return true; 
         if(matrix[i][j]>target) j--; 
         else i++;
     }
     return false; 
    }
}


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        int start = 0, end = m*n-1;
        while(start <= end) {
        	int middle = start + (end-start)/2;
        	int row = middle / n;
        	int col = middle % n;
        	if(matrix[row][col] == target) return true;
        	else if(matrix[row][col] > target) end = middle-1;
        	else start = middle+1;
        }
        return false;
    }
}


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        long start = 0, end = (long)m*(long)n-1;
        while(start <= end) {
            long mid = start + (end-start)/2;
            int row = (int)(mid / n);
            int col = (int)(mid % n);
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
}










