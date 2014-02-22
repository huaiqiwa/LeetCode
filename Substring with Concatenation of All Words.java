public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(L.length==0) return result;
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        for(int i=0; i<L.length; i++)
        {
            if(map.containsKey(L[i]))
            {
                map.put(L[i], map.get(L[i])+1);
            }else
            {
                map.put(L[i], 1);
            }
        }
        int size=L.length; 
        int length=L[0].length(); 
        for(int i=0; i<=S.length()-length*size; i++)
        {
            HashMap<String, Integer> Tmap=new HashMap<String, Integer>(map);
            for(int j=0; j<size; j++)
            {
                String first=S.substring(i+j*length, i+(j+1)*length);
            if(Tmap.containsKey(first))
            {
                if(Tmap.get(first)==1)
                Tmap.remove(first);
                else
                Tmap.put(first, Tmap.get(first)-1);
            }else break; 
            }
            if(Tmap.isEmpty()) result.add(i);
        }
        return result; 
    }
}



public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(L.length == 0) return result;
        HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i++) {
        	if(!needToFind.containsKey(L[i])) needToFind.put(L[i], 1);
        	else needToFind.put(L[i], needToFind.get(L[i])+1);
        }
        
        HashMap<String, Integer> hasFound = new HashMap<String, Integer>();
        for(int i = 0; i <= S.length() - L.length*L[0].length(); i++) {
        	if(isValid(S, L, i, hasFound, needToFind)) result.add(i);
        }
        return result;
    }
    
    private boolean isValid(String S, String[] L, int index, 
    	HashMap<String, Integer> hasFound, HashMap<String, Integer> needToFind) {
    	int wordLength = L[0].length();
    	int count = L.length;
    	
    	for(int i = index; i <= S.length() - wordLength; i += wordLength) {
    		String cur = S.substring(i, i+wordLength);
    		if(!needToFind.containsKey(cur)) break;
    		if(!hasFound.containsKey(cur)) { 
    			hasFound.put(cur, 1);
    			count--;
    		} else {
    			if(hasFound.get(cur) < needToFind.get(cur)) {
    				hasFound.put(cur, hasFound.get(cur)+1);
    				count--;
    			} else break;
    		}
    	}
    
    	hasFound.clear();
    	return count == 0;
    }
}


public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(L.length == 0) return result;
        int wordLen = L[0].length();
        if(L.length*wordLen > S.length()) return result;
        HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i++) {
            if(!needToFind.containsKey(L[i])) needToFind.put(L[i], 1);
            else needToFind.put(L[i], needToFind.get(L[i])+1);
        }
        
        HashMap<String, Integer> hasFound = new HashMap<String, Integer>();
        for(int i = 0; i <= S.length() - L.length*wordLen; i++) {
            if(isValid(S, L, i, hasFound, needToFind)) result.add(i);
        }
        return result;
    }
    
    private boolean isValid(String S, String[] L, int index,
        HashMap<String, Integer> hasFound, HashMap<String, Integer> needToFind) {
        int wordLen = L[0].length();
        for(int i = index; i < index + L.length*wordLen; i += wordLen) {
            String cur = S.substring(i, i+wordLen);
            if(!needToFind.containsKey(cur)) {
                hasFound.clear();
                return false;
            }
            if(!hasFound.containsKey(cur)) hasFound.put(cur, 1);
            else if(hasFound.get(cur) < needToFind.get(cur)) 
                hasFound.put(cur, hasFound.get(cur)+1);
            else {
                hasFound.clear();
                return false;
            }
        }
        hasFound.clear();
        return true;
    }
}





















