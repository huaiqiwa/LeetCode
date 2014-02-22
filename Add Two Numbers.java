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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return addTwo(l1,  l2, 0); 
    }
    ListNode addTwo(ListNode l1, ListNode l2, int carry)
    {
        if(l1==null && l2==null && carry==0) return null; 
        if(l1==null && l2==null && carry==1) return new ListNode(1);
        int a=0, b=0; 
        if(l1!=null) a=l1.val; 
        if(l2!=null) b=l2.val;
        int sum=a+b+carry; 
        ListNode head=new ListNode(sum%10);
        head.next=addTwo((l1!=null? l1.next: null), (l2!=null? l2.next: null), sum/10 );
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int carry = 0;
        while(l1 != null || l2 != null) {
        	int a = l1 == null ? 0 : l1.val;
        	int b = l2 == null ? 0 : l2.val;
        	int c = (a+b+carry) % 10;
        	cur.next = new ListNode(c);
        	cur = cur.next;
        	carry = (a+b+carry) / 10;
        	if(l1 != null) l1 = l1.next;
        	if(l2 != null) l2 = l2.next;
        }
        if(carry != 0) cur.next = new ListNode(carry);
    	return result.next;
    }
}























