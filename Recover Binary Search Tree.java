/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 in order tranvserse 
 */
public class Solution {
    TreeNode n1; 
    TreeNode n2; 
    TreeNode pre; 
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        n1=null; n2=null; pre=null; 
        inOrder(root);
        if(n1!=null && n2!=null)
        {
         int temp=n1.val;
         n1.val=n2.val; 
         n2.val=temp; 
        }
    }
    void inOrder(TreeNode root)
    {
        if(root==null) return ; 
        inOrder(root.left);
        if(pre!=null && pre.val>root.val)
        {
            /*
            start from n2=root; 
            */
            n2=root; 
            if(n1==null)
            {
                n1=pre; 
            }
        }
        pre=root; 
        inOrder(root.right);
    }
    
}


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
	private TreeNode pre;
	private TreeNode n1;
	private TreeNode n2;
    public void recoverTree(TreeNode root) {
    	pre = null;
    	n1 = null;
    	n2 = null;
        recoverT(root);
        int tempVal = n1.val;
        n1.val = n2.val;
        n2.val = tempVal;
    }
    
    private void recoverT(TreeNode root) {
    	if(root == null) return;
        recoverT(root.left);
        if(pre != null && pre.val > root.val) {
        	if(n1 == null) n1 = pre;
        	n2 = root;
        }
        pre = root;
        recoverT(root.right);
    }
}


public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode previous = null, n1 = null, n2 = null;
        TreeNode cur = root;
        while(cur != null) {
        	if(cur.left != null) {
        		TreeNode pre = cur.left;
        		while(pre.right != null && pre.right != cur) {
        			pre = pre.right;
        		}
        		if(pre.right == null) {
        			pre.right = cur;
        			cur = cur.left;
        		} else {
        			pre.right = null;
        			if(previous.val > cur.val) {
        				if(n1 == null) n1 = previous;
        				n2 = cur;
        			}
        			previous = cur;
        			cur = cur.right;
        		}
        	} else {
        		if(previous != null && previous.val > cur.val) {
        			if(n1 == null) n1 = previous;
        			n2 = cur;
        		}
        		previous = cur;
        		cur = cur.right;
        	}
        }
        int tempVal = n1.val;
        n1.val = n2.val;
        n2.val = tempVal;
    }
}





















