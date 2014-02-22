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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return find(num, 0, num.length-1);
    }
    TreeNode find(int[] num, int start, int end)
    {
        if(start>end) return null; 
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(num[mid]);
        root.left=find(num, start, mid-1);
        root.right=find(num, mid+1, end);
        return root; 
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
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }
    
    private TreeNode sortedArrayToBST(int[] num, int start, int end) {
    	if(start > end) return null;
    	int mid = start + (end-start)/2;
    	TreeNode cur = new TreeNode(num[mid]);
    	cur.left = sortedArrayToBST(num, start, mid-1);
    	cur.right = sortedArrayToBST(num, mid+1, end);
    	return cur;
    }
}


























