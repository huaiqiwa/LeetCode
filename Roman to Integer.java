public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Integer> map=new HashMap<Character, Integer>(); 
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int result=0; 
        for(int i=0; i<s.length()-1; i++)
        {
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1)))
            {
                result-=map.get(s.charAt(i));
            }else
            {
                result+=map.get(s.charAt(i));
            }
        }
        result+=map.get(s.charAt(s.length()-1));
        return result; 
    }
}


public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> getInt = new HashMap<Character, Integer>();
        getInt.put('M', 1000);
        getInt.put('D', 500);
        getInt.put('C', 100);
        getInt.put('L', 50);
        getInt.put('X', 10);
        getInt.put('V', 5);
        getInt.put('I', 1);
        
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(i < s.length()-1 && getInt.get(s.charAt(i)) < getInt.get(s.charAt(i+1))) {
        		result -= getInt.get(s.charAt(i));
        		result += getInt.get(s.charAt(i+1));
        		i++;
    			continue;
        	}
        	result += getInt.get(s.charAt(i));
        }
        return result;
    }
}
































