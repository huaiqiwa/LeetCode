public class Trie {
	TrieNode root;
	
	public Trie() {
		root = new TrieNode(' ');
	}
	
	public Trie(TrieNode r) {
		root = r;
	}
	
	public void insert(String s) {
		TrieNode crawl = root;
		for(int i = 0; i < s.length(); i++) {
			HashMap<Character, TrieNode> crawlMap = crawl.map;
			if(crawlMap.containsKey(s.charAt(i))) {
				crawl = crawlMap.get(s.charAt(i));
			} else {
				TrieNode node = new TrieNode(s.charAt(i));
				crawlMap.put(s.charAt(i), node);
				crawl = node;
			} 
		}
		crawl.isEnd = true;
	}
	
	public boolean search(String s) {
		TrieNode crawl = root;
		for(int i = 0; i < s.length(); i++) {
			HashMap<Character, TrieNode> crawlMap = crawl.map;
			if(crawlMap.containsKey(s.charAt(i))) {
				crawl = crawlMap.get(s.charAt(i));
			} else {
				return false;
			}
		}
		if(crawl.isEnd) return true;
		return false;
	}
		
	class TrieNode {
		char index;
		HashMap<Character, TrieNode> map;
		boolean isEnd;
		
		TrieNode(char i) {
			index = i;
			map = new HashMap<Character, TrieNode>();
			isEnd = false;
		}
	}	
}