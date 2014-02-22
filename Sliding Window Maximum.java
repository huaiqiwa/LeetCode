// Type your Java code and click the "Run Code" button!
// Your code output will be shown on the left.
// Click on the "Show input" button to enter input data to be read (from stdin).

public class Interpreter {
    public static void main(String[] args) {
        // Start typing your code here...
    
    int []A={1, 3, -1, -3, 5, 3, 6, 7};
    int []B=new int [A.length-2]; 
    maxSlidingWindow(A, 3, B); 
    for(int i=0; i<B.length; i++)
    {
        System.out.println(B[i]);
    }
        
    }
        public static void maxSlidingWindow(int []A, int w, int []B)
  {
		Deque<Integer> deq=new LinkedList<Integer>();
		for(int i=0; i<w; i++)
		{
			while(!deq.isEmpty() && A[deq.getLast()]<=A[i])
			{
				deq.pollLast(); 
			}
			deq.add(i);
		}
		for(int i=w; i<A.length; i++)
		{
			B[i-w]=A[deq.getFirst()];
			while(!deq.isEmpty() && A[deq.getLast()]<=A[i])
			{
				deq.pollLast();
			}
			while(!deq.isEmpty() && deq.getFirst()<=i-w)
			{
				deq.pollFirst();
			}
			deq.add(i);
		}
		B[A.length-w]=A[deq.getFirst()];
	}
}


public class Solution {
	public int[] maxSlidingWindow(int[] A, int w) {
		int n = A.length;
		int[] B = new int[n-w+1];
		Deque<Integer> deq = new LinkedList<Integer>();
		for(int i = 0, j = 0; i < n; i++) {
			while(!deq.isEmpty() && deq.peekFirst() < i-w+1) {
				deq.pollFirst();
			}
			if(deq.isEmpty() || A[deq.peekLast()] > A[i]) {
				deq.offerLast(i);
				if(i >= w-1) {
					B[j] = A[deq.peekFirst()];
					j++;
				}
			} else {
				deq.pollLast();
				i--;
			}
		}
		return B;
	}
}





























