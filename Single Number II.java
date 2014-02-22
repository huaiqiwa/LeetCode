public class Solution {
    public int singleNumber(int[] A) {
        int[] bits = new int[32];
        int result = 0;
        for(int i = 0; i < bits.length; i++) {
        	for(int j = 0; j < A.length; j++) {
        		if(((A[j] >> i) & 1) == 1) bits[i] = (bits[i]+1) % 3;
        	}
        	if(bits[i] != 0) result |= (1 << i);
        }
        return result;
    }
}