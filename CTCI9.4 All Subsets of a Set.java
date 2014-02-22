//Combinatorics
public ArrayList<ArrayList<Integer>> getSubSets2(ArrayList<Integer> set) {
	ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
	//*int is only 32-bit, will not work if set.size() > 31, long could expand the limit to 64-bit
	int max = 1 << set.size();
	for(int k = 0; k < max; k++) {
		ArrayList<Integer> subset = convertIntToSet(k, set);
		allsubsets.add(subset);
	}
	return allsubsets;
}

private ArrayList<Integer> covertIntToSet(int k, ArrayList<Integer> set) {
	ArrayList<Integer> subset = new ArrayList<Integer>();
	for(int i = k, index = 0; i > 0; i >>= 1) {
		if((i & 1) == 1) subset.add(set.get(index));
		index++;
	}
	return subset;
}


//Recursion
public ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set) {
	ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
	if(set.size() == 0) return allsubsets;
	ArrayList<Integer> subset = new ArrayList<Integer>();
	getSubSets(set, 0, subset, allsubsets);
	return allsubsets;
}

private void getSubSets(ArrayList<Integer> set, int index, ArrayList<Integer> subset, 
	ArrayList<ArrayList<Integer>> allsubsets) {
	if(index == set.size()) {
		allsubsets.add(new ArrayList<Integer>(subset));
		return;
	}
	
	getSubSets(set, index+1, subset, subsets);
	subset.add(set.get(index));
	getSubSets(set, index+1, subset, subsets);
	subset.remove(subset.size()-1);
}

public ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set) {
	ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
	if(set.size() == 0) return allsubsets;
	ArrayList<Integer> subset = new ArrayList<Integer>();
	getSubSets(set, 0, subset, allsubsets);
	return allsubsets;
}

private void getSubSets(ArrayList<Integer> set, int index, ArrayList<Integer> subset, 
	ArrayList<ArrayList<Integer>> allsubsets) {
	if(index == set.size()) {
		allsubsets.add(new ArrayList<Integer>(subset));
		return;
	}
	
	for(int i = index; i < set.size(); i++) {
		int e = set.get(i);
		subset.add(e);
		getSubSets(set, i+1, subset, allsubsets);
		subset.remove(subset.size()-1);
	}
	getSubSets(set, set.size(), subset, allsubsets);
}







