public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return permute(num, 0); 
    }
    
    private ArrayList<ArrayList<Integer>> permute(int [] num, int index) {
        ArrayList<ArrayList<Integer>> subResult = new ArrayList<ArrayList<Integer>>(); 
        if(index == num.length) {
        	subResult.add(new ArrayList<Integer>()); 
        	return subResult; 
        }
        
        ArrayList<ArrayList<Integer>> result = permute(num, index+1);
        //postorder DFS, bottom-up
        for(ArrayList<Integer> list: result) {
             for(int i=0; i<=list.size(); i++) {
                 list.add(i, num[index]); 
                 subResult.add(new ArrayList<Integer>(list));
                 list.remove(i);
             }
        }
        return subResult; 
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0) return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> nums = new ArrayList<Integer>(num.length);
        for(int i = 0; i < num.length; i++) {
        	nums.add(num[i]);
        }
        permute(nums, result, results);
        return results; 
    }
    
    private void permute(ArrayList<Integer> nums, ArrayList<Integer> result, 
    	ArrayList<ArrayList<Integer>> results) { 
        if(nums.size() == 0) {
        	results.add(new ArrayList<Integer>(result)); 
        	return; 
        }
        
        for(int i = 0; i < nums.size(); i++) {
        	int e = nums.get(i);
        	result.add(e);
        	nums.remove(i);
        	permute(nums, result, results);
        	result.remove(result.size()-1);
        	nums.add(i, e);
        }
    }
}

