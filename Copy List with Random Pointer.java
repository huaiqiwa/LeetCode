/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null) return null;
    	RandomListNode cur = head;
        RandomListNode curcopy = new RandomListNode(cur.label);
        RandomListNode headcopy = curcopy;
        HashMap<RandomListNode, RandomListNode> copied = new HashMap<RandomListNode, RandomListNode>();
        copied.put(cur, curcopy);
        while(cur != null) {
        	RandomListNode curcopynext = null;
        	RandomListNode curcopyran = null;
        	if(cur.next != null) {
        		if(!copied.containsKey(cur.next)) {
        			curcopynext = new RandomListNode(cur.next.label);
        			copied.put(cur.next, curcopynext);
        		}
        		else curcopynext = copied.get(cur.next);
        	}
        	if(cur.random != null) {
        		if(!copied.containsKey(cur.random)) {
        			curcopyran = new RandomListNode(cur.random.label);
        			copied.put(cur.random, curcopyran);
        		}
        		else curcopyran = copied.get(cur.random);
        	}
        	curcopy.next = curcopynext;
        	curcopy.random = curcopyran;
        	curcopy = curcopy.next;
        	cur = cur.next;
        }
        return headcopy;
    }
}


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode cur = head;
        while(cur != null) {
        	RandomListNode curcopy = new RandomListNode(cur.label);
        	curcopy.next = cur.next;
        	cur.next = curcopy;      	
        	cur = cur.next.next;
        }
        
        cur = head;
        while(cur != null) {
        	if(cur.random != null) cur.next.random = cur.random.next;
        	cur = cur.next.next;
        }
        
        RandomListNode headcopy = head.next;
        cur = head;
        while(cur != null) {
        	RandomListNode curcopy = cur.next;
        	cur.next = cur.next.next;
        	curcopy.next = curcopy.next != null ? curcopy.next.next : null;
        	cur = cur.next;
        }
        return headcopy;
    }
}

























