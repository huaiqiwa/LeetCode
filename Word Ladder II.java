public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>() ;
        ladderLength(start,  end, dict, result);
        return result; 
    }
    
    public void ladderLength(String start, String end, HashSet<String> dict, ArrayList<ArrayList<String>> result) 
    {
            // Start typing your Java solution below
          // DO NOT write main() function
        if(start.length()!=end.length()) return ; 
        ArrayList<String> newStart=new ArrayList<String>();
	    newStart.add(start);
        boolean flag=false;
        ArrayList<ArrayList<String>> tempResult=new  ArrayList<ArrayList<String>>(); 
        tempResult.add(newStart);
        ArrayList<ArrayList<String>> subtempResult=new  ArrayList<ArrayList<String>>(); 
	    for(int index=0; index<tempResult.size(); index++  )
	    {	
            newStart=tempResult.get(index);
	        String current=newStart.get(newStart.size()-1);        
	        for(int i=0; i<current.length(); i++)
	        {
			    for(char j='a'; j<='z'; j++)
			    {
	        		if(current.charAt(i)==j) continue; 
	        		String temp=current.substring(0, i)+j+current.substring(i+1);        		
				    if(temp.equals(end))
                    {
                        newStart.add(temp);
                        result.add(new ArrayList<String>(newStart));
                        newStart.remove(newStart.size()-1);
                        flag=true; 
                        continue; 
                    }
				    if(dict.contains(temp) && !newStart.contains(temp))
				    {
	                    newStart.add(temp);
                        subtempResult.add(new ArrayList<String>(newStart));
                        newStart.remove(newStart.size()-1);
	    		    }
			    }
		    }
	        if(index==tempResult.size()-1)
	        {
                if(flag) break; 
                tempResult=new ArrayList<ArrayList<String>>(subtempResult); 
                subtempResult.clear();
                index=-1; 
	        }
	    }
	}
}


public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        if(start.length() != end.length()) return results;
        ArrayList<String> result = new ArrayList<String>();
        result.add(start);
        results.add(result);
        if(start.equals(end)) return results;
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        boolean found = false;
        ArrayList<ArrayList<String>> nextResults = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> foundResults = new ArrayList<ArrayList<String>>();
        for(int index = 0; index < results.size(); index++) {
			ArrayList<String> curResult = results.get(index);
			String cur = curResult.get(curResult.size()-1);
        	for(int i = 0; i < cur.length(); i++) {
        		for(char j = 'a'; j <= 'z'; j++) {
        			if(cur.charAt(i) == j) continue;
        			String next = cur.substring(0, i) + j + cur.substring(i+1);
        			if(dict.contains(next) && !visited.contains(next)) {
        				visited.add(next);
        				ArrayList<String> aresult = new ArrayList<String>(curResult);
						aresult.add(next);
						nextResults.add(aresult);
						if(next.equals(end)) {
							 found = true;
							 foundResults.add(aresult);
						}
        			}
        		}
        	}
        	if(index == results.size()-1) {
        		if(found) break;
        		results = nextResults;
        		nextResults = new ArrayList<ArrayList<String>>();
        		index = -1;
        	}
        }
        return foundResults;
    }
}


//pass OJ
public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {  
		ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();  
		if (start == null || end == null || start.length() == 0) return paths;  
	
		// maintain a hashmap for visited words  
		Map<String, ArrayList<Node>> visited = new HashMap<String, ArrayList<Node>>();  
   
		// BFS to find the minimum sequence length  
		getMinLength(start, end, dict, visited);  
   
		// DFS to back trace paths from end to start  
		buildPaths(end, start, visited, new LinkedList<String>(), paths);  
   
		return paths;  
	}  
   
	/* Use BFS to find the minimum transformation sequences length from start to end.  
	   Also store parent nodes from previous level for each visited valid word. */  
	private int getMinLength(String start, String end, HashSet<String> dict, Map<String, ArrayList<Node>> visited) {  
		// maintain a queue for words, depth and previous word during BSF  
		Queue<Node> queue = new LinkedList<Node>();  
		queue.add(new Node(start, 1));  
		// BFS  
		dict.add(end);  
		int lastLevel = 0;  
		while (!queue.isEmpty()) {  
			Node node = queue.poll();  
			if (lastLevel > 0 && node.depth >= lastLevel) break;  
			// find transformable words in next level  
			for (int i=0; i<node.word.length(); ++i) {  
				StringBuilder sb = new StringBuilder(node.word);  
				char original = sb.charAt(i);  
				for (char c='a'; c<='z'; ++c) {  
					if (c == original) continue;  
					sb.setCharAt(i, c);  
					String s = sb.toString();  
					// if hits end, mark the current depth as the last level  
					if (s.equals(end)) {  
						if (lastLevel == 0) lastLevel = node.depth + 1;  
					}  
					if (dict.contains(s) && !s.equals(start)) {  
						ArrayList<Node> pres = visited.get(s);  
						if (pres == null) {  
							// enqueue unvisited word  
							queue.add(new Node(s, node.depth+1));  
							pres = new ArrayList<Node>();  
							visited.put(s, pres);  
							pres.add(node);  
						} else if (pres.get(0).depth == node.depth) {  
							// parent nodes should be in the same level - to avoid circle in graph  
							pres.add(node);  
						}  
					}  
				}  
			}  
		}  
		return lastLevel;  
	}  
   
	/* Use DFS to back trace all paths from end to start. */  
	private void buildPaths(String s, String start, Map<String, ArrayList<Node>> visited,  
		LinkedList<String> path, ArrayList<ArrayList<String>> paths) {  
		if (s == null || visited == null || path == null || paths == null) return;  
   
		path.add(0, s);  
		if (s.equals(start)) {  
			ArrayList<String> p = new ArrayList<String>(path);  
			paths.add(p);  
		} else {  
			ArrayList<Node> pres = visited.get(s);  
			if (pres != null) {  
				for (Node pre : pres) {  
					buildPaths(pre.word, start, visited, path, paths);  
				}  
			}  
		}  
		path.remove(0);  
	}  
   
	private class Node {  
		String word;  
		int depth;  
		public Node(String w, int d) {  
			word = w; depth = d;  
		}  
	}  
}


