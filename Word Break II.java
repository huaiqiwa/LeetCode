public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        HashMap<Integer, ArrayList<String>> allresults = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> aresults = new ArrayList<String>();
        String aresult = "";
        aresults.add(aresult);
        allresults.put(0, aresults);
        for(int i = 1; i <= n; i++) {
        	ArrayList<String> curResults = new ArrayList<String>();
        	for(int j = 0; j < i; j++) {
        		if(allresults.get(j).size() == 0) continue;
        		String right = s.substring(j, i);
        		if(dict.contains(right)) {
        			ArrayList<String> preResults = allresults.get(j);
        			for(String preResult : preResults) {
        				String curResult;
        				if(i != n) curResult = preResult + right + " ";
        				else curResult = preResult + right;
        				curResults.add(curResult);
        			}
        		}
        	}
        	allresults.put(i, curResults);
        }
        return allresults.get(n);
    }
}


//pass OJ
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] canBreak = new boolean[n+1];
        canBreak[0] = true;
        for(int i = 1; i <= n; i++) {
        	for(int j = 0; j < i; j++) {
        		String right = s.substring(j, i);
        		canBreak[i] = canBreak[j] && dict.contains(right);
        		if(canBreak[i]) break;
        	}
        }
        ArrayList<String> results = new ArrayList<String>();
        if(!canBreak[n]) return results;
        StringBuilder result = new StringBuilder();
        wordBreak(s, dict, 0, canBreak, result, results);
        return results;
    }
    
    private void wordBreak(String s, Set<String> dict, int start, boolean[] canBreak,
    	StringBuilder result, ArrayList<String> results) {
    	int len = s.length();
    	if(start == len) {
    		results.add(result.toString());
    		return;
    	}
    	
    	for(int i = start; i < len; i++) {
    		if(canBreak[i+1]) {
    			String right = s.substring(start, i+1);
    			if(dict.contains(right)) {
    				int beforeAppend = result.length();
    				result.append(right);
    				if(i != len-1) result.append(" ");
    				wordBreak(s, dict, i+1, canBreak, result, results);
    				result.delete(beforeAppend, result.length());
    			}
    		}
    	}
    }
}
























