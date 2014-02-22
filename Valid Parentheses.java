public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> st=new Stack<Character>();
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='(') st.push('(');
            else if(s.charAt(i)=='{') st.push('{');
            else if(s.charAt(i)=='[') st.push('[');
            else if(st.isEmpty()) return false; 
            else
            {
                char pop=st.pop();
                if(pop=='(' && s.charAt(i)!=')') return false; 
                if(pop=='[' && s.charAt(i)!=']') return false; 
                if(pop=='{' && s.charAt(i)!='}') return false; 
            }
        }
        return st.isEmpty(); 
    }
}


public class Solution {
    public boolean isValid(String s) {
    	Stack<Character> left = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(c == '(' || c == '[' || c == '{') {
        		left.push(c);
        	} else {
        		if(left.isEmpty() || !isPair(left.pop(), c)) return false;
        	}
        }
        return left.isEmpty();
    }
    
    private boolean isPair(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}


public class Solution {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') left.push(c);
            else if(left.isEmpty() || !isPair(left.pop(), c)) return false;
        }
        return left.isEmpty();
    }
    
    private boolean isPair(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}



























