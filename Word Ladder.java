public class Solution {
    public static int ladderLength(String start, String end, HashSet<String> dict) {
            // Start typing your Java solution below
          // DO NOT write main() function
	    if(start.length()!=end.length()) return 0; 
	    if(start.compareTo("")==0) return 1; 
	    ArrayList<String> newStart=new ArrayList<String>();
	    newStart.add(start);
		int distance=1; 
		ArrayList<String> nextStart=new ArrayList<String>();
	    for(int index=0; index<newStart.size() && dict.size()>0; index++  )
	    {	    	
	        String current=newStart.get(index);        
	        for(int i=0; i<current.length(); i++)
	        {
			    for(char j='a'; j<='z'; j++)
			    {
	        		if(current.charAt(i)==j) continue; 
	        		String temp=current.substring(0, i)+j+current.substring(i+1);        		
				    if(temp.equals(end)) return distance+1; 
				    if(dict.contains(temp))
				    {
	                    nextStart.add(temp);
	                    dict.remove(temp);
	    		    }
			    }
		    }
	        if(index==newStart.size()-1)
	        {
	            newStart.addAll(new ArrayList<String>(nextStart));
	            nextStart=new ArrayList<String>();
	            distance++; 
	        }
	    }
		return 0; 
	    }
}


public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(start.length() != end.length()) return 0;
        if(start.equals(end)) return 1;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        int curLevel = 1;
        int nextLevel = 0;
        int dis = 2;
        while(!queue.isEmpty()) {
        	String cur = queue.poll();
        	curLevel--;
        	for(int i = 0; i < cur.length(); i++) {
        		for(char j = 'a'; j <= 'z'; j++) {
        			if(cur.charAt(i) == j) continue;
        			String next = cur.substring(0, i) + j + cur.substring(i+1);
        			if(next.equals(end)) return dis;
        			if(dict.contains(next) && !visited.contains(next)) {
        				queue.offer(next);
        				visited.add(next);
        				nextLevel++;
        			}
        		}
        	}
        	if(curLevel == 0) {
        		curLevel = nextLevel;
        		nextLevel = 0;
        		dis++;
        	}
        }
        return 0;
    }
}

































