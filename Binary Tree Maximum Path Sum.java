public class Solution {
    int max; 
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        max=Integer.MIN_VALUE; 
        maxSum(root);
        return max; 
    }
    int maxSum(TreeNode root)
    {
        if(root==null) return 0; 
        int L=maxSum(root.left);
        int R=maxSum(root.right);
        int subMax=Math.max(Math.max(root.val ,L+R+root.val),root.val+ Math.max(L, R));
        max=Math.max(max,subMax);
        return Math.max(root.val, root.val+Math.max(L, R));
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
	private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSumRe(root);
        return max;
    }
    
    private int maxPathSumRe(TreeNode node) {
    	if(node == null) return 0;
    	int L = maxPathSumRe(node.left);
    	int R = maxPathSumRe(node.right);
    	int curMax = node.val;
    	if(L > 0) curMax += L;
    	if(R > 0) curMax += R;
    	if(curMax > max) max = curMax;
    	return (L>0 && R>0) ? Math.max(L, R)+node.val : curMax;
    }
}


























