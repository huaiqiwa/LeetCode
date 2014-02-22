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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy=new ListNode(0);
        dummy.next=head; 
        ListNode run=dummy; 
        while(head!=null && head.next!=null )
        {
            ListNode next=head.next; 
            ListNode nextNext=head.next.next; 
            run.next=next; 
            run=run.next; 
            run.next=head; 
            run=run.next; 
            head.next=nextNext; 
            head=head.next; 
        }
        return dummy.next; 
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
    public ListNode swapPairs(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode dumb = new ListNode(Integer.MIN_VALUE);
        dumb.next = head;
        ListNode cur = dumb;
        while(cur != null && cur.next != null && cur.next.next != null) {
        	ListNode nextNode = cur.next.next.next;
        	ListNode temp = cur.next;
        	cur.next = cur.next.next;
        	cur.next.next = temp;
        	temp.next = nextNode;
        	cur = cur.next.next;
        }
        return dumb.next;
    }
}


public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next.next;
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = next;
            cur = temp;
        }
        return dummy.next;
    }
}
















