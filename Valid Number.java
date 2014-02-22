public class Solution {
    public boolean isNumber(String s) {
        int start = 0, end = s.length()-1;
        while(start <= end && (s.charAt(start) == ' ' || s.charAt(end) == ' ')) {
        	if(s.charAt(start) == ' ') start++;
        	if(s.charAt(end) == ' ') end--;
        }
        if(start > end) return false;
        s = s.substring(start, end+1);
        if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
        int dotIndex = -1, eIndex = -1, signIndex = -1, slen = s.length();
        if(slen == 0) return false;
        for(int i = 0; i < slen; i++) {
        	char c = s.charAt(i);
        	if(c == '.') {
        		if(dotIndex == -1) dotIndex = i;
        		else return false;
        		if(eIndex != -1) return false;
        		continue;
        	}
        	if(c == 'e' || c == 'E') {
        		if(eIndex == -1) eIndex = i;
        		else return false;
        		continue;
        	}
        	if(c == '-' || c == '+') {
        		if(signIndex == -1) signIndex = i;
        		else return false;
        		if(eIndex == -1 || eIndex+1 != signIndex) return false;
        		continue;
        	}
        	if(c >= '0' && c <= '9') continue;
        	return false;
        }
        if(eIndex != -1) {
        	String afterE = s.substring(eIndex+1);
        	if(afterE.length() == 0) return false;
        	if(afterE.charAt(0) == '-' || afterE.charAt(0) == '+') afterE = afterE.substring(1);
        	if(afterE.length() == 0) return false;
        	s = s.substring(0, eIndex);
        	if(s.length() == 0) return false;
        }
        if(dotIndex != -1 && s.length() == 1) return false;
        return true;
    }
}

//Assume integer 00, 001 ... is valid
public class Solution {
    public boolean isNumber(String s) {
        int start = 0, end = s.length()-1;
        while(start <= end && (s.charAt(start) == ' ' || s.charAt(end) == ' ')) {
            if(s.charAt(start) == ' ') start++;
            if(s.charAt(end) == ' ') end--;
        }
        if(start > end) return false;
        s = s.substring(start, end+1);
        if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
        int dotIndex = -1, eIndex = -1, signIndex = -1, slen = s.length();
        if(slen == 0) return false;
        for(int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            if(c == '.') {
                if(dotIndex == -1) dotIndex = i;
                else return false;
                if(eIndex != -1) return false;
                continue;
            }
            if(c == 'e' || c == 'E') {
                if(eIndex == -1) eIndex = i;
                else return false;
                continue;
            }
            if(c == '-' || c == '+') {
                if(signIndex == -1) signIndex = i;
                else return false;
                if(eIndex == -1 || eIndex+1 != signIndex) return false;
                continue;
            }
            if(c < '0' || c > '9') return false;
        }
        if(eIndex != -1) {
            String afterE = s.substring(eIndex+1);
            if(afterE.length() == 0) return false;
            if(afterE.charAt(0) == '-' || afterE.charAt(0) == '+') afterE = afterE.substring(1);
            if(afterE.length() == 0) return false;
            s = s.substring(0, eIndex);
            if(s.length() == 0) return false;
        }
        if(dotIndex != -1 && s.length() == 1) return false;
        return true;
    }
}

//Assume integer 00, 001 ... is NOT valid
public class Solution {
    public boolean isNumber(String s) {
        int start = 0, end = s.length()-1;
        while(start <= end && (s.charAt(start) == ' ' || s.charAt(end) == ' ')) {
            if(s.charAt(start) == ' ') start++;
            if(s.charAt(end) == ' ') end--;
        }
        if(start > end) return false;
        s = s.substring(start, end+1);
        if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
        int dotIndex = -1, eIndex = -1, signIndex = -1, slen = s.length();
        if(slen == 0) return false;
        for(int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            if(c == '.') {
                if(dotIndex == -1) dotIndex = i;
                else return false;
                if(eIndex != -1) return false;
                continue;
            }
            if(c == 'e' || c == 'E') {
                if(eIndex == -1) eIndex = i;
                else return false;
                continue;
            }
            if(c == '-' || c == '+') {
                if(signIndex == -1) signIndex = i;
                else return false;
                if(eIndex == -1 || eIndex+1 != signIndex) return false;
                continue;
            }
            if(c < '0' || c > '9') return false;
        }
        if(eIndex != -1) {
            String afterE = s.substring(eIndex+1);
            if(afterE.length() == 0) return false;
            if(afterE.charAt(0) == '-' || afterE.charAt(0) == '+') afterE = afterE.substring(1);
            if(afterE.length() == 0) return false;
            if(afterE.length() >= 2 && afterE.charAt(0) == '0' && afterE.charAt(1) == '0')
                return false;
            s = s.substring(0, eIndex);
            if(s.length() == 0) return false;
        }
        if(dotIndex != -1) {
            if(s.length() == 1) return false;
            s = s.substring(0, dotIndex);
            if(s.length() >= 2 && s.charAt(0) == '0' && s.charAt(1) == '0') 
            	return false;
        }
        return true;
    }
}


public class Solution {
    public boolean isNumber(String s) {
        int start = 0, end = s.length()-1;
        while(start <= end && (s.charAt(start) == ' ' || s.charAt(end) == ' ')) {
            if(s.charAt(start) == ' ') start++;
            if(s.charAt(end) == ' ') end--;
        }
        if(start > end) return false;
        s = s.substring(start, end+1);
        if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
        int dotIndex = -1, eIndex = -1, signIndex = -1, slen = s.length();
        if(slen == 0) return false;
        for(int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            if(c == '.') {
                if(dotIndex == -1) dotIndex = i;
                else return false;
                if(eIndex != -1) return false;
                continue;
            }
            if(c == 'e' || c == 'E') {
                if(eIndex == -1) eIndex = i;
                else return false;
                continue;
            }
            if(c == '-' || c == '+') {
                if(signIndex == -1) signIndex = i;
                else return false;
                if(eIndex == -1 || eIndex+1 != signIndex) return false;
                continue;
            }
            if(c < '0' || c > '9') return false;
        }
        if(eIndex != -1) {
            String afterE = s.substring(eIndex+1);
            if(afterE.equals("") || afterE.equals("-") || afterE.equals("+")) return false;
            s = s.substring(0, eIndex);
        } 
        if(s.equals("") || s.equals(".")) return false;
        return true;
    }
}