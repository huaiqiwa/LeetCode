public class Solution {
    int counter; 
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        counter=0; 
        int []row=new int[n];
        placeQueue(row, 0 );
        return counter; 
    }
     void placeQueue(int []row, int rowLine )
    {
        if(rowLine==row.length)
        {
            counter++;  return ;
        }
        for(int i=0; i<row.length; i++)
        {         
            if(validQueue(row, rowLine, i))
            {
                row[rowLine]=i;
                placeQueue(row, rowLine+1); 
            }
        }
    }
    boolean validQueue(int [] row, int rowLine, int col)
    {
        for(int i=0; i<rowLine; i++)
        {
            if(row[i]==col) return false; 
            if(Math.abs(i-rowLine)==Math.abs(row[i]-col)) return false; 
        }
        return true; 
    }
}


public class Solution {
	private int count;
    public int totalNQueens(int n) {
    	count = 0;
        if(n <= 0) return count;
        int[] row = new int[n];
        totalNQueens(n, row, 0);
        return count;
    }
    
    private void totalNQueens(int n, int[] row, int irow) {
    	if(irow == n) {
    		count++;
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		row[irow] = i;
    		if(isValid(row, irow)) totalNQueens(n, row, irow+1);
    	}
    }
    
    private boolean isValid(int[] row, int irow) {
    	for(int i = 0; i < irow; i++) {
    		if(row[i] == row[irow]) return false;
    		if(Math.abs(i-irow) == Math.abs(row[i]-row[irow])) return false;  
    	}
    	return true;
    }
}
