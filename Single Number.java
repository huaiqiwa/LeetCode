public class Solution {
    public int singleNumber(int[] A) {
        int single = 0;
        for(int i = 0; i < A.length; i++) {
        	single ^= A[i];
        }
        return single;
    }
}