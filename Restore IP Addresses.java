public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result=new ArrayList<String>(); 
        restore(result, 0, "", 0,  s); 
        return result; 
    }
    void restore(ArrayList<String> result, int part, String cur, int index,  String s)
    {
        if(index==s.length() && part==4)
        {
            result.add(cur.substring(0, cur.length()-1));
            return ;
        }
        if(s.length()-index<(4-part)) return ;
        if(s.length()-index>(4-part)*3) return ;
        int num=0; 
        for(int i=index; i<index+3 && i<s.length(); i++)
        {
            num=10*num+s.charAt(i)-'0';
            if(num<=255)
            {
                restore(result, part+1, cur+Integer.toString(num)+".", i+1,  s); 
            }
            if(num==0) break; 
        }     
    }
}


public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> results = new ArrayList<String>();
        StringBuilder result = new StringBuilder(); 
        restoreIpAddresses(s, 0, 0, result, results); 
        return results; 
    }
    private void restoreIpAddresses(String s, int is, int partNum, 
    	StringBuilder result, ArrayList<String> results) {
        if(is == s.length() && partNum == 4) {
            results.add(result.toString().substring(0, result.length()-1));
            return;
        }
        int charsLeft = s.length() - is;
        if(charsLeft < (4-partNum) || charsLeft > (4-partNum)*3) return;
        int num = 0; 
        for(int i = is; i < is+3 && i < s.length(); i++) {
            num = num*10 + (s.charAt(i)-'0');
            if(num <= 255) {
            	int prelen = result.length();
            	result.append(num).append('.');
            	restoreIpAddresses(s, i+1, partNum+1, result, results);
            	result.delete(prelen, result.length());
            } 
            if(num == 0) break; 
        }     
    }
}


public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> results = new ArrayList<String>();
        StringBuilder result = new StringBuilder(); 
        restoreIpAddresses(s, 0, 0, result, results); 
        return results; 
    }
    
    private void restoreIpAddresses(String s, int is, int partNum, 
    	StringBuilder result, ArrayList<String> results) {
        if(partNum == 4) {
            results.add(result.toString().substring(0, result.length()-1));
            return;
        }
        int num = 0; 
        for(int i = is; i < is+3 && i < s.length(); i++) {
            num = num*10 + (s.charAt(i)-'0');
            if(num <= 255 && (s.length()-i-1 >= 3-partNum && s.length()-i-1 <= 3*(3-partNum))) {
            	int prelen = result.length();
            	result.append(num).append('.');
            	restoreIpAddresses(s, i+1, partNum+1, result, results);
            	result.delete(prelen, result.length());
            } 
            if(num == 0) break; 
        }     
    }
}





