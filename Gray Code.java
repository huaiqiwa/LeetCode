public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m=1<<n;
        for(int i=0; i<m ; i++) {
            result.add(i^(i>>1));
        }
        return result; 
    }
}


public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for(int i = 0; i < n; i++) {
        	int b = 1 << i;
        	for(int j = result.size()-1; j >= 0; j--) {
        		result.add(result.get(j) | b);
        	}
        }
        return result;
    }
}


//kth gray code
public int kthGrayCode(int k) {
	return k ^ (k>>1);
}


//Gray Code Matrix
public int[][] grayMatrix(int n, int m) {  
	int nn = 1 << n, mm = 1 << m;
	int[][] matrix = new int[nn][mm];
	for(int i = 0; i < nn; i++) {
		int high = i ^ (i>>1);
		for(int j = 0; j < mm; j++) {
			matrix[i][j] = (high<<m) + (j^(j>>1)); 
		}
	}
	return matrix;
}  



















