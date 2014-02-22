/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
    	if(head == null || head.next == null) return head;
        ListNode secondHead = divideList(head);
        ListNode firstSorted = sortList(head);
        ListNode secondSorted = sortList(secondHead);
        return mergeList(firstSorted, secondSorted);
    }
    
    private ListNode divideList(ListNode head) {
    	if(head == null) return null;
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	ListNode secondHead = slow.next;
    	slow.next = null;
    	return secondHead;
    }
    
    private ListNode mergeList(ListNode first, ListNode second) {
    	if(first == null) return second;
    	if(second == null) return first;
    	ListNode dummy = new ListNode(Integer.MIN_VALUE);
    	ListNode cur = dummy;
    	while(first != null && second != null) {
    		if(first.val > second.val) {
    			cur.next = second;
    			second = second.next;
    			cur = cur.next;
    			cur.next = null;
    		} else {
    			cur.next = first;
    			first = first.next;
    			cur = cur.next;
    			cur.next = null;
    		}
    	}
    	if(first != null) cur.next = first;
    	else cur.next = second;
    	return dummy.next;
    }
}


public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode secondHead = divideList(head);
        ListNode firstSorted = sortList(head);
        ListNode secondSorted = sortList(secondHead);
        return mergeList(firstSorted, secondSorted);
    }
    
    private ListNode divideList(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        return secondHead;
    }
    
    private ListNode mergeList(ListNode first, ListNode second) {
        if(first == null) return second;
        if(second == null) return first;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(first != null && second != null) {
            if(first.val > second.val) {
                cur.next = second;
                second = second.next;
                cur = cur.next;
            } else {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            }
        }
        cur.next = (first != null ? first : second);
        return dummy.next;
    }
}


public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode secondHead = divideList(head);
        ListNode firstSorted = sortList(head);
        ListNode secondSorted = sortList(secondHead);
        return mergeList(firstSorted, secondSorted);
    }
    
    private ListNode divideList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        return secondHead;
    }
    
    private ListNode mergeList(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(first != null && second != null) {
            if(first.val > second.val) {
                cur.next = second;
                second = second.next;
                cur = cur.next;
            } else {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            }
        }
        cur.next = (first != null ? first : second);
        return dummy.next;
    }
}








