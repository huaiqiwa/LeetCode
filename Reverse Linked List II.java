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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null; 
        ListNode runner=head, first=null; 
        ArrayList<Integer> list=new ArrayList<Integer>(); 
        while(runner!=null && ( m>0 || n>0 ) )
        {
            if(m==1) first=runner; 
            if(m<=1) list.add(runner.val);
            m--; n--; runner=runner.next;
        }
        for(int i=list.size()-1; i>=0; i--)
        {
            first.val=list.get(i);
            first=first.next; 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dumb = new ListNode(Integer.MIN_VALUE);
        dumb.next = head;
        ListNode start = dumb;
        for(int i = 0; i < m-1; i++) {
        	start = start.next;
        }
        
        ListNode end = start.next;
        ListNode cur = start.next.next;
        for(int i = 0; i < n-m; i++) {
        	ListNode tempNext = cur.next;
        	if(i == n-m-1) end.next = tempNext;
        	cur.next = start.next;
        	start.next = cur;
        	cur = tempNext;
        }
        
        return dumb.next;
    }
    
}


public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        for(int i = 0; i < m-1; i++) {
            start = start.next;
        }
        
        ListNode end = start.next;
        ListNode cur = start.next.next;
        for(int i = 0; i < n-m; i++) {
            ListNode next = cur.next;
            cur.next = start.next;
            start.next = cur;
            cur = next;
            if(i == n-m-1) end.next = next;
        }
        return dummy.next;
    }
}










