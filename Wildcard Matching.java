public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.length()==0) return s.length()==0; 
        if(s.length()==0)
        {
            if(p.charAt(0)!='*') return false; 
            return isMatch("", p.substring(1));
        }
        if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='?')
        return isMatch(s.substring(1), p.substring(1));
        if(p.charAt(0)=='*')
        {
            while(p.length()>1 && p.charAt(1)=='*' )
            {
                p=p.substring(1);
            }
            if(isMatch(s.substring(1), p)) return true; 
            return isMatch(s, p.substring(1));
        }
        return false; 
    }
}


//another solution: 
public class Solution {
    int count; 
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        count=0; 
        p=preProcess(p);
        if(count>s.length()) return false; 
        return check(s, p);
    }
    boolean check(String s, String p)
    {
         if(s.length()==0)   return p.length()==0 || p.equals("*") ; 
         if(s.length()!=0 && p.length()==0)   return false; 
         if(s.charAt(0)==p.charAt(0)||p.charAt(0)=='?') return check(s.substring(1), p.substring(1));
         if(p.charAt(0)!='*') return false; 
         return check(s, p.substring(1)) || check(s.substring(1), p);
    }
    String preProcess(String p)
    {
        StringBuffer sb=new StringBuffer(); 
        boolean flag=false; 
        for(int i=0; i<p.length(); i++)
        {
            if(p.charAt(i)!='*')
            {
                count++; flag=false; sb.append(p.charAt(i));
            }else
            {
                if(!flag)
                {
                    flag=true; sb.append(p.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}


public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int is, String p, int ip) {
    	int slen = s.length(), plen = p.length();
    	if(ip == plen) return is == slen;
    	if(is != slen && p.charAt(ip) != '*') {
    		return (p.charAt(ip) == '?' || p.charAt(ip) == s.charAt(is)) && isMatch(s, is+1, p, ip+1);
    	}
    	if(p.charAt(ip) == '*') {
    		while(ip < plen && p.charAt(ip) == '*') {
    			ip++;
    		}
			int i = is;
			while(i <= slen) {
				if(isMatch(s, i, p, ip)) return true;
				i++;
			}
    	}
    	return false;
    }
}


public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        int count = 0;
        for(int i = 0; i < plen; i++) {
        	if(p.charAt(i) != '*') count++;
        }
        if(count > slen) return false;
        boolean[] matches = new boolean[slen+1];
        matches[0] = true;
        int firstMatch = 0;
        for(int i = 0; i < plen; i++) {
        	if(i > 0 && p.charAt(i) == '*' && p.charAt(i-1) == '*') continue;
			if(p.charAt(i) == '*') {
				for(int j = firstMatch+1; j <= slen; j++) matches[j] = true;
			} else {
				int match = -1;
				for(int j = slen; j > firstMatch; j--) {
					matches[j] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j-1)) && matches[j-1];
					if(matches[j]) match = j;
				}
				if(match < 0) return false;
				firstMatch = match;	
			}
        }
        return matches[slen];
    }
}


public class Solution {
    public boolean isMatch(String s, String p) {
        int starPos = -1, lastStart = 0;
        int is = 0, ip = 0;
        while(is < s.length()) {
            if(ip < p.length() && p.charAt(ip) == '*') {
                starPos = ip;
                ip++;
                lastStart = is;
                continue;
            }
            if(ip < p.length() && (p.charAt(ip) == '?' || p.charAt(ip) == s.charAt(is))) {
                ip++; is++;
                continue;
            }
            if(starPos != -1) {
                ip = starPos + 1;
                lastStart++;
                is = lastStart;
                continue;
            }
            return false;
        }
        while(ip < p.length() && p.charAt(ip) == '*') {
            ip++;
        }
        return ip == p.length();
    }
}             





























