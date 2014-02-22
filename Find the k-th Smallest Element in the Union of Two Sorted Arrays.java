public class Solution {
	public int findKthSmallest(int[] A, int[] B, int k) {
		if(A.length+B.length > k) return Integer.MAX_VALUE;
		return findKthSmallest(A, 0, A.length-1, B, 0, B.length-1, k);
	}
	
	private int findKthSmallest(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
		int alen = aend-astart+1, blen = bend-bstart+1;
		int ai = (int)((double)alen / (alen+blen) * (k-1));
		int bi = (k-1) - ai;
		int i = astart + ai, j = bstart + bi;
		int Ai_1 = (i == astart ? Integer.MIN_VALUE : A[i-1]);
		int Bj_1 = (j == bstart ? Integer.MIN_VALUE : B[j-1]);
		int Ai = (i == aend+1 ? Integer.MAX_VALUE : A[i]);
		int Bj = (j == bend+1 ? Integer.MAX_VALUE : B[j]);
		if(Bj_1 < Ai && Ai < Bj) return Ai;
		if(Ai_1 < Bj && Bj < Ai) return Bj;
		if(Ai < Bj) return findKthSmallest(A, i+1, aend, B, bstart, bend, k-ai-1);
		//Bj < Ai
		return findKthSmallest(A, astart, aend, B, j+1, bend, k-bi-1);
	}
}