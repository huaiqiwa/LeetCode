public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list=new ArrayList<String>();
        String [] array=path.split("/");
        for(int i=0; i<array.length; i++)
        {
            if(array[i].length()==0||array[i].equals(".")) continue;
            if(array[i].equals(".."))
            {
                if(list.size()!=0)
                {
                    list.remove(list.size()-1); 
                }
                continue; 
            }
            list.add(array[i]);
        }
        StringBuffer sb=new StringBuffer();
        for(String s: list)
        {
            sb.append("/");
            sb.append(s);
        }
        return sb.length()==0? "/":sb.toString();
    }
}


public class Solution {
    public String simplifyPath(String path) {
        String[] symbols = path.split("/");
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < symbols.length; i++) {
        	String symbol = symbols[i];
        	if(symbol.length() == 0 || symbol.equals(".")) continue;
        	if(symbol.equals("..")) {
        		if(result.size() != 0) result.remove(result.size()-1);
        		continue;
        	}
        	result.add(symbol);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
        	sb.append("/");
        	sb.append(result.get(i));
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}


public class Solution {
    //Assume valid input
    public String simplifyPath(String path) {
        if(path.length() == 1) return "/";
        int preSlashIndex = -1, curSlashIndex = 0;
        ArrayList<String> segements = new ArrayList<String>();
        path = path + '/';
        for(int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if(c != '/') continue;
            preSlashIndex = curSlashIndex;
            curSlashIndex = i;
            String segement = path.substring(preSlashIndex+1, curSlashIndex);
            if(segement.length() == 0 || segement.equals(".")) continue;
            else if(segement.equals("..")) {
                if(segements.size() > 0) segements.remove(segements.size()-1);
            }
            else segements.add(segement);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < segements.size(); i++) {
            result.append('/').append(segements.get(i));
        }
        if(result.length() == 0) result.append('/');
        return result.toString();
    }
}




























