public class Solution {
    public int removeElement(int[] A, int elem) {
        int start = 0, end = A.length-1;
        while(start <= end) {
        	if(A[start] == elem) {
        		A[start] = A[end];
        		end--;
        	} else {
        		start++;
        	}
        }
        return start;
    }
}

//keep order
public class Solution {
    public int removeElement(int[] A, int elem) {
        int index = 0;
        for(int i = 0; i < A.length; i++) {
        	if(A[i] != elem) {
        		if(i != index) swap(A, index, i);
        		index++;
        	} 
        }
        return index;
    }
    
    private void swap(int[] A, int i, int j) {
    	int temp = A[j];
    	A[i] = A[j];
    	A[j] = temp;
    }
}
















