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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null || n==0) return head; 
        ListNode runner=head; 
        while(n!=0)
        {
            runner=runner.next; n--; 
        }
        if(runner==null) return head.next; 
        ListNode cur=head; 
        while(runner.next!=null)
        {
            runner=runner.next; 
            cur=cur.next; 
        }
        cur.next=cur.next.next; 
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode dumb = new ListNode(Integer.MIN_VALUE);
        dumb.next = head;
        ListNode curNode = dumb;
        ListNode runner = dumb;
        for(int i = 0; i < n; i++) {
        	runner = runner.next;
        }
        while(runner.next != null) {
        	curNode = curNode.next;
        	runner = runner.next;
        }
        curNode.next = curNode.next.next;
        return dumb.next;
    }
}

















