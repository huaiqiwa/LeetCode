/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return ; 
        TreeLinkNode r=root;
        while(r!=null)
        {
            TreeLinkNode l=r; 
            while(l!=null)
            {
                if(l.left!=null) l.left.next=l.right;
                if(l.right!=null &&l.next!=null )
                {
                    l.right.next=l.next.left;
                }
                l=l.next; 
            }
            r=r.left;
        }

    }
}


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode curLevelLeftMost = root;
        while(curLevelLeftMost.left != null) {
        	TreeLinkNode cur = curLevelLeftMost;
        	while(cur != null) {
				if(cur.left != null) cur.left.next = cur.right;
				if(cur.right != null && cur.next != null) cur.right.next = cur.next.left;
				cur = cur.next;
        	}
        	curLevelLeftMost = curLevelLeftMost.left;
        }
    }
}


























