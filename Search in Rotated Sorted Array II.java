public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return find(A, target, 0, A.length-1); 
    }
    int find(int[] A, int target, int start, int end)
    {
        if(start>end) return -1; 
        int mid=start+(end-start)/2; 
        if(A[mid]==target)
        {
            return mid; 
        }
        else if(A[mid]<target)
        {
            if(A[end]>=A[mid])
            {
                int left=find(A, target, start, mid-1);
                if(left!=-1) return left; 
                int right=find(A, target, mid+1, end);
                return right; 
            }else
            {
                return find(A, target, mid+1, end);
            }
        }else
        {
            if(A[end]<=A[mid])
            {
                int left=find(A, target, start, mid-1);
                if(left!=-1) return left; 
                int right=find(A, target, mid+1, end);
                return right; 
            }else
            {
                return find(A, target, start, mid-1);
            }
        }
    }
}

/*
another solution
*/


public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if(find(A, target, 0, A.length-1)!=-1) return true;
       return false; 
    }
    
    int find(int[] A, int target, int start, int end)
    {
        if(start>end) return -1; 
        int mid=start+(end-start)/2; 
        if(A[mid]==target)
        {
            return mid; 
        }
        else if (A[start]==A[mid])
        {
            int left=find(A, target, start, mid-1);
            if(left!=-1) return left;
            int right=find(A, target, mid+1, end);
            return right; 
        }
        else if (A[start]<A[mid])
        {
            if(A[start]<=target && target<A[mid])
            {
                return find(A, target, start, mid-1);
            }else
            {
                return find(A, target, mid+1, end);
            }
            
        }else
        {
            if(A[mid]<target && target<=A[end])
            {
                return find(A, target, mid+1, end);
            }else
            {
                return find(A, target, start, mid-1);
            }
        }
    }
}



public class Solution {
    public boolean search(int[] A, int target) {
        int start = 0, end = A.length-1;
        while(end - start >= 2) {
        	int middle = start + (end-start)/2;
        	if(A[middle] == target) return true;
        	if(A[start] < A[middle]) {
        		if(A[start] <= target && target < A[middle]) end = middle-1;
        		else start = middle+1;
        	}
        	if(A[middle] < A[end]) {
        		if(A[middle] < target && target <= A[end]) start = middle+1;
        		else end = middle-1;
        	}
        	if(A[start] == A[middle]) start++;
        	if(A[middle] == A[end]) end--;        	
        }
        for(int i = start; i <= end; i++) {
        	if(A[i] == target) return true;
        }
        return false;
    }
}



























