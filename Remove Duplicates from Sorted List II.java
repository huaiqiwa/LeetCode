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
        ListNode dummy=new ListNode(0); 
        dummy.next=head;
        boolean det=false; 
        ListNode pre=dummy; 
        ListNode wait=head; 
        ListNode runner=head.next; 
        while(runner!=null)
        {
            if(runner.val==wait.val)
            {
                det=true; 
                wait.next=runner.next; 
            }else
            {
                if(det)
                {
                    pre.next=runner; 
                    wait=runner;
                    det=false; 
                }else
                {
                    pre=wait; 
                    wait=runner;
                }
            }
            runner=runner.next; 
        }
        if(det) pre.next=null; 
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
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode dumb = new ListNode(Integer.MIN_VALUE);
        dumb.next = head;
        ListNode curNode = dumb;
        boolean hasDup = false;
        while(curNode != null && curNode.next != null && curNode.next.next != null) {
        	if(curNode.next.val == curNode.next.next.val) {
        		curNode.next = curNode.next.next;
        		hasDup = true;
        	} else {
        		if(!hasDup) {
        			curNode = curNode.next;
        		} else {
        			curNode.next = curNode.next.next;
        		}
        		hasDup = false;
        	}
        }
        if(hasDup) curNode.next = null;
        return dumb.next;
    }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                ListNode runner = cur.next.next.next;
                while(runner != null && runner.val == cur.next.val) {
                    runner = runner.next;
                }
                cur.next = runner;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}



















