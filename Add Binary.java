public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length()==0) return b; 
        if(b.length()==0) return a; 
        String result="";
        int carry=0; 
        for(int i=0; i<Math.max(a.length(), b.length()); i++)
        {
            int x=i>a.length()-1? 0: a.charAt(a.length()-1-i)-'0'; 
            int y=i>b.length()-1? 0: b.charAt(b.length()-1-i)-'0';
            int temp=(x+y+carry)%2; 
            result=temp+result; 
            carry=(x+y+carry)/2;
        }
        if(carry!=0) result="1"+result; 
        return result; 
    }
}


public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) {
        	String c = a;
        	a = b;
        	b = c;
        }
        int len1 = a.length(), len2 = b.length();
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < len1; i++) {
        	int achar = a.charAt(len1-1-i)-'0';
        	int bchar = i > len2-1 ? 0 : b.charAt(len2-1-i)-'0';
        	int dig = (achar+bchar+carry) % 2;
        	result.append(dig);
        	carry = (achar+bchar+carry) / 2;
        }
        if(carry != 0) result.append(carry);
        return result.reverse().toString();
    }
}



















