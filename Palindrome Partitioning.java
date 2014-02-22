public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
		if(s == null || s.length() == 0)
			return new ArrayList<ArrayList<String>>();
		boolean[][] isPa = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++){
			isPa[i][i] = true;
		}
		for(int i = s.length() - 2; i >= 0; i --){
			isPa[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			for(int j = i + 2; j < s.length(); j++) 
				isPa[i][j] = (s.charAt(i) == s.charAt(j)) && isPa[i + 1][j - 1];
		}
		return partitionHelper(s, 0, isPa);
	}

	public ArrayList<ArrayList<String>> partitionHelper(String s, int start, boolean[][] isPa){
		ArrayList<ArrayList<String>> pa = new ArrayList<ArrayList<String>>();
		if(start == s.length()){
			pa.add(new ArrayList<String>());
			return pa;
		}
		for(int i = start; i < s.length(); i++){
			if(isPa[start][i])
				for(ArrayList<String> subPa: partitionHelper(s, i + 1, isPa)){
					subPa.add(0, s.substring(start, i + 1));
					pa.add(subPa);
				}
		}
		return pa;
	}
}


public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
    	int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for(int len = 0; len < n; len++) {
        	for(int i = 0; i+len < n; i++) {
        		if(len == 0) isPalin[i][i+len] = true;
        		else if(len == 1) isPalin[i][i+len] = (s.charAt(i) == s.charAt(i+len));
        		else isPalin[i][i+len] = isPalin[i+1][i+len-1] && (s.charAt(i) == s.charAt(i+len));
        	}
        }
        
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        partition(s, 0, isPalin, result, results);
        return results;
    }
    
    private void partition(String s, int start, boolean[][] isPalin, 
    	ArrayList<String> result, ArrayList<ArrayList<String>> results) {
    	if(start == s.length()) {
    		results.add(new ArrayList<String>(result));
    		return;
    	}
    	for(int i = start; i < s.length(); i++) {
    		if(isPalin[start][i]) {
    			result.add(s.substring(start, i+1));
    			partition(s, i+1, isPalin, result, results);
    			result.remove(result.size()-1);
    		}
    	}
    }
}


public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
    	int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for(int j = 0; j < n; j++) {
        	for(int i = 0; i <= j; i++) {
        		if(j-i == 0) isPalin[i][j] = true;
        		else if(j-i == 1) isPalin[i][j] = (s.charAt(i) == s.charAt(j));
        		else isPalin[i][j] = isPalin[i+1][j-1] && (s.charAt(i) == s.charAt(j));
        	}
        }
        
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        partition(s, 0, isPalin, result, results);
        return results;
    }
    
    private void partition(String s, int start, boolean[][] isPalin, 
    	ArrayList<String> result, ArrayList<ArrayList<String>> results) {
    	if(start == s.length()) {
    		results.add(new ArrayList<String>(result));
    		return;
    	}
    	for(int i = start; i < s.length(); i++) {
    		if(isPalin[start][i]) {
    			result.add(s.substring(start, i+1));
    			partition(s, i+1, isPalin, result, results);
    			result.remove(result.size()-1);
    		}
    	}
    }
}




























