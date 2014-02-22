public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length==0) return ; 
        for(int i=0; i<board[0].length; i++)
        {
            process(board, 0, i);
            process(board, board.length-1, i);
        }
        for(int i=0; i<board.length; i++)
        {
            process(board, i, 0);
            process(board, i, board[0].length-1);
        }
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j]=='D') board[i][j]='O'; 
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    void process(char[][] board, int i, int j)
    {
        if(i<0|| j<0 || i>=board.length||j>=board[0].length||board[i][j]!='O') return ; 
        board[i][j]='D'; 
        process(board, i+1, j);
        process(board, i-1, j);
        process(board, i, j+1);
        process(board, i, j-1);
    }
}

public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m <= 2) return;
        int n = board[0].length;
        if(n <= 2) return;
        for(int i = 0; i < m; i++) {
        	if(board[i][0] == 'O') dfsMark(board, i, 0);
        	if(board[i][n-1] == 'O') dfsMark(board, i, n-1);
        }
        for(int i = 1; i < n-1; i++) {
        	if(board[0][i] == 'O') dfsMark(board, 0, i);
        	if(board[m-1][i] == 'O') dfsMark(board, m-1, i);
        }
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(board[i][j] == 'O') board[i][j] = 'X';
        		else if(board[i][j] == 'M') board[i][j] = 'O';
        	}
        }
    }
    
    private void dfsMark(char[][] board, int i, int j) {
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
    	board[i][j] = 'M';
    	dfsMark(board, i+1, j);
    	dfsMark(board, i-1, j);
    	dfsMark(board, i, j+1);
    	dfsMark(board, i, j-1);
    }
}


public class Solution {
    public void solve(char[][] board) {
        if(board.length==0) return;
        Queue<Long> queue = new LinkedList<Long>();
        for(int i=0; i<board[0].length; i++) {
            process(board, 0, i, queue);
            process(board, board.length-1, i, queue);
        }
        for(int i=0; i<board.length; i++) {
            process(board, i, 0, queue);
            process(board, i, board[0].length-1, queue);
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='M') board[i][j]='O'; 
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    
    private void check(char[][] board, int i, int j, Queue<Long> queue) {
        if(i<0|| j<0 || i>=board.length||j>=board[0].length||board[i][j]!='O') return; 
        queue.offer((long)i*(long)board[0].length+j);
        board[i][j]='M';
    }
    
    private void process(char[][] board, int i, int j, Queue<Long> queue) {
        check(board, i,  j, queue); 
        while(!queue.isEmpty()) {
            long num=queue.poll();
            i = (int)(num/board[0].length);
            j = (int)(num%board[0].length);
            check(board, i+1, j, queue);
            check(board, i-1, j, queue);
            check(board, i, j+1, queue);
            check(board, i, j-1, queue);
        }
    }
}


public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        if(n == 0) return;
        Queue<Long> queue = new LinkedList<Long>();
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') bfsMark(board, i, 0, queue);
            if(board[i][n-1] == 'O') bfsMark(board, i, n-1, queue);
        }
        for(int i = 1; i < n-1; i++) {
            if(board[0][i] == 'O') bfsMark(board, 0, i, queue);
            if(board[m-1][i] == 'O') bfsMark(board, m-1, i, queue);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'M') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    private void bfsMark(char[][] board, int i, int j, Queue<Long> queue) {
        int m = board.length, n = board[0].length;
        mark(board, i,  j, queue); 
        while(!queue.isEmpty()) {
            long index = queue.poll();
            i = (int)(index / n);
            j = (int)(index % n);
            mark(board, i+1, j, queue);
            mark(board, i-1, j, queue);
            mark(board, i, j+1, queue);
            mark(board, i, j-1, queue);
        }
    }
    
    private void mark(char[][] board, int i, int j, Queue<Long> queue) {
        int m = board.length, n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        queue.offer((long)i*(long)n + j);
        board[i][j] = 'M';
    }
}



























