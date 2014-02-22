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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode cur = head;
        ListNode runner = head.next;
        while(runner != null && runner.next != null) {
        	if(cur == runner) return true;
        	cur = cur.next;
        	runner = runner.next.next;
        }
        return false;
    }
}