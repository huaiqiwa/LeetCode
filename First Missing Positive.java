public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return 1; 
        for(int i=0; i<A.length; i++)
        {
            if(A[i]<=0) A[i]=A.length+1; 
        }
        for(int i=0; i<A.length; i++)
        {
            int num=Math.abs(A[i]);
            if(num>A.length || A[num-1]==-num) continue;
            if(A[num-1]==num)
            {
                A[num-1]=-num;  continue; 
            }
            int a=A[num-1]; 
            A[num-1]=-A[i]; 
            A[i]=a; 
            i--; 
        }
        for(int i=0; i<A.length; i++)
        {
            if(A[i]>0) return i+1; 
        }
        return A.length+1; 
    }
}


public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; i++) {
        	if(A[i] <= 0 || A[i] > A.length || A[A[i]-1] == A[i]) continue;
        	int temp = A[A[i]-1];
        	A[A[i]-1] = A[i];
        	A[i] = temp;
        	i--;
        }
        int i = 0;
        for(; i < A.length; i++) {
        	if(A[i]-1 != i) break;
        }
        return i+1;
    }
}


public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; i++) {
        	if(A[i]-1 >= 0 && A[i]-1 < A.length && A[A[i]-1] != A[i]) {
        	    swap(A, i, A[i]-1);
        	    i--;
        	}
        }
        int i = 0;
        for(; i < A.length; i++) {
        	if(A[i]-1 != i) break;
        }
        return i+1;
    }
    
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}





























