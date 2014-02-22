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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return ;
        TreeNode L=root.left; 
        TreeNode R=root.right; 
        if(L!=null)
        {           
            root.left=null; 
            root.right=L; 
            TreeNode rightM=rightMost(L);
            rightM.right=R;
            flatten(L);
        }else
        {
            flatten(R);
        }
    }
    TreeNode rightMost(TreeNode root)
    {
        if(root==null) return null; 
        TreeNode runner=root; 
        while(runner.right!=null)
        {
            runner=runner.right; 
        }
        return runner; 
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
    public void flatten(TreeNode root) {
        flattenRe(root);
    }
    
    private TreeNode flattenRe(TreeNode root) {
    	if(root == null) return null;
    	TreeNode ltree = root.left;
    	TreeNode rtree = root.right;
    	if(ltree != null) {
    		root.right = ltree;
    		root.left = null;
    		root = flattenRe(ltree);
    	}
    	if(rtree != null) {
    		root.right = rtree;
    		root = flattenRe(rtree);
    	}
    	return root;
    }
}


//non-recursive with stack
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> rtrees = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null) {
        	while(cur.left != null) {
        		if(cur.right != null) rtrees.push(cur.right);
        		cur.right = cur.left;
        		cur.left = null;
        		cur = cur.right;
        	} 
        	if(cur.right == null && !rtrees.empty()) {
        		cur.right = rtrees.pop();
        	}
        	cur = cur.right;
        }
    }
}


//non-recursive without stack
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
        	if(cur.left != null) {
        		if(cur.right != null) {
        			TreeNode next = cur.left;
        			while(next.right != null) next = next.right;
        			next.right = cur.right;
        		}
        		cur.right = cur.left;
        		cur.left = null;
        	}
        	cur = cur.right;
        }
    }
}





























