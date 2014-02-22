public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ArrayList<String[]> result=new  ArrayList<String[]> (); 
         int [] row=new int[n]; 
         placeQueue(row, 0, result ); 
         return result; 
    }
    void placeQueue(int []row, int rowLine, ArrayList<String[]> result )
    {
        if(rowLine==row.length)
        {
            String [] subResult=new String[row.length];
            for(int i=0; i<row.length; i++)
            {
                int left=row[i];
                StringBuffer sb=new StringBuffer(); 
                while(left!=0)
                {
                    sb.append("."); left--; 
                }
                sb.append("Q");
                int right=row.length-row[i]-1;
                while(right!=0)
                {
                    sb.append("."); right--; 
                }
                subResult[i]=sb.toString();
            }
            result.add(subResult);
            return ;
        }
        for(int i=0; i<row.length; i++)
        {         
            if(validQueue(row, rowLine, i))
            {
                row[rowLine]=i;
                placeQueue(row, rowLine+1, result ); 
            }
        }
    }
    boolean validQueue(int [] row, int rowLine, int col)
    {
        for(int i=0; i<rowLine; i++)
        {
            if(row[i]==col) return false; 
        }
        for(int i=0; i<rowLine; i++)
        {
            if(Math.abs(i-rowLine)==Math.abs(row[i]-col)) return false; 
        }
        return true; 
    }
}


public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> results = new ArrayList<String[]>();
        if(n <= 0) return results;
        int[] row = new int[n];
        solveNQueens(n, row, 0, results);
        return results;
    }
    
    private void solveNQueens(int n, int[] row, int irow, ArrayList<String[]> results) {
    	if(irow == n) {
    		String[] result = getResult(row);
    		results.add(result);
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		row[irow] = i;
    		if(isValid(row, irow)) solveNQueens(n, row, irow+1, results);
    	}
    }
    
    private boolean isValid(int[] row, int irow) {
    	for(int i = 0; i < irow; i++) {
    		if(row[i] == row[irow]) return false;
    		if(Math.abs(i-irow) == Math.abs(row[i]-row[irow])) return false;  
    	}
    	return true;
    }
    
    private String[] getResult(int[] row) {
    	int n = row.length;
    	String[] result = new String[n];
    	for(int i = 0; i < n; i++) {
    		StringBuilder sb = new StringBuilder();
    		for(int j = 0; j < n; j++) {
    			if(j == row[i]) sb.append('Q');
    			else sb.append('.');
    		}
    		result[i] = sb.toString();
    	}
    	return result;
    }
}


































