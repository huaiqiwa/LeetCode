public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
      if(A.length<=2) return 0; 
      int [] first=new int[A.length];
      int [] second=new int[A.length];
      for(int i=0; i<A.length; i++)
      {
          if(i==0)
          {
          first[i]=A[i]; continue; 
          }
          first[i]=Math.max(first[i-1], A[i] );
      }
      for(int i=A.length-1; i>=0; i--)
      {
          if(i==A.length-1)
          {
          second[i]=A[i]; continue; 
          } 
          second[i]=Math.max(second[i+1], A[i] );
      }
      int max=0; 
      for(int i=0; i<A.length; i++)
      {
          max+=Math.min(first[i], second[i])-A[i];
      }
      return max;
    }
}


public class Solution {
    public int trap(int[] A) {
    	int len = A.length;
        Stack<Integer> pre = new Stack<Integer>();
        int result = 0;
        for(int i = 0; i < len; i++) {
        	if(pre.empty()) {
        		pre.push(i);
        		continue;
        	}
        	int top = pre.peek();
        	if(A[i] < A[top]) pre.push(i);
        	else {
        		pre.pop();
        		if(pre.empty()) {
        			i--;
        		} else {
					int topPre = pre.peek();
					result += (Math.min(A[topPre], A[i])-A[top]) * (i-topPre-1);
					i--;
				}
        	}
        }
        return result; 
    }
}


public class Solution {
    public int trap(int[] A) {
    	Stack<Integer> pre = new Stack<Integer>();
    	int result = 0;
    	for(int i = 0; i < A.length; i++) {
    	    if(pre.isEmpty() || A[pre.peek()] > A[i]) {
    	        pre.push(i);
    	        continue;
    	    }
    	    int mid = pre.pop();
    	    if(pre.isEmpty()) pre.push(i);
    	    else {
    	        int left = pre.peek();
    	        result += (Math.min(A[left], A[i])-A[mid]) * (i-left-1);
    	        i--;
    	    }
    	}
    	return result;
    }
}






















