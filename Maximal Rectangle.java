public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0) return 0; 
        int [][] calMatrix=new int [matrix.length][matrix[0].length]; 
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]=='0')
                {
                    calMatrix[i][j]=0;
                }else
                {
                    calMatrix[i][j]=1+(j>0? calMatrix[i][j-1]: 0);
                }
            }
        }
        int result=0; 
        for(int j=0; j<matrix[0].length; j++)
        {
            for(int i=0; i<matrix.length; i++)
            {
                int num=calMatrix[i][j];
                for(int k=i; k<matrix.length; k++)
                {
                    num=Math.min(num, calMatrix[k][j] );
                    result=Math.max(result, num*(k-i+1));
                }
            }
        }
        return result; 
    }
}


public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	int m = matrix.length;
    	if(m == 0) return 0;
    	int n = matrix[0].length;
    	if(n == 0) return 0;
        int maxRect = 0;
        int[] row = new int[n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(matrix[i][j] == '0') row[j] = 0;
        		else row[j]++;
        	}
        	maxRect = Math.max(maxRect, largestRectangleArea(row));
        }
        return maxRect;
    }
    
    private int largestRectangleArea(int[] height) {
    	int n = height.length;
        if(n == 0) return 0;
        Stack<Integer> indexStack = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
        	if(indexStack.isEmpty() || height[indexStack.peek()] < height[i]) {
        		indexStack.push(i);
        		continue;
        	}
        	if(height[indexStack.peek()] >= height[i]) {
        		int curHeight = height[indexStack.pop()];
        		int leftIndex = 0; 
        		if(!indexStack.isEmpty()) leftIndex = indexStack.peek()+1;
        		maxArea = Math.max(maxArea, (i-leftIndex)*curHeight);
        		i--;
        	}
        }
        while(!indexStack.isEmpty()) {
        	int curHeight = height[indexStack.pop()];
        	int leftIndex = 0;
        	if(!indexStack.isEmpty()) leftIndex = indexStack.peek()+1;
        	maxArea = Math.max(maxArea, (n-leftIndex)*curHeight);
        }
        return maxArea;
    }
}































