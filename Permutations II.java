public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
        	if(!count.containsKey(num[i])) count.put(num[i], 1);
        	else count.put(num[i], count.get(num[i])+1);        	
        }
        
        ArrayList<Integer> numUni = new ArrayList<Integer>(count.size());
        ArrayList<Integer> numCount = new ArrayList<Integer>(count.size());
        for(int e: count.keySet()) {
        	numUni.add(e);
        	numCount.add(count.get(e));        	
        }
        
        return permuteUnique(numUni, numCount);
    }
    
    private ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> numUni, ArrayList<Integer> numCount) {
    	ArrayList<ArrayList<Integer>> subResults = new ArrayList<ArrayList<Integer>>();
    	if(numUni.size() == 0) {
    		subResults.add(new ArrayList<Integer>());
    		return subResults;
    	} 
    	
    	for(int i = 0; i < numUni.size(); i++) {
    		int e = numUni.get(i);
    		boolean removed = false;
    		if(numCount.get(i) == 1) {
    			numUni.remove(i);
    			numCount.remove(i);
    			removed = true;
    		} else {
    			numCount.set(i, numCount.get(i)-1);
    		}
    		
    		for(ArrayList<Integer> list: permuteUnique(numUni, numCount)) {
    			list.add(e);
    			subResults.add(new ArrayList<Integer>(list));
    			list.remove(list.size()-1);
    		}
    		
    		if(removed) {
    			numUni.add(i, e);
    			numCount.add(i, 1);
    		} else {
    			numCount.set(i, numCount.get(i)+1);
    		}
    		
    	}
    	
    	return subResults;
    }
    
}


public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
        	if(!count.containsKey(num[i])) count.put(num[i], 1);
        	else count.put(num[i], count.get(num[i])+1);        	
        }
        
        ArrayList<Integer> numUni = new ArrayList<Integer>(count.size());
        ArrayList<Integer> numCount = new ArrayList<Integer>(count.size());
        for(int e: count.keySet()) {
        	numUni.add(e);
        	numCount.add(count.get(e));        	
        }
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>(num.length);
        permuteUnique(numUni, numCount, result, results);
        return results;
    }
    
    private void permuteUnique(ArrayList<Integer> numUni, ArrayList<Integer> numCount, 
    	ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
    	if(numUni.size() == 0) {
    		results.add(new ArrayList<Integer>(result));
    		return;
    	} 
    	
    	for(int i = 0; i < numUni.size(); i++) {
    		int e = numUni.get(i);
    		boolean removed = false;
    		if(numCount.get(i) == 1) {
    			numUni.remove(i);
    			numCount.remove(i);
    			removed = true;
    		} else {
    			numCount.set(i, numCount.get(i)-1);
    		}
    		
			result.add(e);
			permuteUnique(numUni, numCount, result, results);
			result.remove(result.size()-1); 		
    		
    		if(removed) {
    			numUni.add(i, e);
    			numCount.add(i, 1);
    		} else {
    			numCount.set(i, numCount.get(i)+1);
    		}
    		
    	}
    	
    }
    
}


public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
        	if(numCount.containsKey(num[i])) numCount.put(num[i], numCount.get(num[i])+1);
        	else numCount.put(num[i], 1);
        }
        ArrayList<Integer> nums = new ArrayList<Integer>(numCount.size());
        ArrayList<Integer> counts = new ArrayList<Integer>(numCount.size());
        for(int n : numCount.keySet()) {
        	nums.add(n);
        	counts.add(numCount.get(n));
        }
        
        ArrayList<ArrayList<Integer>> perms = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> perm = new ArrayList<Integer>(num.length);
        permuteUnique(nums, counts, perm, perms);
        return perms;
    }
    
    private void permuteUnique(ArrayList<Integer> nums, ArrayList<Integer> counts,
    	ArrayList<Integer> perm, ArrayList<ArrayList<Integer>> perms) {
    	if(nums.size() == 0) {
    		perms.add(new ArrayList<Integer>(perm));
    		return;
    	}
    	for(int i = 0; i < nums.size(); i++) {
    		int num = nums.get(i);
    		boolean removed = false;
    		if(counts.get(i) == 1) {
    			nums.remove(i);
    			counts.remove(i);
    			removed = true;
    		} else {
    			counts.set(i, counts.get(i)-1);
    		}
    		perm.add(num);
    		permuteUnique(nums, counts, perm, perms);
    		perm.remove(perm.size()-1);
    		if(removed) {
    			nums.add(i, num);
    			counts.add(i, 1);
    		} else {
    			counts.set(i, counts.get(i)+1);
    		}
    	}
    }
}

