public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {  
		ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();  
		//if (start == null || end == null || start.length() == 0) return paths;  
	
		// maintain a hashmap for visited words  
		Map<String, ArrayList<Node>> visited = new HashMap<String, ArrayList<Node>>();  
   
		// BFS to find the minimum sequence length  
		getMinLength(start, end, dict, visited);  
   
		// DFS to back trace paths from end to start  
		buildPaths(end, start, visited, new LinkedList<String>(), paths);  
   
		return paths;  
	}  
   
	/* Use BFS to find the minimum transformation sequences length from start to end.  
	   Also store parent nodes from previous level for each visited valid word. */  
	private int getMinLength(String start, String end, HashSet<String> dict, Map<String, ArrayList<Node>> visited) {  
		// maintain a queue for words, depth and previous word during BSF  
		Queue<Node> queue = new LinkedList<Node>();  
		queue.add(new Node(start, 1));  
		// BFS  
		//dict.add(end);  
		int lastLevel = 0;  
		while (!queue.isEmpty()) {  
			Node node = queue.poll();  
			if (lastLevel > 0 && node.depth >= lastLevel) break;  
			// find transformable words in next level  
			for (int i=0; i<node.word.length(); ++i) {  
				StringBuilder sb = new StringBuilder(node.word);  
				char original = sb.charAt(i);  
				for (char c='a'; c<='z'; ++c) {  
					if (c == original) continue;  
					sb.setCharAt(i, c);  
					String s = sb.toString();  
					// if hits end, mark the current depth as the last level  
					if (s.equals(end)) {  
						if (lastLevel == 0) lastLevel = node.depth + 1;  
					}  
					if (dict.contains(s) && !s.equals(start)) {  
						ArrayList<Node> pres = visited.get(s);  
						if (pres == null) {  
							// enqueue unvisited word  
							queue.add(new Node(s, node.depth+1));  
							pres = new ArrayList<Node>();  
							visited.put(s, pres);  
							pres.add(node);  
						} else if (pres.get(0).depth == node.depth) {  
							// parent nodes should be in the same level - to avoid circle in graph  
							pres.add(node);  
						}  
					}  
				}  
			}  
		}  
		return lastLevel;  
	}  
   
	/* Use DFS to back trace all paths from end to start. */  
	private void buildPaths(String s, String start, Map<String, ArrayList<Node>> visited,  
		LinkedList<String> path, ArrayList<ArrayList<String>> paths) {  
		//if (s == null || visited == null || path == null || paths == null) return;  
   
		path.add(0, s);  
		if (s.equals(start)) {  
			ArrayList<String> p = new ArrayList<String>(path);  
			paths.add(p);  
		} else {  
			ArrayList<Node> pres = visited.get(s);  
			if (pres != null) {  
				for (Node pre : pres) {  
					buildPaths(pre.word, start, visited, path, paths);  
				}  
			}  
		}  
		path.remove(0);  
	}  
   
	private class Node {  
		String word;  
		int depth;  
		public Node(String w, int d) {  
			word = w; depth = d;  
		}  
	}  
}


public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        if(start.length() != end.length()) return paths;
        LinkedList<String> path = new LinkedList<String>();
        if(start.equals(end)) {
            path.add(start);
            paths.add(new ArrayList<String>(path));
            return paths;
        }
        HashMap<String, ArrayList<Node>> visited = new HashMap<String, ArrayList<Node>>();
        bfs(start, end, dict, visited);
        buildPaths(end, start, visited, path, paths);
        return paths;
    }
    
    private void bfs(String start, String end, HashSet<String> dict, HashMap<String, ArrayList<Node>> visited) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(start, 1));
        int lastLevel = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(lastLevel > 0 && node.depth >= lastLevel) break;
            String word = node.word;
            for(int i = 0; i < word.length(); i++) {
                for(char j = 'a'; j <= 'z'; j++) {
                    if(word.charAt(i) == j) continue;
                    String next = word.substring(0, i) + j + word.substring(i+1);
                    if(next.equals(end) && lastLevel == 0) lastLevel = node.depth+1;
                    if(dict.contains(next) && !next.equals(start)) {
                        ArrayList<Node> parents = visited.get(next);
                        if(parents == null) {
                            queue.add(new Node(next, node.depth+1));
                            parents = new ArrayList<Node>();
                            parents.add(node);
                            visited.put(next, parents);
                        } else if(parents.get(0).depth == node.depth) parents.add(node); 
                    }
                }
            }
        }
    }
    
    private void buildPaths(String s, String start, HashMap<String, ArrayList<Node>> visited,
        LinkedList<String> path, ArrayList<ArrayList<String>> paths) {
        path.add(0, s);
        if(s.equals(start)) {
            paths.add(new ArrayList<String>(path));
        } else {
            ArrayList<Node> parents = visited.get(s);
            if(parents != null) {
                for(Node parent : parents) {
                    buildPaths(parent.word, start, visited, path, paths);
                }
            }
        }
        path.remove(0);
    }
    
    private class Node {
        String word;
        int depth;
        public Node(String w, int d) {
            word = w;
            depth = d;
        }
    }
}



















