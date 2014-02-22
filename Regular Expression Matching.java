// careful about the boundary case

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.length()==0) return s.length()==0; 
        if(p.length()==1) return ( p.equals(".") && s.length()==1) ||p.equals(s);
        if(s.length()==0) return p.charAt(1)=='*'&& isMatch(s, p.substring(2));
        if(p.charAt(1)!='*')
        {
            if(p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))
            {
                return isMatch(s.substring(1), p.substring(1));
            }else return false; 
        }
        if(isMatch(s, p.substring(2))) return true; 
        if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') return isMatch(s.substring(1), p);
        return false;
    }

}


public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.length()==0) return s.length()==0; 
      int startS=0, startP=0; 
	       //s is only one character or the second p is not *
	    if(((startP+1==p.length()))||(startP+1<p.length() && p.charAt(startP+1)!='*'))
	        {
	            if(s.length()!=0 && (s.charAt(startS)==p.charAt(startP)|| p.charAt(startP)=='.') ) 
                return isMatch(s.substring(startS+1), p.substring(startP+1)); 
	            return false;
	        }
            while((startS!=s.length()) &&( p.charAt(startP)=='.'||s.charAt(startS)==p.charAt(startP)))
            {
                if(isMatch(s.substring(startS), p.substring(startP+2)) ) return true; 
                startS++; 
            }
	        return isMatch(s.substring(startS), p.substring(startP+2)); 
    }
}


/*
another solution
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.length()==0 ) return s.length()==0; 
        if(p.length()==1) return s.equals(p) || (p.equals(".")&&s.length()==1);
        if(p.charAt(1)!='*')
        {
            if(s.length()!=0 &&(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'))
            return isMatch(s.substring(1), p.substring(1));
            else return false; 
        }
        if(isMatch(s, p.substring(2))) return true; 
        if(s.length()>0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'))
        {
            return isMatch(s.substring(1), p);
        }
        return false; 
    }
}


public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int is, String p, int ip) {
    	int slen = s.length(), plen = p.length();
    	if(ip == plen) return is == slen;
    	if(ip == plen-1 || p.charAt(ip+1) != '*') {
    		if(is == slen) return false;
    		return (p.charAt(ip) == '.' || p.charAt(ip) == s.charAt(is)) && isMatch(s, is+1, p, ip+1);
    	}
    	int i = is;
    	while(i < slen && (p.charAt(ip) == '.' || p.charAt(ip) == s.charAt(i))) {
    		if(isMatch(s, i, p, ip+2)) return true;
    		i++;
    	}
    	return isMatch(s, i, p, ip+2);
    }
}


























