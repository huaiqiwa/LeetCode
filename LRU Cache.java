public class LRUCache {
	HashMap<Integer, DListNode> cache;
	DListNode dummy;
	int capacity;
	int count;

	public LRUCache(int capacity) {
		cache = new HashMap<Integer, DListNode>();
		dummy = new DListNode(-1, -1);
		dummy.next = dummy;
		dummy.pre = dummy;
		this.capacity = capacity;
		count = 0;
	}
	
	public int get(int key) {
		if(cache.containsKey(key)) {
			DListNode cur = cache.get(key);
			deleteNode(cur);
			addLast(cur);
			return cur.val;
		} else return -1;
	}
	
	public void set(int key, int value) {
		DListNode cur = cache.get(key);
		if(cur == null) {
			cur = new DListNode(key, value);
			cache.put(key, cur);
			count++;
		} else {
			cur.val = value;
			deleteNode(cur);
		}
		if(count > capacity) {
			cache.remove(dummy.next.key);
			deleteNode(dummy.next);
			count--;
		}
		addLast(cur);
	}
	
	private void deleteNode(DListNode node) {
	    node.pre.next = node.next;
	    node.next.pre = node.pre;
	}
	
	private void addLast(DListNode node) {
	    node.next = dummy;
	    node.pre = dummy.pre;
	    node.pre.next = node;
	    node.next.pre = node;
	}
	
	class DListNode {
		DListNode pre;
		DListNode next;
		int key;
		int val;
		DListNode(int k, int v) {
			key = k;
			val = v;
		}
	}
}