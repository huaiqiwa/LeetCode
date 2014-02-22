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
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        
        ListNode cur = second.next;
        second.next = null;
        while(cur != null) {
        	ListNode next = cur.next;
        	cur.next = second;
        	second = cur;
        	cur = next;
        }
        
        ListNode dummy = new ListNode(0);
        cur = dummy;
        while(first != null || second != null) {
        	if(first != null) {
        		cur.next = first;
        		first = first.next;
        		cur = cur.next;
        		cur.next = null;
        	}
        	if(second != null) {
        		cur.next = second;
        		second = second.next;
        		cur = cur.next;
        		cur.next = null;
        	}
        }
    }
}


public class Solution {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //slice the list into two halves
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        
        //reverse the second half of the list
        dummy.next = null;
        ListNode cur = second;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        
        //merge the first half and the reversed second half
        second = dummy.next;
        dummy.next = null;
        cur = dummy;
        while(first != null || second != null) {
            if(first != null) {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            }
            if(second != null) {
                cur.next = second;
                second = second.next;
                cur = cur.next;
            }
        }
    }
}











