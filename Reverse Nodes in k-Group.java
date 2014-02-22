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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(k==0||k==1||head==null) return head; 
        int count=0;
        ListNode dummy=new ListNode(0);
        dummy.next=head; 
        ListNode pre=dummy;
        while(head!=null)
        {
            count++; 
            ListNode next=head.next; 
            if(count%k==0)
            {
                pre=reverse(pre, head.next);
            }
            head=next; 
        }
        return dummy.next;
    }
    ListNode reverse(ListNode pre, ListNode next)
    {
        ListNode preNode=pre.next; 
        ListNode second=pre.next.next; 
        while(second!=next)
        {
            ListNode first=pre.next; 
            ListNode nextNode=second.next; 
            pre.next=second;
            second.next=first; 
            preNode.next=nextNode; 
            second=nextNode; 
        }
        return preNode; 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur != null) {
        	ListNode runner = cur;
        	for(int i = 0; i < k && runner != null; i++) {
        		runner = runner.next;
        	}
        	if(runner == null) break;
        	ListNode nextCur = cur.next;
			ListNode next = runner.next;
			runner.next = null;
        	runner = cur.next;
        	while(runner != null) {
        		ListNode curNext = cur.next;
        		ListNode runnerNext = runner.next;
        		cur.next = runner;
        		runner.next = curNext;
        		runner = runnerNext;
        	}
        	cur = nextCur;
        	cur.next = next;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0 || k == 1) return head;
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while(cur != null) {
        	if(count == k) {
        		ListNode next = cur.next;
        		pre = reverseList(pre, cur.next);
        		pre.next = next;
        		cur = pre;
        		count = 0;
        	} else {
        		cur = cur.next;
        		count++;
        	}
        }
        return dummy.next;
    }
    
    private ListNode reverseList(ListNode pre, ListNode next) {
    	ListNode nextPre = pre.next;
    	ListNode cur = pre.next;
    	while(cur != next) {
    		ListNode curNext = cur.next;
    		ListNode preNext = pre.next;
    		pre.next = cur;
    		cur.next = preNext;
    		cur = curNext;
    	}
    	return nextPre;
    }
}



public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre != null) {
            ListNode runner = pre;
            for(int i = 0; i < k && runner != null; i++) {
                runner = runner.next;
            }
            if(runner == null) break;
            ListNode nextHead = runner.next;
            ListNode end = pre.next;
            ListNode cur = pre.next.next;
            while(cur != nextHead) {
                ListNode next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = next;
            }
            end.next = nextHead;
            pre = end;
        }
        return dummy.next;
    }
}


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0 || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        int count = 0;
        while(cur != null) {
        	if(count == k) {
        		ListNode next = cur.next;
        		ListNode nextPre = pre.next;
        		reverseList(pre, cur.next);
        		pre = nextPre;
        		pre.next = next;
        		cur = next;
        		count = 1;
        	} else {
        		cur = cur.next;
        		count++;
        	}
        }
        return dummy.next;
    }
    
    private void reverseList(ListNode pre, ListNode after) {
        //k >= 2
    	ListNode cur = pre.next.next;
    	while(cur != after) {
    		ListNode curNext = cur.next;
    		cur.next = pre.next;
    		pre.next = cur;
    		cur = curNext;
    	}
    }
}







































