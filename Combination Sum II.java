public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> list=new ArrayList<Integer>(); 
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(); 
        Arrays.sort(num);
        combination(num, 0, target, 0, list, result ) ;
        return result; 
    }
    void combination(int [] candidates, int index,int target, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result )
    {
        if(sum>target) return ;
        if(sum==target)
        {
            result.add(new ArrayList<Integer>(list)); return ;
        }
        
        for(int i=index; i<candidates.length; i++)
        {
            if(i>index && candidates[i]==candidates[i-1]) continue; 
            list.add(candidates[i]);
            combination(candidates, i+1, target ,sum+candidates[i], list, result);
            list.remove(list.size()-1);
        }
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(candidates.length == 0) return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, 0, result, results);
        return results;
    }
    
    private void combinationSum2(int[] candidates, int target, int index, int sum,
    	ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
    	if(sum > target) return;
    	if(sum == target) {
    		results.add(new ArrayList<Integer>(result));
    		return;
    	}
    	
    	for(int i = index; i < candidates.length; i++) {
    		if(sum+candidates[i] > target) break;
    		if(i > index && candidates[i] == candidates[i-1]) continue;
    		result.add(candidates[i]);
    		combinationSum(candidates, target, i+1, sum+candidates[i], result, results);
    		result.remove(result.size()-1);
    	}
    }
}