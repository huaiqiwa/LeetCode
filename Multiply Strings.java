public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num1==null || num2==null) return null; 
        if(num1.equals("0") || num2.equals("0")) return "0";
        int []array=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1; i>=0; i--)
        {
            for(int j=num2.length()-1; j>=0; j--)
            {
                array[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        String result=""; 
        for(int i=num1.length()+num2.length()-1; i>0; i--)
        {
                array[i-1]+=array[i]/10;
                result=array[i]%10+result;
        }
        if(array[0]!=0) result=array[0]+result; 
        return result; 
    }
}


public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1+len2];
        for(int i = len1-1; i >= 0; i--) {
        	for(int j = len2-1; j >= 0; j--) {
        		result[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0'); 
        	}
        }
        
        StringBuilder theResult = new StringBuilder(); 
        for(int i = len1+len2-1; i > 0; i--) {
        	result[i-1] += result[i]/10;
        	theResult.append(result[i]%10);  
        }
        if(result[0] != 0) theResult.append(result[0]);
        return theResult.reverse().toString();
    }
}



















