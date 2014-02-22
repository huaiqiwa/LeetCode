public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        /*
        brillant idea to store those values into string
        */
        String [] arrays=new String[10];
        arrays[2]="abc"; 
        arrays[3]="def";
        arrays[4]="ghi";
        arrays[5]="jkl";
        arrays[6]="mno";
        arrays[7]="pqrs";
        arrays[8]="tuv";
        arrays[9]="wxyz";
        ArrayList<String> result=new ArrayList<String>();
        result.add("");
        if(digits.length()==0) return result; 
        for(int i=0; i<digits.length(); i++ )
        {
            String num=arrays[digits.charAt(i)-'0']; 
            ArrayList<String> tempResult=new ArrayList<String>(); 
            for(String s:result)
            {
               for(int j=0; j<num.length(); j++)
               {
                tempResult.add(s+num.charAt(j));
               }   
            }
            result=tempResult; 
        }
        return result; 
    }
}


public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> results = new ArrayList<String>();
        StringBuilder result = new StringBuilder();
        letterCombinations(digits, 0, letters, result, results);
        return results;
    }
    
    private void letterCombinations(String digits, int index, String[] letters, 
    	StringBuilder result, ArrayList<String> results) {
    	if(index == digits.length()) {
    		results.add(result.toString());
    		return;
    	}
    	char curChar = digits.charAt(index);
    	String chars = letters[curChar-'2'];
    	for(int i = 0; i < chars.length(); i++) {
    		result.append(chars.charAt(i));
    		letterCombinations(digits, index+1, letters, result, results);
    		result.delete(result.length()-1, result.length());
    	}
    }
}































