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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE); 
    }
    
    boolean isValid(TreeNode root, int max, int min)
    {
        if(root==null) return true; 
        if(root.val>=max || root.val<=min) return false; 
        boolean left=isValid(root.left, root.val, min);
        boolean right=isValid(root.right, max, root.val);
        if(left && right) return true; 
        return false; 
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
    public boolean isValidBST(TreeNode root) {
    	//Assume no node.val == Integer.MIN_VALUE or Integer.MAX_VALUE
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int min, int max) {
    	if(root == null) return true;
    	if(root.val <= min || root.val >= max) return false;
    	boolean isLeft = isValidBST(root.left, min, root.val);
    	boolean isRight = isValidBST(root.right, root.val, max);
    	if(isLeft && isRight) return true;
    	return false;
    }
}


public class Solution {
    public boolean isValidBST(TreeNode root) {
    	//Assume no node.val == Integer.MIN_VALUE or Integer.MAX_VALUE
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}


public class Solution {
    public boolean isValidBST(TreeNode root) {
    	//this will handle node.val == Integer.MIN_VALUE or Integer.MAX_VALUE
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}


















