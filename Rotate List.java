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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||n==0) return head; 
        int length=0;
        ListNode run=head; 
        while(run!=null)
        {
            length++; 
            run=run.next; 
        }
        n=n%length;
        if(n==0) return head; 
        run=head; 
        while(run!=null && n!=0)
        {
            run=run.next; n--; 
        }
        if(run==null) return head; 
        ListNode pre=head; 
        while(run.next!=null)
        {
            pre=pre.next; run=run.next; 
        }
        ListNode newHead=pre.next; 
        run.next=head; 
        pre.next=null; 
        return newHead; 
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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null || n <= 0) return head;
        ListNode cur = head, runner = head;
        int k = 0;
        while(runner != null) {
        	runner = runner.next;
        	k++;
        }
        if(n % k == 0) return head;
        
        if(n > k) n = n % k;       
        runner = head;
        for(int i = 0; i < n; i++) {
        	runner = runner.next;
        }
        while(runner.next != null) {
        	cur = cur.next;
        	runner = runner.next;
        }
        runner.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
}



















