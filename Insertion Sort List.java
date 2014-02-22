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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while(cur != null) {
        	ListNode curInSort = dummy;
        	ListNode next = cur.next;
        	while(curInSort.next != null) {
        		if(curInSort.val <= cur.val && cur.val <= curInSort.next.val) break;
        		curInSort = curInSort.next;
        	}
        	cur.next = curInSort.next;
        	curInSort.next = cur;
        	cur = next;
        }
        return dummy.next;
    }
}