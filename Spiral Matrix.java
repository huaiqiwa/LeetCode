public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result=new ArrayList<Integer>(); 
        if(matrix.length==0) return result; 
       spiral(result,0, matrix.length-1, 0,  matrix[0].length-1,  matrix); 
       return result; 
    }
    void spiral(ArrayList<Integer> result, int upBound, int downBound, int leftBound, int rightBound, int [][] matrix)
    {
        if(upBound>downBound || leftBound>rightBound) return ;
        for(int i=leftBound; i<=rightBound; i++)
        {
            result.add(matrix[upBound][i]);
        }
        upBound++; 
        if(upBound>downBound) return ;
        for(int i=upBound; i<=downBound; i++)
        {
            result.add(matrix[i][rightBound]);
        }
        rightBound--; 
        if(rightBound<leftBound) return ;
        for(int i=rightBound; i>=leftBound; i--)
        {
            result.add(matrix[downBound][i]);
        }
        downBound--; 
        if(downBound<upBound) return ;
        for(int i=downBound; i>=upBound; i--)
        {
            result.add(matrix[i][leftBound]);
        }
        leftBound++; 
        spiral(result, upBound, downBound, leftBound,  rightBound,  matrix);
    }
}


public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0) return result;
        int n = matrix[0].length;
        if(n == 0) return result;
        m--;
        n--;
        for(int level = 0; m >= level && n >= level; level++, m--, n--) {
        	for(int i = level; i <= n; i++) result.add(matrix[level][i]);
        	if(level == m) return result;
        	for(int i = level+1; i <= m; i++) result.add(matrix[i][n]);
        	if(level == n) return result;
        	for(int i = n-1; i >= level; i--) result.add(matrix[m][i]);
        	for(int i = m-1; i > level; i--) result.add(matrix[i][level]);
        }
        return result;
    }
}
































