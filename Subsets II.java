public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>(); 
         ArrayList<Integer> result = new ArrayList<Integer>();
         results.add(result);
         if(num.length == 0) return results;
         
         Arrays.sort(num);
         int j = 0; 
         for(int i = 0; i < num.length; i++) {
             int size = results.size();
             for(; j < size; j++) {
                 ArrayList<Integer> aresult = new ArrayList(results.get(j));
                 aresult.add(num[i]);
                 results.add(aresult);
             }
             if(i+1 < num.length && num[i] == num[i+1]) j = size;
             else j = 0;              
         }
         return results; 
    }
}
/*
if we meet dup values, we start from the previous starting point
e.g. [1, 1, 2, 2]
[]  [1]
    [1, 1]
[2] [1, 2]  [1, 1, 2]
[2, 2]  [1, 2, 2]   [1, 1, 2, 2]
*/


public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		if(S.length == 0) return allsubsets;
		ArrayList<Integer> subset = new ArrayList<Integer>();
		Arrays.sort(S);
		getSubSets(S, 0, subset, allsubsets);
		return allsubsets;
	}

	private void getSubSets(int[] S, int index, ArrayList<Integer> subset, 
		ArrayList<ArrayList<Integer>> allsubsets) {
		if(index == S.length) {
			allsubsets.add(new ArrayList<Integer>(subset));
			return;
		}
	
		for(int i = index; i < S.length; i++) {
			if(i > index && S[i] == S[i-1]) continue;
			subset.add(S[i]);
			getSubSets(S, i+1, subset, allsubsets);
			subset.remove(subset.size()-1);
		}
		
		getSubSets(S, S.length, subset, allsubsets);
	}
}







