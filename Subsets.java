public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>(); 
        ArrayList<Integer> result = new ArrayList<Integer>();
        results.add(result);
        if(S.length == 0) return results;
         
        Arrays.sort(S);      
        for(int i = 0; i < S.length; i++) {
        	int curSize = results.size();
            for(int j = 0; j < curSize; j++) {
                ArrayList<Integer> aresult = new ArrayList<Integer>(results.get(j));
                aresult.add(S[i]);
                results.add(aresult);
            }
        }
        return results; 
    }
}


public class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
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
	
		getSubSets(S, index+1, subset, allsubsets);
		subset.add(S[index]);
		getSubSets(S, index+1, subset, allsubsets);
		subset.remove(subset.size()-1);
	}
}


public class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
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
			subset.add(S[i]);
			getSubSets(S, i+1, subset, allsubsets);
			subset.remove(subset.size()-1);
		}
		
		getSubSets(S, S.length, subset, allsubsets);
	}
}






