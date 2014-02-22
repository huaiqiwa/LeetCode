public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(word.length()==0) return true; 
        if(board.length==0) return false; 
        boolean [][] check=new boolean [board.length][board[0].length];
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    check[i][j]=true; 
                    if(find(board, check, word.substring(1), i, j)) return true;
                    check[i][j]=false;
                }
            }
        }
        return false;
    }
    boolean find(char[][]board, boolean [][]check, String word, int i, int j)
    {
        if(word.length()==0) return true; 
        boolean result=false; 
        if(j+1< check[0].length && check[i][j+1]==false && board[i][j+1]==word.charAt(0))
        {
            check[i][j+1]=true; 
            result=find(board, check, word.substring(1), i, j+1);
            check[i][j+1]=false; 
        }
        if(result) return true; 
        if(j-1>=0 && check[i][j-1]==false && board[i][j-1]==word.charAt(0))
        {
            check[i][j-1]=true;
            result=find(board, check, word.substring(1), i, j-1);
            check[i][j-1]=false;
        }
        if(result) return true; 
        if(i+1< check.length && check[i+1][j]==false && board[i+1][j]==word.charAt(0))
        {
            check[i+1][j]=true; 
            result=find(board, check, word.substring(1), i+1, j);
            check[i+1][j]=false; 
        }
        if(result) return true; 
        if(i-1>=0 && check[i-1][j]==false && board[i-1][j]==word.charAt(0))
        {
            check[i-1][j]=true;
            result=find(board, check, word.substring(1), i-1, j);
            check[i-1][j]=false;
        }
        return result; 
    }
}


public class Solution {
    public boolean exist(char[][] board, String word) {
    	int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(board[i][j] == word.charAt(0)) {
        			visited[i][j] = true;
        			if(find(board, word, 1, i , j, visited)) return true;
        			visited[i][j] = false;
        		}
        	}
        }
        return false;
    }
    
    private boolean find(char[][] board, String word, int index, int currow, int curcol, boolean[][] visited) {
    	if(index == word.length()) return true;
    	int row = board.length, col = board[0].length;
    	if(currow+1 < row && !visited[currow+1][curcol] && board[currow+1][curcol] == word.charAt(index)) {
    		visited[currow+1][curcol] = true;
    		if(find(board, word, index+1, currow+1, curcol, visited)) return true;
    		visited[currow+1][curcol] = false;
    	}
    	if(currow-1 >= 0 && !visited[currow-1][curcol] && board[currow-1][curcol] == word.charAt(index)) {
    		visited[currow-1][curcol] = true;
    		if(find(board, word, index+1, currow-1, curcol, visited)) return true;
    		visited[currow-1][curcol] = false;
    	}
    	if(curcol+1 < col && !visited[currow][curcol+1] && board[currow][curcol+1] == word.charAt(index)) {
    		visited[currow][curcol+1] = true;
    		if(find(board, word, index+1, currow, curcol+1, visited)) return true;
    		visited[currow][curcol+1] = false;
    	}
    	if(curcol-1 >= 0 && !visited[currow][curcol-1] && board[currow][curcol-1] == word.charAt(index)) {
    		visited[currow][curcol-1] = true;
    		if(find(board, word, index+1, currow, curcol-1, visited)) return true;
    		visited[currow][curcol-1] = false;
    	}
    	return false;
    }
}



public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        int m = board.length;
        if(m == 0) return false;
        int n = board[0].length;
        if(n == 0) return false;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(check(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, int i, int j, String word, int index, 
        boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || 
           board[i][j] != word.charAt(index) || visited[i][j]) return false;
        if(index == word.length()-1) return true;
        visited[i][j] = true;
        if(check(board, i+1, j, word, index+1, visited)) return true; 
        if(check(board, i-1, j, word, index+1, visited)) return true; 
        if(check(board, i, j+1, word, index+1, visited)) return true;
        if(check(board, i, j-1, word, index+1, visited)) return true;
        visited[i][j] = false;
        return false;
    }
}





























