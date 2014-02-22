public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle.size()==0) return Integer.MAX_VALUE;
        ArrayList<Integer> list=triangle.get(triangle.size()-1);
        for(int i=triangle.size()-2; i>=0 ; i--)
        {
            for(int j=0; j<=i; j++)
            {
                //greedy approach
                int val=triangle.get(i).get(j)+Math.min(list.get(j), list.get(j+1));
                list.remove(j);
                list.add(j, val);
            }
        }
        return list.get(0);
    }
}


public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	int n = triangle.size();
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
        	ArrayList<Integer> curRow = triangle.get(i);
        	int preNum = result[0];
        	for(int j = 0; j < curRow.size(); j++) {
        		int curNum = curRow.get(j);
        		if(j == 0) result[j] += curNum;
        		else if(j == curRow.size()-1) {
        			int nextNum = preNum + curNum;
        			preNum = result[j];
        			result[j] = nextNum;
        		}
        		else {
        			int nextNum = Math.min(preNum, result[j]) + curNum;
        			preNum = result[j];
        			result[j] = nextNum;
        		}
        	}
        }
        int minTotal = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
        	minTotal = Math.min(minTotal, result[i]);
        }
        return minTotal;
    }
}


public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0) return Integer.MAX_VALUE;
        int[] result = new int[n];
        result[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            ArrayList<Integer> curRow = triangle.get(i);
            for(int j = curRow.size()-1; j >= 0; j--) {
                int pre = Integer.MAX_VALUE;
                int cur = Integer.MAX_VALUE;
                if(j > 0) pre = result[j-1];
                if(j < curRow.size()-1) cur = result[j];
                result[j] = Math.min(pre, cur) + curRow.get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, result[i]);
        }
        return min;
    }
}



























