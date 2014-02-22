public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
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
        return canBreak[n];
    }
}

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] canBreak = new boolean[n];
        for(int j = 0; j < n; j++) {
            for(int i = 0; i <= j; i++) {
                String right = s.substring(i, j+1);
                if(i == 0) canBreak[j] = dict.contains(right);
                else canBreak[j] = canBreak[i-1] && dict.contains(right);
                if(canBreak[j]) break;
            }
        }
        return canBreak[n-1];
    }
}