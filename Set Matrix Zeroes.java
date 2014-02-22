public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0) return ;
        int i=0, j=0;
        boolean find=false;
        for(int p=0; p<matrix.length; p++)
        {
            for(int q=0; q<matrix[0].length; q++)
            {
                if(matrix[p][q]==0)
                {
                    find=true; 
                    i=p; j=q; 
                    break;
                }
            }
            if(find) break; 
        }
        if(!find) return; 
        for(int p=0; p<matrix.length; p++)
        {
            for(int q=0; q<matrix[0].length; q++)
            {
                if(matrix[p][q]==0)
                {
                    matrix[p][j]=0; matrix[i][q]=0;
                }
            }
        }        
        for(int q=0; q<matrix[0].length; q++)
        {
            if(q==j) continue; 
            for(int p=0; p<matrix.length; p++)
            {
                if(p==i) continue; 
                if(matrix[i][q]==0 ||matrix[p][j]==0 )
                {
                     matrix[p][q]=0;
                }
            }
        }
        for(int p=0; p<matrix.length; p++)
        {
            matrix[p][j]=0;
        }
        for(int q=0; q<matrix[0].length; q++)
        {
            matrix[i][q]=0;
        }
    }
}


public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        if(n == 0) return;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(matrix[i][j] == 0) {
        			row[i] = true;
        			col[j] = true;
        		}
        	}
        }
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(row[i] || col[j]) matrix[i][j] = 0;
        	}
        }
    }
}































