public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
        if(n < k || n < 1 || k < 1) return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        combine(n, k, 1, result, results);
        return results;
    }
    
    private void combine(int n, int k, int c, ArrayList<Integer> result, 
    	ArrayList<ArrayList<Integer>> results) {
        if(k == 0) {
            results.add(result);
            return; 
        }
        if(c+k-1 > n) return;
        
        combine(n, k, c+1, result, results);
        ArrayList<Integer> aresult = new ArrayList<Integer>(result);
        aresult.add(c);
        combine(n, k-1, c+1, aresult, results);
    }

}


public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
        if(n < k || n < 1 || k < 1) return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        combine(n, k, 1, result, results);
        return results;
    }
    
    private void combine(int n, int k, int c, ArrayList<Integer> result, 
    	ArrayList<ArrayList<Integer>> results) {
        if(k == 0) {
            results.add(new ArrayList<Integer>(result));
            return; 
        }
        if(c+k-1 > n) return;
        
        combine(n, k, c+1, result, results);
        result.add(c);
        combine(n, k-1, c+1, result, results);
        result.remove(result.size()-1);
    }

}


public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
        if(n < k || n < 1 || k < 1) return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        combine(n, k, 1, result, results);
        return results;
    }
    
    private void combine(int n, int k, int c, ArrayList<Integer> result, 
    	ArrayList<ArrayList<Integer>> results) {
        if(k == 0) {
            results.add(new ArrayList<Integer>(result));
            return; 
        }
        if(c+k-1 > n) return;
        
        for(int i = c; i <= n; i++) {
        	result.add(i);
        	combine(n, k-1, i+1, result, results);
        	result.remove(result.size()-1);
        }
    }
}








