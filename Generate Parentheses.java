public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result=new ArrayList<String>(); 
        if(n==0) return result; 
        generate(result, "", n, n);
        return result; 
    }
    void generate(ArrayList<String> result, String subResult, int left, int right)
    {
        if(left==0 && right==0)
        {
            result.add(subResult); return ; 
        }
        if(left>0)
        {
            generate(result, subResult+'(', left-1, right);
        }
        if(left<right && right>0)
        {
            generate(result, subResult+')', left, right-1);
        }
    }
}


public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        StringBuilder result = new StringBuilder();
        generateParenthesis(0, 0, n, result, results);
        return results;
    }
    
    private void generateParenthesis(int leftNum, int rightNum, int n, 
    	StringBuilder result, ArrayList<String> results) {
    	if(rightNum == n) {
    		results.add(result.toString());
    		return;
    	}
    	if(leftNum < n) {
    		result.append('(');
    		generateParenthesis(leftNum+1, rightNum, n, result, results);
    		result.delete(result.length()-1, result.length());
    	}
    	if(leftNum > rightNum) {
    		result.append(')');
    		generateParenthesis(leftNum, rightNum+1, n, result, results);
    		result.delete(result.length()-1, result.length());
    	}
    }
}


public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> pares = new ArrayList<String>();
        if(n <= 0) return pares;
        StringBuilder pare = new StringBuilder();
        generateParenthesis(n, n, pare, pares);
        return pares;
    }
    
    private void generateParenthesis(int leftLeft, int rightLeft,
    	StringBuilder pare, ArrayList<String> pares) {
    	if(leftLeft == 0 && rightLeft == 0) {
    		pares.add(pare.toString());
    		return;
    	}
    	if(leftLeft > 0) {
    		pare.append('(');
    		generateParenthesis(leftLeft-1, rightLeft, pare, pares);
    		pare.delete(pare.length()-1, pare.length());
    	}
    	if(rightLeft > leftLeft) {
    		pare.append(')');
    		generateParenthesis(leftLeft, rightLeft-1, pare, pares);
    		pare.delete(pare.length()-1, pare.length());
    	}
    }
}

























