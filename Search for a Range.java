public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [] result=new int[2];
        result[0]=-1; 
        result[1]=-1; 
        if(A.length==0) return result; 
        int low=0, high=A.length; 
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(A[mid]<target)
            {
                low=mid+1; 
            }else
            {
                high=mid; 
            }
        }
        if(low>=A.length || A[low]!=target)
        {
           return result; 
        }
        result[0]=low;
        high=A.length; 
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(A[mid]>target)
            {
                high=mid; 
            }else
            {
                low=mid+1; 
            }
        }
        result[1]=high-1;
        return result; 
    }
}


public class Solution {
    public int[] searchRange(int[] A, int target) {
        int len = A.length;
        int[] result = {-1, -1};
        if(len == 0) return result;
        int start = 0, end = len-1, rightStart = -1, rightEnd = -1;
        while(start <= end) {
        	int middle = start + (end-start)/2;
        	if(A[middle] == target) {
        		if(rightStart == -1) rightStart = middle;
        		if(rightEnd == -1) rightEnd = end;
        		if(middle == 0 || A[middle-1] != A[middle]) {
        			result[0] = middle;
        			break;
        		} else end = middle-1;
        	} else if(A[middle] > target) {
        		end = middle-1;
        	} else {
        		start = middle+1;
        	}
        }
        if(result[0] == -1) return result;
        
        start = rightStart;
        end = rightEnd;
        while(start <= end) {
        	int middle = start + (end-start)/2;
        	if(A[middle] == target) {
        		if(middle == len-1 || A[middle+1] != A[middle]) {
        			result[1] = middle;
        			break;
        		} else start = middle+1;
        	} else if(A[middle] > target) {
        		end = middle-1;
        	} else {
        		start = middle+1;
        	}
        }
        
        return result;
    }
}






























