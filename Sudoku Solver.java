public class Solution {
    public boolean solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return  validSudoku(board); 
    }
    boolean validSudoku(char[][]board)
    {
        boolean row[][]=new boolean [board.length][board[0].length];
        boolean col[][]=new boolean [board.length][board[0].length];
        boolean dir[][]=new boolean [board.length][board[0].length];
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
               if(board[i][j]!='.')
               {
                   int c=board[i][j]-'1'; 
                   if(row[i][c]||col[j][c]||dir[i-i%3+j/3][c]) return false; 
                   row[i][c]=true; 
                   col[j][c]=true; 
                   dir[i-i%3+j/3][c]=true; 
               }else
               {
                   for(char z='1'; z<='9'; z++)
                    {
                        board[i][j]=z; 
                        if(validSudoku(board)) return true; 
                        board[i][j]='.'; 
                    }
               }
            }
        }
        return true; 
    }
}


public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, new int[2]);
    }
    
    private boolean solveSudoku(char[][] board, int[] index) {
    	int prerow = index[0];
    	int precol = index[1];
    	getNextIndex(board, index);
    	if(index[0] == board.length) return true;
    	for(char c = '1'; c <= '9'; c++) {
    		board[index[0]][index[1]] = c;
    		if(isValidSudoku(board, index) && solveSudoku(board, index)) return true;
    	}
    	board[index[0]][index[1]] = '.';
    	index[0] = prerow;
    	index[1] = precol;
    	return false;
    }
    
    private void getNextIndex(char[][] board, int[] index) {
    	int n = board.length;
    	for(int i = index[0]; i < n; i++) {
    		for(int j = (i == index[0]) ? index[1] : 0; j < n; j++) {
    			if(board[i][j] == '.') {
    				index[0] = i;
    				index[1] = j;
    				return;
    			}
    		}
    	}
    	index[0] = n;
    	index[1] = n;
    }
    
    private boolean isValidSudoku(char[][] board, int[] index) {
        int row = index[0];
        int col = index[1];
        int n = board.length;
        for(int i = 0; i < n; i++) {
        	if(i != row && board[i][col] == board[row][col]) return false;
        	if(i != col && board[row][i] == board[row][col]) return false;
        }
        for(int srow = row/3*3, i = srow; i < srow+3; i++) {
        	for(int scol = col/3*3, j = scol; j < scol+3; j++) {
        		if((i != row || j != col) && board[i][j] == board[row][col]) return false;
        	}
        }
        return true;
    }
}



public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }
    
    private boolean solveSudoku(char[][] board, int row, int col) {
        int n = board.length;
        long index = getNextIndex(board, row, col);
        int i = (int)(index/n), j = (int)(index%n);
        if(i == n) return true;
        for(char c = '1'; c <= '9'; c++) {
            board[i][j] = c;
            if(isValidSudoku(board, i, j) && solveSudoku(board, i, j)) return true; 
        }
        board[i][j] = '.';
        return false;
    }
    
    private long getNextIndex(char[][] board, int row, int col) {
        int n = board.length;
        for(int i = row; i < n; i++) {
            for(int j = (i == row ? col : 0); j < n; j++) {
                if(board[i][j] == '.') return (long)i*(long)n+(long)j;
            }
        }
        return (long)n*(long)n;
    }
    
    private boolean isValidSudoku(char[][] board, int row, int col) {
        int n = board.length;
        for(int i = 0; i < n; i++) {
            if(i != row && board[i][col] == board[row][col]) return false;
            if(i != col && board[row][i] == board[row][col]) return false;
        }
        for(int srow = row/3*3, i = srow; i < srow+3; i++) {
            for(int scol = col/3*3, j = scol; j < scol+3; j++) {
                if((i != row || j != col) && board[i][j] == board[row][col]) return false;
            }
        }
        return true;
    }
}






























