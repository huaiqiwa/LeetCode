public class Solution {
    Queue<Integer> queue=new LinkedList<Integer>();
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
    void check(char[][] board, int i, int j)
    {
        if(i<0|| j<0 || i>=board.length||j>=board[0].length||board[i][j]!='O') return ; 
        queue.offer(i*board[0].length+j);
        board[i][j]='D';
    }
    void process(char[][] board, int i, int j)
    {
        check(board, i,  j); 
        while(!queue.isEmpty())
        {
            int num=queue.poll();
            i=num/board[0].length;
            j=num%board[0].length;
            check(board, i+1, j);
            check(board, i-1, j);
            check(board, i, j+1);
            check(board, i, j-1);
        }

    }
}


public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m <= 2) return;
        int n = board[0].length;
        if(n <= 2) return;
        Queue<Pair> queue = new LinkedList<Pair>();
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
        		if(board[i][j] == 'O') board[i][j] = 'X';
        		else if(board[i][j] == 'M') board[i][j] = 'O';
        	}
        }
    }
    
    private void bfsMark(char[][] board, int i, int j, Queue<Long> queue) {  	
    	queue.offer(new Pair(i, j));
    	while(!queue.isEmpty()) {
    		Pair pair = queue.poll();
    		int row = pair.row;
    		int col = pair.col;
    		board[row][col] = 'M';
    		if(row+1 < m && board[row+1][col] == 'O') queue.offer(new Pair(row+1, col));
    		if(row-1 >= 0 && board[row-1][col] == 'O') queue.offer(new Pair(row-1, col));
    		if(col+1 < n && board[row][col+1] == 'O') queue.offer(new Pair(row, col+1));
    		if(col-1 >= 0 && board[row][col-1] == 'O') queue.offer(new Pair(row, col-1));
    	}
    }
    
    private class Pair {
    	int row;
    	int col;
    	Pair(int i, int j) {
    		row = i;
    		col = j;
    	}
    }
}