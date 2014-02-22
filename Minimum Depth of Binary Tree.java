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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0; 
        if(root.left==null && root.right==null) return 1; 
        if(root.left==null || root.right==null) 
        return 1+Math.max(minDepth(root.left), minDepth(root.right));
        return 1+Math.min(minDepth(root.left), minDepth(root.right));
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
    public int minDepth(TreeNode root) {
    	if(root == null) return 0;
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if(root.left == null || root.right == null) return Math.max(leftMin, rightMin) + 1;
        return Math.min(leftMin, rightMin) + 1;
    }
}

























