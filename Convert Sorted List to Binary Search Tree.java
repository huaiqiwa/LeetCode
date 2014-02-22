/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode cur; 
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null; 
        cur=head; 
        int length=0; 
        while(head!=null)
        {
            head=head.next; 
            length++; 
        }
        return toBst(0, length-1);
    }
    TreeNode toBst(int start, int end)
    {
        if(start>end) return null; 
        int mid=start+(end-start)/2;
        TreeNode left=toBst(start , mid-1);
        TreeNode root=new TreeNode(cur.val);
        cur=cur.next; 
        TreeNode right=toBst(mid+1, end);
        root.left=left; 
        root.right=right;
        return root;
    }
}


//another similar solution

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode pre; 
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        pre=head; 
        ListNode first=head;
        int count=0; 
        while(first!=null)
        {
            count++; first=first.next; 
        }
        return formedBST(0, count);
    }
    TreeNode formedBST(int start, int end)
    {
        if(start>end) return null; 
        int mid=start+(end-start)/2;
        TreeNode left=formedBST(start, mid-1);
        if(pre==null) return null; 
        TreeNode root=new TreeNode(pre.val);
        pre=pre.next; 
        TreeNode right=formedBST(mid+1, end);
        root.left=left; 
        root.right=right; 
        return root; 
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        int listSize = 0;
        cur = head;
        while(head != null) {
        	listSize++;
        	head = head.next;
        }
        return sortedListToBST(0, listSize-1);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
    	if(start > end) return null;
    	int mid = start + (end-start)/2;
    	TreeNode leftChild = sortedListToBST(start, mid-1);
    	TreeNode parent = new TreeNode(cur.val);
    	cur = cur.next;
    	TreeNode rightChild = sortedListToBST(mid+1, end);
    	parent.left = leftChild;
    	parent.right = rightChild;
    	return parent;
    }
}



















