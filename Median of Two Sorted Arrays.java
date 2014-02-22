public class Solution {
    private double findMedian(int A[], int B[], int left, int right) {  
		int m = A.length, n = B.length, mid = (m+n)/2;  
		if (left > right) {  
			return findMedian(B, A, Math.max(0, mid-m), Math.min(n-1, mid));  
		}  
	 
		int i = (left+right) / 2, j = mid - i - 1;  
		if (j >= 0 && A[i] < B[j]) // A[i] < median  
			return findMedian(A, B, i+1, right);  
		if (j < n-1 && A[i] > B[j+1]) // A[i] > median  
			return findMedian(A, B, left, i-1);  
		// found median (j<0 => mid-i-1 < 0 => i=mid; j>=n-1 => mid-i-1>=n-1 => i=mid-n) 
		// m+n is odd  
		if (((m+n) & 0x1) > 0)  
			return A[i];  
		// m+n is even  
		if (j < 0 || j >= n)  
			return (A[i] + A[i-1]) / 2.0;  
		if (i <= 0)  
			return (A[i] + B[j]) / 2.0;  
		return (A[i] + Math.max(B[j], A[i-1])) / 2.0;  
 	}  
   
 	public double findMedianSortedArrays(int A[], int B[]) {  
		int m = A.length, n = B.length, mid = (m+n)/2;  
		if (m<n)  
			return findMedian(A, B, Math.max(0, mid-n), Math.min(m-1, mid));  
		else  
			return findMedian(B, A, Math.max(0, mid-m), Math.min(n-1, mid));  
 	}  
}



public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int m = A.length, n = B.length, mid = m+(n-m)/2;
        return findMedianSortedArrays(A, Math.max(0, mid-n), Math.min(m-1, mid), B);
    }
    
    private double findMedianSortedArrays(int[] A, int start, int end, int[] B) {
        int m = A.length, n = B.length, mid = (m > n ? n+(m-n)/2 : m+(n-m)/2);
        if(start > end) 
        	return findMedianSortedArrays(B, Math.max(0, mid-m), Math.min(n-1, mid), A);
        int aIndex = start + (end-start)/2;
        int bIndex = mid - aIndex - 1;
        if(bIndex >= 0 && A[aIndex] < B[bIndex])
            return findMedianSortedArrays(A, aIndex+1, end, B);
        if(bIndex < n-1 && A[aIndex] > B[bIndex+1])
            return findMedianSortedArrays(A, start, aIndex-1, B);
        if((m+n)%2 == 1) return A[aIndex];
        if(bIndex < 0 || bIndex >= n) return (A[aIndex]+A[aIndex-1])/2.0;
        if(aIndex <= 0) return (A[aIndex]+B[bIndex])/2.0;
        return (A[aIndex]+Math.max(B[bIndex], A[aIndex-1]))/2.0;
    }
}





























