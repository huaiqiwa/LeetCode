/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null || head.next==null) return head; 
        ListNode runner=head.next; 
        ListNode pre=head; 
        while(runner!=null) {
            if(runner.val==pre.val) {
                pre.next=runner.next; 
            } else {
                pre=runner; 
            }
            runner=runner.next; 
        }
        return head; 
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumb = new ListNode(Integer.MIN_VALUE);
        dumb.next = head;
        ListNode curNode = dumb;
        while(curNode != null && curNode.next != null) {
        	ListNode nextNode = curNode.next;
        	while(nextNode != null && nextNode.val == curNode.val) {
        		nextNode = nextNode.next;
        	}
        	curNode.next = nextNode;
        	curNode = nextNode;
        }       
        return dumb.next;
    }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}














