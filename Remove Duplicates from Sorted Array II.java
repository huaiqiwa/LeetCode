public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<=2) return A.length; 
     int count=1; 
     int start=1;
     for(int i=1; i<A.length; i++)
     {
         if(A[i]==A[i-1])
         {
             if(count<2)
             {
             A[start]=A[i];
             start++; 
             count++; 
             }
         }else
         {
             count=1; 
             A[start]=A[i]; 
             start++; 
         }
     }
     return start>=A.length? A.length: start;
    }
}


public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int index = 0;
        boolean hasCountedDup = false;
        for(int i = 1; i < A.length; i++) {
        	if(A[index] != A[i]) {
        		index++;
        		A[index] = A[i];
        		hasCountedDup = false;
        	} else if(!hasCountedDup) {
        		index++;
        		A[index] = A[i];
        		hasCountedDup = true;
        	} 
        }
        
        return index+1;
    }
}


public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int index = 0;
        int count = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] != A[index]) {
                index++;
                A[index] = A[i];
                count = 1;
            } else if(count < 2) {
                index++;
                A[index] = A[i];
                count++;
            }
        }
        return index+1;
    }
}
















