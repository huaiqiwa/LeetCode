public static Node segregatLinkedList(Node head)
  {
		if(head==null) return head ;
		Node dummyEven=new Node(0);
		dummyEven.next=head; 
		Node pre=dummyEven; 
		Node dummyOdd=new Node(0);
		Node dummyOddRun=dummyOdd;
		while(head!=null)
		{
			if(head.val%2==0)
			{
				pre=head; 
				head=head.next; 
				}
			else
			{
				Node next=head.next; 
				dummyOddRun.next=head; 
				dummyOddRun=dummyOddRun.next; 
				dummyOddRun.next=null;
				pre.next=next; 
				head=next; 
			}
		}
		if(pre!=null) pre.next=dummyOdd.next; 
		return dummyEven.next; 
	}


//http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
public ListNode segregateEvenOdd(ListNode head) {
	if(head == null || head.next == null) return head;
	ListNode dummyEven = new ListNode(0);
	ListNode dummyOdd = new ListNode(0);
	ListNode curEven = dummyEven, curOdd = dummyOdd;
	while(head != null) {
		if(head.val % 2 == 0) {
			curEven.next = head;
			curEven = curEven.next;
		} else {
			curOdd.next = head;
			curOdd = curOdd.next;
		}
		head = head.next;
	}
	curEven.next = dummyOdd.next;
	curOdd.next = null;
	return dummyEven.next;
}






























