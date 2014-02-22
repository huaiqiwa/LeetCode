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
 
 /*
 
     		Comparator<Integer> comp=new Comparator<Integer>()
			{
				public int compare(Integer a, Integer b)
				{
					return a==b? 0: (a>b? 1: -1) ; 
				}
			}; //create a min heap
            
            Comparator<Point> comp=new Comparator<Point>()
			{
				public int compare(Point a, Point b)
				{
					  double aToO=getDistance(a); 
					  double bToO=getDistance(b); 
					  return aToO==bToO? 0: (aToO<bToO? 1: -1);
				}
			 }; //create a max heap, 
            
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists.size()==0) return null; 
        Comparator<ListNode> comp=new Comparator<ListNode>()
        {
            @Override
            public int compare(ListNode l1, ListNode l2)
            {
                return new Integer (l1.val).compareTo(new Integer (l2.val)); 
            }
        }; //minheap
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(lists.size(), comp);
        //create a priorityQueue by using size and comparator
        for(int i=0; i<lists.size(); i++)
        {
            ListNode node=lists.get(i);
            if(node!=null)
            pq.add(node);
        }
        ListNode head=null, cur=null; 
        while(!pq.isEmpty())
        {
            if(head==null)
            {
                head=pq.poll(); 
                cur=head; 
                if(cur.next!=null)
                {
                    pq.add(cur.next);
                }
            }else
            {
                ListNode newNode=pq.poll();
                cur.next=newNode;
                cur=newNode; 
                if(cur.next!=null)
                {
                    pq.add(cur.next);
                }
            }
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0) return null;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val-n2.val;
            }    
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), comparator);
        for(int i = 0; i < lists.size(); i++) {
            ListNode cur = lists.get(i);
            if(cur != null) pq.offer(cur);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
            ListNode curMin = pq.poll();
            cur.next = curMin;
            cur = cur.next;
            if(cur.next != null) pq.offer(cur.next);
        }
        return dummy.next;
    }
}

























