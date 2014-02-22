public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult=new ArrayList<Integer>();
        Arrays.sort(candidates);
        solve(result,  candidates, 0 ,  target, subResult, 0); 
        return result; 
    }
    
    void solve(ArrayList<ArrayList<Integer>> result, int[] candidates, int sum, int target, ArrayList<Integer> subResult, int prevIndx)
    {
        if(sum>target) return; 
        if(sum==target)
        {
            result.add(new ArrayList<Integer>(subResult));
        }
        for(int i=prevIndx; i<candidates.length; i++)
        {
            //previous node can be added multiple times
            subResult.add(candidates[i]);
            solve(result, candidates, sum+candidates[i], target, subResult, i);
            subResult.remove(subResult.size()-1);
        }
    }
}

//Implementation, especially recursion, should also avoid repeated recursions 
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(candidates.length == 0) return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, 0, result, results);
        return results;
    }
    
    private void combinationSum(int[] candidates, int target, int index, int sum,
    	ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
    	if(sum > target) return;
    	if(sum == target) {
    		results.add(new ArrayList<Integer>(result));
    		return;
    	}
    	
    	for(int i = index; i < candidates.length; i++) {
    		if(sum+candidates[i] > target) break;
    		result.add(candidates[i]);
    		combinationSum(candidates, target, i, sum+candidates[i], result, results);
    		result.remove(result.size()-1);
    	}
    }
}


//CTCI 9.8 infinite change
public int makeChange(int n) {
	int[] denom = new int[4]{25, 10, 5, 1};
	return makeChange(n, denom);
}

private int makeChange(int n, int[] denom) {
	if(n == 0) return 1;
	if(n < 0) return 0;
	int total = 0;
	for(int i = 0; i < denom.length; i++) {
		total += makeChange(n-denom[i], denom);
	}
	return total;
}

















